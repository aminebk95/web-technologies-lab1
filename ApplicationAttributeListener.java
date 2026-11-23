package servlets;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

// 1.4.2 Q5 : attributs d'application (ServletContext)
@WebListener
public class ApplicationAttributeListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("[ApplicationAttributeListener] ajoute : " + event.getName() + " = " + event.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("[ApplicationAttributeListener] remplace : " + event.getName() + " = " + event.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("[ApplicationAttributeListener] supprime : " + event.getName() + " = " + event.getValue());
    }
}
