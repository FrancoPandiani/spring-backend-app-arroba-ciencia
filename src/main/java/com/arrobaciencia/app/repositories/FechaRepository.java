package com.arrobaciencia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arrobaciencia.app.models.Fecha;

public interface FechaRepository extends JpaRepository<Fecha,Long> {

}
