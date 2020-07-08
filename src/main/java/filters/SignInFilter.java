package filters;

import entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/MessengerMainWindow", "/pages/mainMessengerWindow/*"}, initParams = {
        @WebInitParam(name = "SignIn", value = "/SignIn")
})
public class SignInFilter implements Filter {

    private String signIn;

    public SignInFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        signIn = fConfig.getInitParameter("SignIn");
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

        if(user == null){
            HttpServletResponse filterResponse = (HttpServletResponse) response;
            filterResponse.sendRedirect(filterRequest.getContextPath() + this.signIn);
        }
        else {
            chain.doFilter(filterRequest, response);
        }

    }

}