package com.arrobaciencia.app.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.arrobaciencia.app.models.AppUser;
import com.arrobaciencia.app.models.Role;
import com.arrobaciencia.app.repositories.IAppUserRepo;
import com.arrobaciencia.app.repositories.IRoleRepo;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class AppUserServiceImpl implements IAppUserService, UserDetailsService {
	@Autowired
	private IAppUserRepo userRepo;
	@Autowired
	private IRoleRepo roleRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AppUser user = userRepo.findByUsername(username);
		if (user == null) {
			log.error("User not found in database");
			throw new UsernameNotFoundException("User not found in database");
		}

		else {
			log.info("User found in database", username);
		}

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));

		});

		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
	}

	@Override
	public AppUser saveUser(AppUser user) {

		log.info("saving  new user {} to the data base", user.getName());
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {

		log.info("saving  new rol{} to the data base", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {

		log.info("adding rol{} to user {} ", roleName, userName);
		AppUser searchedUser = userRepo.findByUsername(userName);
		Role searchedRole = roleRepo.findByName(roleName);
		searchedUser.getRoles().add(searchedRole);

	}

	@Override
	public AppUser getUser(String userName) {

		log.info("fetching user {} ", userName);
		return userRepo.findByUsername(userName);
	}

	@Override
	public List<AppUser> getUsers() {
		log.info("fetching all user {} ");
		return userRepo.findAll();
	}

}
