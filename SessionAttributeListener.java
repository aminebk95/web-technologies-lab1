package servlets;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

// 1.4.2 Q4 : attributs de session
@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("[SessionAttributeListener] ajoute : " + event.getName() + " = " + event.getValue());
    }

    // getValue() donne l'ancienne valeur
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("[SessionAttributeListener] remplace : " + event.getName() + " = " + event.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("[SessionAttributeListener] supprime : " + event.getName() + " = " + event.getValue());
    }
}
