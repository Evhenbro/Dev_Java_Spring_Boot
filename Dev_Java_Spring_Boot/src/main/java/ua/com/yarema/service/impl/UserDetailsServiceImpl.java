package ua.com.yarema.service.impl;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ua.com.yarema.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ua.com.yarema.entity.User entity = userRepository.findByLogin(username);
		if(entity == null) throw new UsernameNotFoundException("User with login " + username+ " not exist!");
		return new org.springframework.security.core.userdetails.User(username, entity.getPassword(), AuthorityUtils.createAuthorityList(entity.getRole().name()));
	}

}
