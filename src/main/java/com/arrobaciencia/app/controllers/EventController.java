package com.arrobaciencia.app.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arrobaciencia.app.models.Event;
import com.arrobaciencia.app.services.IEventService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

@RestController
@RequestMapping("/eventos")

public class EventController {
	
	@Autowired
	private IEventService eventService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Event> findEventByid (@PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.OK).body(eventService.findById(id).get());
	}
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Event fecha) {
		return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(fecha));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Event fechaReservada, @PathVariable long id) {

		Optional<Event> fechaOp = eventService.findById(id);

		if (!fechaOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Event fecha = fechaOp.get();
		fecha.setKidsAmount(fechaReservada.getKidsAmount());
		fecha.setReserved(true);

		return ResponseEntity.status(HttpStatus.CREATED).body(eventService.save(fecha));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		if (!eventService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		eventService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
