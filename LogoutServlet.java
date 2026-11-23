package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// LogoutServlet?remove=true : supprime seulement les attributs "user" et "sessionUser"
// LogoutServlet             : detruit la session avec invalidate()
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            if (request.getParameter("remove") != null) {
                session.removeAttribute("user");
                session.removeAttribute("sessionUser");
            } else {
                session.invalidate();
            }
        }
        response.sendRedirect("login.html");
    }
}
