package lvat.jwtdemo.filter;

import lvat.jwtdemo.service.TokenAuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    public JWTLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authManager) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException { //nhận data từ phía người dùng gửi lên
        return getAuthenticationManager().authenticate( // Trả về một object AuthenticationManager, object này sẽ được so sánh với obj ở WebSecurityConfig
                new UsernamePasswordAuthenticationToken(
                        httpServletRequest.getParameter("username"), //lấy username
                        httpServletRequest.getParameter("password"), //lấy password
                        Collections.emptyList())
        );
    }

    /*
     * nếu phương thức attemptAuthentication được thực hiện thành công (đúng username password, không có lỗi khác của server)
     * hàm successfulAuthentication sẽ được gọi, hoặc không, hàm
     * failureAuthentication sẽ được gọi. ở đây, ta sẽ sử dụng sẵn super.failureAuthentication,
     * ta chỉ override successfulAuthentication
     *
     */

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        TokenAuthenticationService.addAuthentication(response, authResult.getName());
    }
}
