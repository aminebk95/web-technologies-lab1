package servlets;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

// 1.4.1 : affiche les requetes dans la console de Tomcat
// Q3 : declare dans web.xml (au lieu de @WebFilter("/*")) avec le parametre logPrefix
// Extra : temps d'execution de la requete
public class LoggingFilter implements Filter {

    private String prefix;

    public void init(FilterConfig config) throws ServletException {
        prefix = config.getInitParameter("logPrefix");
        System.out.println(prefix + " init : filtre initialise");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println(prefix + " avant chain.doFilter : " + req.getRequestURL());

        long start = System.nanoTime();
        chain.doFilter(request, response);
        long end = System.nanoTime();

        System.out.println(prefix + " apres chain.doFilter : " + req.getRequestURL());
        System.out.println(prefix + " temps d'execution : " + (end - start) / 1000000.0 + " ms");
    }

    public void destroy() {
        System.out.println(prefix + " destroy : filtre detruit");
    }
}
