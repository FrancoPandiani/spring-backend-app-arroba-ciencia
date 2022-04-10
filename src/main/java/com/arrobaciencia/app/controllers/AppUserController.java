package com.arrobaciencia.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arrobaciencia.app.models.AppUser;
import com.arrobaciencia.app.models.Role;
import com.arrobaciencia.app.services.IAppUserService;
import lombok.Data;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/usuarios")

public class AppUserController {

	@Autowired
	private  IAppUserService userService;
	
	@GetMapping ("/users")
	public ResponseEntity <List<AppUser>>getUsers(){
		return ResponseEntity.ok().body(userService.getUsers());
	}
	@PostMapping("/user/save")
	public ResponseEntity<AppUser>saveUser(@RequestBody AppUser user){
		return ResponseEntity.ok().body(userService.saveUser(user));
	}
	@PostMapping("/role/save")
	public ResponseEntity<Role>saveRole(@RequestBody Role role){
		return ResponseEntity.ok().body(userService.saveRole(role));
	}
	@PostMapping("/role/addtouser")
	public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUser rtu){
		userService.addRoleToUser(rtu.getUserName(),rtu.getRoleName());
		return ResponseEntity.ok().build();
	}
	
}

@Data
class RoleToUser{
	private String userName;
	private String roleName;
}