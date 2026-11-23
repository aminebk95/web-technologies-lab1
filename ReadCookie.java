package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1.2 Q3 : lit les cookies et affiche leurs valeurs
// doGet car on l'appelle avec un lien (un lien envoie une requete GET)
public class ReadCookie extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Cookies</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Name</th><th>Value</th></tr>");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                String name = c.getName();
                if (name.equals("firstName") || name.equals("lastName")
                        || name.equals("birthDay") || name.equals("sex")) {
                    String value = URLDecoder.decode(c.getValue(), "UTF-8");
                    out.println("<tr><td>" + name + "</td><td>" + value + "</td></tr>");
                }
            }
        }

        out.println("</table>");
        out.println("<p><a href='index.html'>Back</a></p>");
        out.println("</body></html>");
    }
}
