package br.com.mongoblogs.config;

import br.com.mongoblogs.repository.MongoUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    MongoUserDetailsRepository mongoUserDetailsRepository;

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception
    {
        BCryptPasswordEncoder encoder = passwordEncoder();
        builder.userDetailsService(mongoUserDetailsRepository).passwordEncoder(encoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers(
                        "/",
                        "/login",
                        "/users/register",
                        "/users/save",
                        "/blogs/{id}/posts",
                        "/post/{id}"
                )
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/")
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web)
    {
        web
                .ignoring()
                .antMatchers("/css/**", "/js/**", "/image/**", "/webjars/**");
    }
}
