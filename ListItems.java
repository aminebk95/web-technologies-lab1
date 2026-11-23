package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 1.3.2 : liste d'items (ArrayList<String>) stockee dans la session
// Extra : nombre de fois que chaque item a ete saisi
public class ListItems extends HttpServlet {

    // appele par le formulaire de items.html
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        if (items == null) {
            items = new ArrayList<String>();
            session.setAttribute("items", items);
        }

        String newItem = request.getParameter("newItem");
        if (newItem != null && !newItem.isEmpty()) {
            items.add(newItem);
        }

        doGet(request, response);
    }

    // affiche la liste
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        if (items == null) {
            items = new ArrayList<String>();
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Items</h2>");
        out.println("<ul>");
        for (String item : items) {
            out.println("<li>" + item + "</li>");
        }
        out.println("</ul>");

        // Extra
        out.println("<h3>Number of times each item was input</h3>");
        ArrayList<String> done = new ArrayList<String>();
        for (String item : items) {
            if (!done.contains(item)) {
                out.println("<p>" + item + " : " + Collections.frequency(items, item) + "</p>");
                done.add(item);
            }
        }

        out.println("<p><a href='items.html'>Add another item</a></p>");
        out.println("</body></html>");
    }
}
