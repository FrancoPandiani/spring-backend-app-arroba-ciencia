package com.arrobaciencia.app.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.arrobaciencia.app.models.Fecha;
import com.arrobaciencia.app.repositories.FechaRepository;

@Service
public class FechaServiceImpl implements FechaService {

	@Autowired
	private FechaRepository fechaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Fecha> findAll() {

		return fechaRepository.findAll();
	}

	@Override
	public Optional<Fecha> findById(Long id) {

		return fechaRepository.findById(id);
	}

	@Override
	public Fecha save(Fecha fecha) {
		
		return fechaRepository.saveAndFlush(fecha);

	}

	@Override
	public void deleteById(Long id) {

		fechaRepository.deleteById(id);

	}

}
