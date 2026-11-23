package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1.1 : affiche les informations du formulaire dans un tableau
// 1.2 : cree 4 cookies (firstName, lastName, birthDay, sex)
public class FormServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        // URLEncoder car un cookie ne peut pas contenir d'espaces ou d'accents
        response.addCookie(new Cookie("firstName", URLEncoder.encode(firstName, "UTF-8")));
        response.addCookie(new Cookie("lastName", URLEncoder.encode(lastName, "UTF-8")));
        response.addCookie(new Cookie("birthDay", URLEncoder.encode(birthDay, "UTF-8")));
        response.addCookie(new Cookie("sex", sex));

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Received information</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>First name</th><th>Last name</th><th>Birth day</th><th>Sex</th></tr>");
        out.println("<tr><td>" + firstName + "</td><td>" + lastName + "</td><td>"
                + birthDay + "</td><td>" + sex + "</td></tr>");
        out.println("</table>");
        out.println("<p><a href='ReadCookie'>Read the cookies</a> | <a href='index.html'>Back</a></p>");
        out.println("</body></html>");
    }
}
