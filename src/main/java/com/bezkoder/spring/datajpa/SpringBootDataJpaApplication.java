package com.bezkoder.spring.datajpa;

import com.bezkoder.spring.datajpa.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}


	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					//.antMatchers(HttpMethod.POST,"/client/connexion" ).permitAll()
					.antMatchers(HttpMethod.POST, "/client/inscription","/client/connexion","/api/test/martin").permitAll()
                    .antMatchers(HttpMethod.GET,"/api/test/martin","/client/liste","/client/{id}","/information/liste", "/information/{id}").permitAll()

                    .anyRequest().authenticated();
		}
	}

}
