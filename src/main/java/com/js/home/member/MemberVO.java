package com.js.home.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class MemberVO implements UserDetails{
	
	private String id;
	private String pw;
	private String pwCheck;
	private String name;
	private String email;
	
	private List<RoleVO> roleVOs;
	
	
	
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> autoAuthorities = new ArrayList<>();
		
		for(RoleVO roleVO : roleVOs) {
			autoAuthorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		
		return autoAuthorities;
	}
	@Override
	public String getPassword() {
		
		return this.getPw();
	}
	@Override
	public String getUsername() {
	
		return this.id;
	}
	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	
	

}
