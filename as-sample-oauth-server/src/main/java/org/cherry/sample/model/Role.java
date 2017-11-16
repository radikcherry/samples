package org.cherry.sample.model;

import javax.persistence.Embeddable;

import org.springframework.security.core.GrantedAuthority;

@Embeddable
public class Role implements GrantedAuthority {
	private static final long serialVersionUID = 5707793894252976259L;

	private String authority;

	public Role() {
	}

	public Role(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
