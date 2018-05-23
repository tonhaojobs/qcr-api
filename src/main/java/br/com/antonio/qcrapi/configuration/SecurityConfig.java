package br.com.antonio.qcrapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	public static final String AUTHENTICATION_HEADER_NAME = "Authorization";
	public static final String AUTHENTICATION_URL = "/api/login";
	public static final String API_ROOT_URL = "/api/**";
	/*
	
	@Autowired
	private AuthenticationSuccessHandler authSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler authFailureHandler;
	
	@Autowired 
	private AuthenticationManager authenticationManager;*/

	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        // Filters will not get executed for the resources
        web.ignoring().antMatchers("/", "/resources/**", "/static/**", "/public/**", "/webui/**", "/h2-console/**"
            , "/configuration/**", "/swagger-ui/**", "/swagger-resources/**", "/api-docs", "/api-docs/**", "/v2/api-docs/**"
            , "/*.html", "/**/*.html" ,"/**/*.css","/**/*.js","/**/*.png","/**/*.jpg", "/**/*.gif", "/**/*.svg", "/**/*.ico", "/**/*.ttf","/**/*.woff","/**/*.otf");
    }
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	/*
		httpSecurity
				.csrf()
				.disable()
				.exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				
				.and()
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, AUTHENTICATION_URL)
					.permitAll()

				.and()
					.authorizeRequests()
					.antMatchers(API_ROOT_URL)
					.authenticated()
				.and()
				
				.addFilterBefore(new CustomCorsConfig(), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(buildLoginFilter(AUTHENTICATION_URL), UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(buildAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);*/
	}
	
	
	@Bean
    protected BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
	}
	
}
