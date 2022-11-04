package com.my.config;

import com.my.service.security.AdministratorDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
    private UserDetailsService detailsService;

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                .authorizeRequests((requests) -> requests
                        .antMatchers("/api/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll)
                .csrf().disable();

        return http.build();
    }
}
