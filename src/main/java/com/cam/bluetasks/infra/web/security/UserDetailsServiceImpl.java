package com.cam.bluetasks.infra.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cam.bluetasks.domain.user.AppUser;
import com.cam.bluetasks.domain.user.AppUserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	private AppUserRepository appUserRepository;

	@Autowired
	public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
		this.appUserRepository = appUserRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        AppUser appUser = appUserRepository.findByUserName(username);
		
		if (appUser == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return new UserDetailsImpl(appUser);
	}


}