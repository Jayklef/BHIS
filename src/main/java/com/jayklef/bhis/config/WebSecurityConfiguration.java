package com.jayklef.bhis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider provider
                = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/users").permitAll()
                .antMatchers("/authors").permitAll()
                .antMatchers("/books/*").permitAll()
                .antMatchers("/users/create").permitAll()
                .antMatchers("books/save").hasAuthority("Admin")
                .antMatchers("authors/save").hasAuthority("Admin")
                .antMatchers("/authors/save/authors").hasAuthority("Admin")
                .antMatchers("booksbyauthor").hasAnyAuthority("Admin", "reader")
                .anyRequest().authenticated()
                .and()
                .logout()
                .permitAll();
    }
}
