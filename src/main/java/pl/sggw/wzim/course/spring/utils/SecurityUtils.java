package pl.sggw.wzim.course.spring.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {

    public String getLoggedUserLogin() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
