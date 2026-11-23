package servlets;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 1.4.1 Q5 : protege /ListItems (mapping dans web.xml)
public class SecurityFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // false : ne cree pas de nouvelle session
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            System.out.println("[SecurityFilter] avant chain.doFilter : acces autorise");
            chain.doFilter(request, response);
            System.out.println("[SecurityFilter] apres chain.doFilter");
        } else {
            System.out.println("[SecurityFilter] acces refuse, redirection vers login.html");
            res.sendRedirect("login.html");
        }
    }
}
