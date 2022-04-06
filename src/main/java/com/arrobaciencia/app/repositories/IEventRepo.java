package com.arrobaciencia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arrobaciencia.app.models.Event;

public interface IEventRepo extends JpaRepository<Event,Long> {
}
