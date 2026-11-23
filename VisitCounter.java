package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 1.2 Q4 (Extra) : compte le nombre de visites avec un cookie
public class VisitCounter extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int visits = 0;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visits")) {
                    visits = Integer.parseInt(c.getValue());
                }
            }
        }
        visits++;

        Cookie cookie = new Cookie("visits", String.valueOf(visits));
        cookie.setMaxAge(60 * 60 * 24 * 365); // 1 an
        response.addCookie(cookie);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Number of visits: " + visits + "</h2>");
        out.println("<p>Refresh the page to increase the counter.</p>");
        out.println("<p><a href='index.html'>Back</a></p>");
        out.println("</body></html>");
    }
}
