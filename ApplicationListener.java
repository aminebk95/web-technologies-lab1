package servlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

// 1.4.2 Q1 : demarrage et arret de l'application
// Q6 : ce listener est declare dans web.xml (<listener>) au lieu de @WebListener
public class ApplicationListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[ApplicationListener] application demarree");
        sce.getServletContext().setAttribute("appName", "ING1 Web Application");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[ApplicationListener] application arretee");
    }
}
