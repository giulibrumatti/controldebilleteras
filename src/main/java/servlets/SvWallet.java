
package servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Wallet;


@WebServlet(name = "SvWallet", urlPatterns = {"/SvWallet"})
public class SvWallet extends HttpServlet {
    Controladora control = new Controladora();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Wallet efectivo = control.traerWallet(1);
        Wallet banco = control.traerWallet(2);
        Wallet mp = control.traerWallet(3);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("efectivo", efectivo);
        misession.setAttribute("banco", banco);
        misession.setAttribute("mp", mp);
        
        response.sendRedirect("contIndex.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
