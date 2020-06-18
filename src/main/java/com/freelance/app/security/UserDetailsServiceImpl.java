package com.freelance.app.security;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.freelance.app.entities.User;
import com.freelance.app.exceptions.ResourceNotFoundException;
import com.freelance.app.repositories.UserRepository;



@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null)
			throw new ResourceNotFoundException("User  Not Found with -> email " + email);
	    return UserPrinciple.build(user);
	}
}