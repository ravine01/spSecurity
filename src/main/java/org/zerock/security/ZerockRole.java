package org.zerock.security;

import org.springframework.security.core.GrantedAuthority;

public class ZerockRole implements GrantedAuthority {

	private String roleName;
	
	public ZerockRole(String role){
		this.roleName = role;
	}
	
	@Override
	public String getAuthority() {
		
		return roleName;
	}

}
