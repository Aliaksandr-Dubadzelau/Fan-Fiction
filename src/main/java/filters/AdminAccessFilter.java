package filters;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/AdminPanel", "/pages/adminPanel/*"}, initParams = {
        @WebInitParam(name = "UnauthorizedAccess", value = "/pages/errors/unauthorizedAccess.jsp")
})
public class AdminAccessFilter implements Filter {

    private String unauthorizedAccess;

    public AdminAccessFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        unauthorizedAccess = fConfig.getInitParameter("UnauthorizedAccess");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest filterRequest = (HttpServletRequest) request;

        HttpSession session = filterRequest.getSession();

        User user = (User) session.getAttribute("user");

        if (user != null && user.getLogin().equals("DAdminV") && user.getPassword().equals("DAdminV")) {
            chain.doFilter(filterRequest, response);
        }
        else {

            HttpServletResponse filterResponse = (HttpServletResponse) response;
            filterResponse.sendRedirect(filterRequest.getContextPath() + this.unauthorizedAccess);

        }

    }

}
