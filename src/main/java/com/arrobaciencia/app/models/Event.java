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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.arrobaciencia.app.utils.ConstApp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "eventos")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(length = 7, nullable=false)
	@NotEmpty
	@Size(min=2, message="El dia debe tener almenos 2 caracteres.")
	private String day;
	
	@Column(length = 10, nullable=false)
	@Size(min=2, message="El mes debe tener almenos 2 caracteres.")
	private String month;
	
	@Column(length = 4, nullable=false)
	@Size(min=4, message="El año debe tener almenos 4 caracteres.")
	private String year;
	
	@Column(length = 50, nullable=false)
	@Size(min=1, message="La cantidad de niños debe ser mayor a 0.")
	private int kidsAmount;
	
	@Column(length = 10)
	private double price;
	
	@Column(length = 5)
	private boolean isReserved;
	
	@PreUpdate
	@PrePersist
	public void preUpdate() {
		this.price = kidsAmount * ConstApp.KID_PRICE;
	}

}
