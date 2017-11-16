package org.cherry.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.cherry.sample.model.UserRepository;

@Service
class SimpleUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public SimpleUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username).orElseThrow(
			() -> new UsernameNotFoundException("Could not find the username "+ username +" ."));
	}
}
