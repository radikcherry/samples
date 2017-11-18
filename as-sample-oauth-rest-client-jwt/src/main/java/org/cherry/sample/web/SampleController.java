package org.cherry.sample.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@RequestMapping("/auth/name")
	public String getAuthName() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

}
