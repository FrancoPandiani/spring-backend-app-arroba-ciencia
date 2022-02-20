package com.arrobaciencia.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arrobaciencia.app.models.Usuario;
import com.arrobaciencia.app.services.UsuarioService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> listar() {
		return usuarioService.listar();
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {

		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		if (!usuarioService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}

		usuarioService.deleteById(id);
		return ResponseEntity.ok().build();

	}

}
