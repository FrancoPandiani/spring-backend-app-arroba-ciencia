package com.arrobaciencia.app.services;

import java.util.List;
import com.arrobaciencia.app.models.AppUser;
import com.arrobaciencia.app.models.Role;

public interface IAppUserService {

	AppUser saveUser (AppUser user);
	Role saveRole(Role role);
	void addRoleToUser (String username,String roleName);
	AppUser getUser (String username);
	List<AppUser>getUsers();
}
