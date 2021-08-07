package ahmims.scuffed_BAKURA.config;

import ahmims.scuffed_BAKURA.security.JwtManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtManager jwtManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/api/auth/login").permitAll()
                .antMatchers("/api/auth/signup").permitAll()
                .antMatchers("/api/test").permitAll()
                .antMatchers("/api/seed/*").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/valider/*").permitAll()
                .antMatchers("/serve/images/*").permitAll()
                // Disallow everything else
                .anyRequest().authenticated();

        // redirect on non allowed access
        http.exceptionHandling().accessDeniedPage("/auth/signin");

        //disable csrf Protection
        http.cors().and().csrf().disable();

        //append jwt config
        http.apply(new JwtTokenFilterConfig(jwtManager));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(EnvVariables.encryptionLength);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
