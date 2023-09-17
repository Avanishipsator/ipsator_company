package com.ipsator.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ipsator.Entity.LoginUser;
import com.ipsator.Repository.LoginUserRepo;



@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private LoginUserRepo loginuserRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUser user = loginuserRepository.findByEmail(username).orElseThrow(() -> new RuntimeException("User not found!!"));
		
		return user;
	}

}
