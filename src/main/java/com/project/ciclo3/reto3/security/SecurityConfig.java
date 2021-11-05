package com.project.ciclo3.reto3.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /* Este metodo permitira realizar un inicio de sesion en github, y posteriormente permitira
    * tener acceso a todos los servicios rest desde la url a la que se direccionara en UserController*/
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.antMatcher("/**").authorizeRequests()
                .antMatchers(new String[]{"/api/**","/api/Reservation/report-dates/{dateOne}/{dateTwo}"}).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();

        httpSecurity.cors().and().csrf().disable();


    }
}
