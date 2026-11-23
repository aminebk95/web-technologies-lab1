package servlets;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.annotation.WebListener;

// 1.4.2 Q5 : attributs de requete
// on ignore les attributs internes de Tomcat (org.apache...) sinon il y en a a chaque requete
@WebListener
public class RequestAttributeListener implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent event) {
        if (event.getName().startsWith("org.apache")) return;
        System.out.println("[RequestAttributeListener] ajoute : " + event.getName() + " = " + event.getValue());
    }

    public void attributeReplaced(ServletRequestAttributeEvent event) {
        if (event.getName().startsWith("org.apache")) return;
        System.out.println("[RequestAttributeListener] remplace : " + event.getName() + " = " + event.getValue());
    }

    public void attributeRemoved(ServletRequestAttributeEvent event) {
        if (event.getName().startsWith("org.apache")) return;
        System.out.println("[RequestAttributeListener] supprime : " + event.getName() + " = " + event.getValue());
    }
}
