package org.cherry.sample.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserinfoController {
	
	@RequestMapping("/oauth/userinfo")
	public Principal user(Principal principal) {
		return principal;
	}

}
