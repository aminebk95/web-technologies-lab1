package lab.mvc.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lab.mvc.model.Person;

// 3.3 : le Controller
public class Controller extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 1. lire les informations du formulaire
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        // 2. creer le bean
        Person person = new Person(firstName, lastName, birthDay, sex);

        // 3. ajouter le bean a la requete
        request.setAttribute("person", person);

        // 4. choisir la page : la date est au format mm/dd/yyyy, l'annee commence a l'indice 6
        int year = Integer.parseInt(birthDay.substring(6));
        String page;
        if (year < 1990) {
            page = "/mvc/old.jsp";
        } else {
            page = "/mvc/young.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.include(request, response);
    }
}
