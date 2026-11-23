package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 1.3.1 : Welcome / Welcome back + nombre de visites
// Extra : nom et date de naissance, nombre de jours avant l'anniversaire
// 1.4.2 Q2 : affiche le nombre de sessions actives
public class ShowSession extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Integer visits = (Integer) session.getAttribute("visits");
        if (visits == null) {
            visits = 0;
        }
        visits++;
        session.setAttribute("visits", visits);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        if (visits == 1) {
            out.println("<h2>Welcome on my site</h2>");
        } else {
            out.println("<h2>Welcome back</h2>");
        }
        out.println("<p>Number of visits: " + visits + "</p>");

        // Extra
        String fullName = (String) session.getAttribute("fullName");
        LocalDate birthDate = (LocalDate) session.getAttribute("birthDate");
        if (fullName == null) {
            out.println("<form action='ShowSession' method='post'>");
            out.println("Full name: <input type='text' name='fullName' required><br>");
            out.println("Date of birth (mm/dd/yyyy): <input type='text' name='birthDate' required"
                    + " pattern='[0-9]{2}/[0-9]{2}/[0-9]{4}'><br>");
            out.println("<input type='submit' value='Save'>");
            out.println("</form>");
        } else {
            LocalDate today = LocalDate.now();
            LocalDate nextBirthday = birthDate.withYear(today.getYear());
            if (nextBirthday.isBefore(today)) {
                nextBirthday = nextBirthday.plusYears(1);
            }
            long days = ChronoUnit.DAYS.between(today, nextBirthday);
            out.println("<p>Hi, " + fullName + ". There are " + days + " days to your birthday.</p>");
        }

        // 1.4.2 Q2 : valeur mise a jour par ActiveSessionListener
        out.println("<p>Active sessions: " + getServletContext().getAttribute("activeSessions") + "</p>");

        out.println("<p><a href='ShowSession'>Visit again</a> | "
                + "<a href='LogoutServlet'>Invalidate the session</a></p>");
        out.println("</body></html>");
    }

    // le formulaire de l'Extra envoie le nom et la date de naissance
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"), format);

        session.setAttribute("fullName", request.getParameter("fullName"));
        session.setAttribute("birthDate", birthDate);

        response.sendRedirect("ShowSession");
    }
}
