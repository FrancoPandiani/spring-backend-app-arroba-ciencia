package com.arrobaciencia.app.services;


import java.util.Optional;
import com.arrobaciencia.app.models.Event;

public interface IEventService {

	public Optional<Event> findById(Long id);

	public Event save(Event fecha);

	public void deleteById(Long id);
}
