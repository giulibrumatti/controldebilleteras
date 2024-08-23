/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

/**
 *
 * @author Rombo del Tejar
 */
@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {
    
    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        listaUsuarios = control.getUsuarios();
        HttpSession misession = request.getSession();
        misession.setAttribute("listaUsuarios", listaUsuarios);
        System.out.println("Usuario:" + listaUsuarios.get(0));
        
        response.sendRedirect("verUsuarios.jsp");
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("nombreUs");
        String contra = request.getParameter("pass");
        
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contra);
        
        control.crearUsuario(0, usuario, contra);
        
        response.sendRedirect("SvUsuarios");
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
