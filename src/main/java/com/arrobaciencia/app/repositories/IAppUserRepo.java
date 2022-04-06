package com.arrobaciencia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.arrobaciencia.app.models.AppUser;

@Repository
public interface IAppUserRepo extends JpaRepository<AppUser, Long> {
	AppUser findByUsername (String name);
}
