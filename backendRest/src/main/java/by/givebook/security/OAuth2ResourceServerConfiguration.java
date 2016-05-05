package by.givebook.security;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Default class description.
 *
 * @author P.Sinitsky
 * @version 1.0
 * @since 11.04.2016
 */
@SpringBootApplication
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/users/").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/offerTypes/").authenticated()
                .antMatchers(HttpMethod.PUT, "/myOffers/").authenticated()
                .antMatchers(HttpMethod.DELETE, "/myOffers/").authenticated()
                .antMatchers(HttpMethod.PUT, "/register").permitAll()
                .antMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN");
    }
}
