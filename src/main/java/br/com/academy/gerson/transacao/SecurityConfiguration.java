package br.com.academy.gerson.transacao;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests(authorizeRequests ->
			authorizeRequests
				.antMatchers(HttpMethod.GET, "api/consultacartao/**").hasAnyAuthority("SCOPE_server:transacao")
				.anyRequest().authenticated()
		
				)
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}
	

}
