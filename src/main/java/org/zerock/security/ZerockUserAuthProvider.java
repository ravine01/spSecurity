package org.zerock.security;

import java.util.Collection;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.stereotype.Component;

@Component
public class ZerockUserAuthProvider implements AuthenticationProvider {
	
	

	private static final Logger logger = LoggerFactory.getLogger(ZerockUserAuthProvider.class);

	@Inject
	private UserService userService;
	

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
		
		logger.info("isAuthenticated: "+auth.isAuthenticated());
	
		String userid = auth.getName();
		String userpw = (String) auth.getCredentials();
		
		logger.info("USERID:" + userid);
		logger.info("USERPW:" + userpw);

		UserDetails securityUser  = userService.loadUserByUsername(userid);

		logger.info("securityUser: " + securityUser);

		if (securityUser == null || !securityUser.getUsername().equalsIgnoreCase(userid)) {
			throw new BadCredentialsException("Username not found.");
		}

		logger.info("securityUser getPassword: " + securityUser.getPassword());
		logger.info("Authentication password: " + userpw);

		
		if (auth.isAuthenticated() == false && !userpw.equals(securityUser.getPassword())) {
			logger.error("---------------------------------");
			logger.error("userpw ERROR");
			logger.error("---------------------------------");
			
			throw new BadCredentialsException("Wrong password.");
		}
		

		Collection<? extends GrantedAuthority> authorities = securityUser.getAuthorities();
				
		logger.info("Authorities: " + authorities);	

		return new UsernamePasswordAuthenticationToken(securityUser, userpw, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
