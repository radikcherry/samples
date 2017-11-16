package org.cherry.sample;

import org.cherry.sample.model.User;
import org.cherry.sample.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class UserCLR implements CommandLineRunner {

	private final UserRepository userRepository;

	@Autowired
	public UserCLR(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		userRepository.save(new User("admin", "pass", true, new String[]{"ROLE_USER", "ROLE_ADMIN"}));
		userRepository.save(new User("user", "pass", true, new String[]{"ROLE_USER"}));
	}
}
