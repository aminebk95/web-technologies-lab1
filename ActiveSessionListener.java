package servlets;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

// 1.4.2 Q2 : nombre de sessions actives, range dans l'attribut d'application "activeSessions"
// synchronized : deux sessions peuvent etre creees en meme temps
@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private int active = 0;

    public synchronized void sessionCreated(HttpSessionEvent se) {
        active++;
        se.getSession().getServletContext().setAttribute("activeSessions", active);
        System.out.println("[ActiveSessionListener] session creee, sessions actives : " + active);
    }

    public synchronized void sessionDestroyed(HttpSessionEvent se) {
        active--;
        se.getSession().getServletContext().setAttribute("activeSessions", active);
        System.out.println("[ActiveSessionListener] session detruite, sessions actives : " + active);
    }
}
