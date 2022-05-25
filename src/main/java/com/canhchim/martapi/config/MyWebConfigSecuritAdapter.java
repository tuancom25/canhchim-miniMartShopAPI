package com.canhchim.martapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@Configuration
public class MyWebConfigSecuritAdapter extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {

        super.configure(web);
    }

    @Override
    public void configure(HttpSecurity web) throws Exception {
       web.csrf().disable();
       web.cors().disable();
       web.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      // web.authorizeRequests().antMatchers("/TestAPI/*").permitAll();
        // super.configure(web);
    }

}
