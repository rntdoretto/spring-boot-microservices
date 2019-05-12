package com.renatodoretto.examples.microservices.auth.security.user;

import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.renatodoretto.examples.microservices.core.model.ApplicationUser;
import com.renatodoretto.examples.microservices.core.repository.ApplicationUserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
public class UserDetailsServiceImpl implements UserDetailsService {

	private final ApplicationUserRepository applicationUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		log.info("Searching in the DB the user by username '{}'", username);
		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
		log.info("ApplicationUser found '{}'", applicationUser);

		if (applicationUser == null)
			throw new UsernameNotFoundException(String.format("Application user '%s' not found", username));

		return new CustomUserDetails(applicationUser);
	}

	private static final class CustomUserDetails extends ApplicationUser implements UserDetails {

		private static final long serialVersionUID = 6537661370030932016L;

		public CustomUserDetails(@NotNull ApplicationUser applicationUser) {
			super(applicationUser);
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_" + this.getRole());
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

}
