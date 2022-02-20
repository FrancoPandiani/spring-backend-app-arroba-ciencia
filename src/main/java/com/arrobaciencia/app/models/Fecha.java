package com.arrobaciencia.app.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.arrobaciencia.app.utils.ConstantesApp;

@Entity
@Table(name = "fechas")
public class Fecha implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(length = 7, nullable=false)
	@NotEmpty
	@Size(min=2, message="El dia debe tener almenos 2 caracteres.")
	private String dia;
	
	@Column(length = 10, nullable=false)
	@Size(min=2, message="El mes debe tener almenos 2 caracteres.")
	private String mes;
	
	@Column(length = 4, nullable=false)
	@Size(min=4, message="El año debe tener almenos 4 caracteres.")
	private String anio;
	
	@Column(length = 50, nullable=false)
	@Size(min=1, message="La cantidad de niños debe ser mayor a 0.")
	private int cantChicos;
	
	@Column(length = 10)
	private double valor;
	
	@Column(length = 5)
	private boolean estaReservada;
	
	@NotEmpty
	@Email
	@Column(length = 50, nullable=false)
	private String mailReserva;

	@PreUpdate
	@PrePersist
	public void preUpdate() {
		this.valor = cantChicos * ConstantesApp.PRECIO_NINIO;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public int getCantChicos() {
		return cantChicos;
	}

	public void setCantChicos(int cantChicos) {
		this.cantChicos = cantChicos;
	}

	public double getValor() {
		return valor;
	}


	public boolean isEstaReservada() {
		return estaReservada;
	}

	public void setEstaReservada(boolean estaReservada) {
		this.estaReservada = estaReservada;
	}

	public String getMailRerserva() {
		return mailReserva;
	}

	public void setMailRerserva(String mailRerserva) {
		this.mailReserva = mailRerserva;
	}

	

}
