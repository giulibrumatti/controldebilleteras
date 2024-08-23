package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Transaccion;
import logica.TransaccionType;
import logica.Wallet;

@WebServlet(name = "SvTransacciones", urlPatterns = {"/SvTransacciones"})
public class SvTransacciones extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Transaccion> listaTrans = new ArrayList<Transaccion>();

        listaTrans = control.getTransacciones();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaTrans", listaTrans);

        response.sendRedirect("verTransacciones.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SimpleDateFormat formatoDate = new SimpleDateFormat("yyyy-MM-dd");
        String fechaJsp = request.getParameter("date");
        Date fechaT = null;
        try {
            fechaT = formatoDate.parse(fechaJsp);
        } catch (ParseException e) {
            request.setAttribute("errorMessage", "La fecha ingresada no es válida.");
            request.getRequestDispatcher("transaccionError.jsp").forward(request, response);
            return;
        }

        String tipoWallet = request.getParameter("wallet");
        String tipoTrans = request.getParameter("tipoTrans");
        String montoStr = request.getParameter("monto");
        int monto = 0;

        if (montoStr != null && !montoStr.isEmpty()) {
            try {
                monto = Integer.parseInt(montoStr);
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "La cantidad ingresada no es un número válido.");
                request.getRequestDispatcher("transaccionError.jsp").forward(request, response);
                return;
            }
        }

        Transaccion trans = new Transaccion();
        trans.setAmount(monto);
        trans.setDate(fechaT);

        Wallet wa = null;
        switch (tipoWallet) {
            case "MERCADOPAGO":
                wa = control.traerWallet(3);
                break;
            case "BANCO":
                wa = control.traerWallet(2);
                break;
            case "EFECTIVO":
                wa = control.traerWallet(1);
                break;
            default:
                request.setAttribute("errorMessage", "Tipo de billetera no válida.");
                request.getRequestDispatcher("transaccionError.jsp").forward(request, response);
                return;
        }

        trans.setWallet(wa);
        try {
            trans.setType("RETIRAR".equals(tipoTrans) ? TransaccionType.RETIRAR : TransaccionType.DEPOSITAR);
            trans.operar();
            control.crearTransaccion(0, monto, fechaT, trans.getType(), wa);
            response.sendRedirect("SvTransacciones");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "La cantidad ingresada no es válida.");
            request.getRequestDispatcher("transaccionError.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            request.setAttribute("errorMessage", "La cantidad ingresada no es válida.");
            request.getRequestDispatcher("transaccionError.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
