package by.givebook.controllers.security;

import by.givebook.dto.security.TokenDTO;
import by.givebook.dto.security.UserLoginDTO;
import by.givebook.services.security.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Default class description.
 *
 * @author P.Sinitsky.
 */

@RestController
@RequestMapping("/login")
public class LoginController implements Filter {

    @Autowired
    private LoginService service;

    @RequestMapping(method = RequestMethod.POST)
    private TokenDTO authenticate(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request) {
        return service.isAuthenticated (userLoginDTO)
                ? new TokenDTO (service.getKeyForToken (userLoginDTO, request.getRemoteAddr()) )
                : null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
