package api.allegro.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by tjago on 2016-01-05.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Value("${app.rest.user}")
    private String restUser;

    @Value("${app.rest.password}")
    private String restPass;


    /**
     Adding simple role for trivial authentication,
     should be sufficient before 1.0 release
     */
    @Bean
    @Profile("production")
    WebSecurityConfigurerAdapter basic() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                if (!restUser.isEmpty() && !restPass.isEmpty()) {
                    auth.inMemoryAuthentication().withUser(restUser).password(restPass).authorities("ROLE_USER");
                }
            }
        };
    }

    @Bean
    @Profile("default")
    WebSecurityConfigurerAdapter noAuth() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests().anyRequest().permitAll();
            }
        };
    }
}
