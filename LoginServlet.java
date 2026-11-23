package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 1.4.1 Q4 : range le nom de l'utilisateur dans l'attribut de session "user"
// 1.4.3 : range aussi un objet SessionUser dans la session
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");

        HttpSession session = request.getSession();
        session.setAttribute("user", username);
        session.setAttribute("sessionUser", new SessionUser(username));

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Welcome " + username + ", you are logged in.</h2>");
        out.println("<p><a href='items.html'>Go to items.html</a></p>");
        out.println("<p><a href='LogoutServlet?remove=true'>Remove the session attributes</a></p>");
        out.println("<p><a href='LogoutServlet'>Log out (invalidate the session)</a></p>");
        out.println("</body></html>");
    }
}
