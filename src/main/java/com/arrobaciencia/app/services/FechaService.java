package com.arrobaciencia.app.services;

import java.util.List;
import java.util.Optional;

import com.arrobaciencia.app.models.Fecha;

public interface FechaService {

	public List<Fecha> findAll();

	public Optional<Fecha> findById(Long id);

	public Fecha save(Fecha fecha);

	public void deleteById(Long id);
}
