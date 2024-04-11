package pl.rlnkoo.blogappspringboot.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(antMatcher("/css/**")).permitAll();
                    auth.requestMatchers(antMatcher("/js/**")).permitAll();
                    auth.requestMatchers(antMatcher("/images/**")).permitAll();
                    auth.requestMatchers(antMatcher("/fonts/**")).permitAll();
                    auth.requestMatchers(antMatcher("/webjars/**")).permitAll();
                    auth.requestMatchers(antMatcher("/")).permitAll();
                    auth.requestMatchers(antMatcher("/rss/**")).permitAll();
                    auth.requestMatchers(antMatcher("/register/**")).permitAll();
                    auth.requestMatchers(antMatcher("/posts/**")).permitAll();
                    auth.requestMatchers(PathRequest.toH2Console()).permitAll();
                    auth.anyRequest().authenticated();

                })

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error")
                        .permitAll()
                );

        return http.build();

    }
}