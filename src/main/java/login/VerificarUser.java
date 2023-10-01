
package login;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VerificarUser")
public class VerificarUser extends HttpServlet {
    
    UsuarioDAO usuDAO = new UsuarioDAO();
    boolean authenticated;
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String role = request.getParameter("role");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try {
            authenticated = usuDAO.verificarUser(username, password, role);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerificarUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        if (authenticated) {
            response.sendRedirect("entorno.jsp");
        } else {
            response.sendRedirect("index.html");
        }
    }
}
