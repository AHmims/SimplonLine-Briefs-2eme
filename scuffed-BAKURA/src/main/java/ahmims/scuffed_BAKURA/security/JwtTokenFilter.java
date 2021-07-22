package ahmims.scuffed_BAKURA.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ahmims.scuffed_BAKURA.exception.RequestException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.filter.OncePerRequestFilter;

public class JwtTokenFilter extends OncePerRequestFilter {

    private JwtManager jwtManager;

    public JwtTokenFilter(JwtManager jwtManager) {
        this.jwtManager = jwtManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException {
        final String token = jwtManager.resolveToken(httpServletRequest);
        try {
            if (token != null && jwtManager.validateToken(token)) {
                Authentication auth = jwtManager.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch (RequestException e) {
            SecurityContextHolder.clearContext();
            httpServletResponse.sendError(e.getHttpStatus().value(), e.getMessage());
        }
        //
        try {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (ServletException ignored) {
        }
    }
}
