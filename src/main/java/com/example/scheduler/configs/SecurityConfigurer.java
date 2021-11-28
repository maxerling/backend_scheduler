package com.example.scheduler.configs;

import com.example.scheduler.filters.JwtRequestFilter;
import com.example.scheduler.services.UserDetailService;
import com.example.scheduler.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailService UserDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(UserDetailsService).passwordEncoder(passwordEncoder());
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors();
        http.csrf().disable().authorizeRequests()
                .antMatchers("/users").hasRole("USER")
                .antMatchers("/scheduler").hasRole("USER")
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/users/add").permitAll()
                .antMatchers("/auth").permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(new JwtRequestFilter(UserDetailsService,jwtUtil),UsernamePasswordAuthenticationFilter.class);

//        http.cors();
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .csrf().disable().authorizeRequests((request) ->
//                        request
//
//                                .antMatchers("/user").hasRole("USER")
//                        .antMatchers("/scheduler").hasRole("USER")
//                        .antMatchers("/admin").hasRole("ADMIN")
//                        .antMatchers("/").permitAll()
//                        .antMatchers("/login").permitAll()
//                        .antMatchers("/auth").permitAll()
//                        .antMatchers("/user/add").permitAll()
//                        .anyRequest()
//                )
//                .addFilterBefore(new JwtRequestFilter(UserDetailsService,jwtUtil),UsernamePasswordAuthenticationFilter.class);


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
