package servlets;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

// 1.4.2 Q3 : debut et fin de chaque requete
@WebListener
public class RequestListener implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        System.out.println("[RequestListener] requete initialisee : " + req.getRequestURI());
    }

    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        System.out.println("[RequestListener] requete terminee : " + req.getRequestURI());
    }
}
