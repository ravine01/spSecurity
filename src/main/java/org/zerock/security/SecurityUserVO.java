package org.zerock.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.zerock.domain.UserVO;

public class SecurityUserVO implements UserDetails{

	private UserVO vo;
	private ZerockRole role;
	
	public SecurityUserVO(UserVO vo) {
		
		this.vo = vo;
		
		this.role = new ZerockRole("ROLE_"+vo.getRole());
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(this.role);
				
		return authorities;
	}

	@Override
	public String getPassword() {

		return vo.getUserpw();
	}

	@Override
	public String getUsername() {

		return vo.getUserid();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return false;
	}

	@Override
	public boolean isEnabled() {

		return false;
	}

}
