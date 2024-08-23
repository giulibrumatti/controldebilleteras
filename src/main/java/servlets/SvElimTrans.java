
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Transaccion;
import logica.TransaccionType;
import logica.Wallet;

@WebServlet(name = "SvElimTrans", urlPatterns = {"/SvElimTrans"})
public class SvElimTrans extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idTrans = Integer.parseInt(request.getParameter("idTrans"));
        Transaccion trans = control.traerTransaccion(idTrans);
        Wallet wa = trans.getWallet();
        if(!TransaccionType.DEPOSITAR.equals(trans.getType())){
            wa.depositar(trans.getAmount());
        }else{
            wa.retirar(trans.getAmount());
        }
        control.editarWallet(wa);
        control.borrarTransaccion(idTrans);
        response.sendRedirect("SvTransacciones");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
