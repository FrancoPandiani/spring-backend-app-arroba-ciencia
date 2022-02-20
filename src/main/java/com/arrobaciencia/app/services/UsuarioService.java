package com.arrobaciencia.app.services;

import java.util.List;
import java.util.Optional;
import com.arrobaciencia.app.models.Usuario;

public interface UsuarioService {

	public List<Usuario> listar();

	public Usuario save(Usuario usuario);

	public void deleteById(Long id);

	public Optional<Usuario> findById(Long id);
	
}
