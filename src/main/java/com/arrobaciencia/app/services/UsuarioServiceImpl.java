package com.arrobaciencia.app.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.arrobaciencia.app.models.Usuario;
import com.arrobaciencia.app.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listar() {

		return usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)

	public Optional<Usuario> findById(Long id) {

		return usuarioRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {

		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {

		usuarioRepository.deleteById(id);

	}

}
