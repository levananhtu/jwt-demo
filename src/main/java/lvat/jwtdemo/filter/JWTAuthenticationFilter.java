package lvat.jwtdemo.filter;

import lvat.jwtdemo.service.TokenAuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTAuthenticationFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) servletRequest); //lấy thông tin Authentication
        SecurityContextHolder.getContext().setAuthentication(authentication); //set vào security context
        filterChain.doFilter(servletRequest, servletResponse);
        /* vì có rất nhiều filter trong một chương trình,
         *nên lệnh này sẽ yêu cầu chương trình thực hiện các filter tiếp theo
         *
         * */
    }
}
