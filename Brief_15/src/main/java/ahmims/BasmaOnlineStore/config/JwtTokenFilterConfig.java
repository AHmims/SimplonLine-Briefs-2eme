package ahmims.BasmaOnlineStore.config;

import ahmims.BasmaOnlineStore.security.JwtManager;
import ahmims.BasmaOnlineStore.security.JwtTokenFilter;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtTokenFilterConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private JwtManager jwtManager;

    public JwtTokenFilterConfig(JwtManager jwtManager) {
        this.jwtManager = jwtManager;
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        JwtTokenFilter customFilter = new JwtTokenFilter(jwtManager);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
