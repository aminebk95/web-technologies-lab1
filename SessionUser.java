package servlets;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

// 1.4.3 Extra : l'objet est prevenu quand il est ajoute ou retire d'une session
// (pas besoin de @WebListener ni de web.xml)
public class SessionUser implements HttpSessionBindingListener {

    private String name;

    public SessionUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("[SessionUser] valueBound : " + name + " ajoute a la session");
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("[SessionUser] valueUnbound : " + name + " retire de la session");
    }
}
