package security;

import model.Apprenant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApprenantInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("__user_data");
        if (user != null) {
            if (user.getClass().getSimpleName().equals(Apprenant.class.getSimpleName())) {
                return true;
            } else response.sendRedirect(request.getContextPath() + "/");
        } else response.sendRedirect(request.getContextPath() + "/auth/login");

        return false;
    }
}
