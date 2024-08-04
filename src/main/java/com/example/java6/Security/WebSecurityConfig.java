package com.example.java6.Security;

import com.example.java6.Security.service.UserPrincipalService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,proxyTargetClass = true)
public class WebSecurityConfig {

    @Autowired
    private UserPrincipalService userPrincipalService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers("/assets/**", "/lab3/home").permitAll()
//                        .requestMatchers("/firbase-sinh-vien", "/student").hasAnyRole("USER")
//                        .requestMatchers("/manager-authorities", "/account", "/students").hasRole("ADMIN")
//                        .requestMatchers("/lab3/student/form").hasAuthority("ROLE_GUEST")
//                        .anyRequest().authenticated()
                                .anyRequest().permitAll()
                )
//                .exceptionHandling(ex->ex.accessDeniedHandler(new AccessDeniedHandler() {
//                    @Override
//                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//                            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
////                        response.sendRedirect(request.getContextPath()+"/error");
//                    }
//                }))
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/lab3/home")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/lab3/home")
                        .permitAll()
                );

//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/oauth2/login/success", true)
//                        .failureUrl("/error")
//                        .authorizationEndpoint(authorization -> authorization
//                                .baseUri("/oauth2/authorization")
//                        )
//                )

        return http.build();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userPrincipalService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }


}
