package by.iba.mikhailovich.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/GroupServlet")
public class LoginRequiredFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain
            chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        if (request.getSession().getAttribute("username") != null) {
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher("LoginServlet").forward(req, resp);
        }
    }
}