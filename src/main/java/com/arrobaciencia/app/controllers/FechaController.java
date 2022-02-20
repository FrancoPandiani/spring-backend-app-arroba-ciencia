package com.arrobaciencia.app.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arrobaciencia.app.models.Fecha;
import com.arrobaciencia.app.services.FechaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/fechas")

public class FechaController {

	@Autowired
	private FechaService fechaService;

	@GetMapping
	public List<Fecha> listAll() {

		return fechaService.findAll();
	}

	@PostMapping
	public ResponseEntity<?> create (@RequestBody Fecha fecha) {

		return ResponseEntity.status(HttpStatus.CREATED).body(fechaService.save(fecha));

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Fecha fechaReservada, @PathVariable(value = "id") long fechaid) {

		Optional<Fecha> fechaOp = fechaService.findById(fechaid);

		if (!fechaOp.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		Fecha fecha = fechaOp.get();
		fecha.setCantChicos(fechaReservada.getCantChicos());
		fecha.setEstaReservada(true);
		fecha.setMailRerserva(fechaReservada.getMailRerserva());

		return ResponseEntity.status(HttpStatus.CREATED).body(fechaService.save(fecha));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		if (!fechaService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		fechaService.deleteById(id);
		return ResponseEntity.ok().build();

	}

}
