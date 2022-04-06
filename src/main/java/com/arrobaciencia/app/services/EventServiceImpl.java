package com.arrobaciencia.app.services;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.arrobaciencia.app.models.Event;
import com.arrobaciencia.app.repositories.IEventRepo;

@Service
public class EventServiceImpl implements IEventService {

	@Autowired
	private IEventRepo fechaRepository;


	@Override
	public Optional<Event> findById(Long id) {

		return fechaRepository.findById(id);
	}

	@Override
	public Event save(Event fecha) {
		
		return fechaRepository.saveAndFlush(fecha);

	}

	@Override
	public void deleteById(Long id) {

		fechaRepository.deleteById(id);

	}

}
