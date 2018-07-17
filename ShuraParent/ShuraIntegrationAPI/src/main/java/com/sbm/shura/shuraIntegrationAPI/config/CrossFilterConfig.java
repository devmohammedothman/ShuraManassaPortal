package com.sbm.shura.shuraIntegrationAPI.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order (Ordered.HIGHEST_PRECEDENCE)
public class CrossFilterConfig implements Filter  {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	       final HttpServletResponse response = (HttpServletResponse) res;
	       response.setHeader("Access-Control-Allow-Origin", "*");
	       response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	       response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, access-control, Authorization");
//	       response.setHeader("Access-Control-Allow-Headers", "*");
	       response.setHeader("Access-Control-Max-Age", "3600");
	       if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
	           response.setStatus(HttpServletResponse.SC_OK);
	       } else {
	           chain.doFilter(req, res);
	       }
	   }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
	
//	@Bean
//	   public CorsFilter corsConfigFilter() {
//	       UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	       CorsConfiguration config = new CorsConfiguration();
//	       config.setAllowCredentials(true);
//	       config.addAllowedOrigin("*");
//	       config.addAllowedHeader("*");
//	       config.addAllowedMethod("OPTIONS");
//	       config.addAllowedMethod("GET");
//	       config.addAllowedMethod("POST");
//	       config.addAllowedMethod("PUT");
//	       config.addAllowedMethod("DELETE");
//	       source.registerCorsConfiguration("/**", config);
//	       return new CorsFilter(source);
//	   }

}
