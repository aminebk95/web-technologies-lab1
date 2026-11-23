package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1.4.2 Q5 : ajoute, remplace et supprime un attribut d'application et un attribut de requete
public class AttributeTest extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext app = getServletContext();
        app.setAttribute("testApp", "v1");
        app.setAttribute("testApp", "v2");
        app.removeAttribute("testApp");

        request.setAttribute("testRequest", "v1");
        request.setAttribute("testRequest", "v2");
        request.removeAttribute("testRequest");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Application name: " + app.getAttribute("appName") + "</h2>");
        out.println("<p>Look at the Tomcat console.</p>");
        out.println("<p><a href='index.html'>Back</a></p>");
        out.println("</body></html>");
    }
}
