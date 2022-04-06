package com.arrobaciencia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arrobaciencia.app.models.Role;


public interface IRoleRepo extends JpaRepository<Role,Long>{
	Role findByName (String name);
}
