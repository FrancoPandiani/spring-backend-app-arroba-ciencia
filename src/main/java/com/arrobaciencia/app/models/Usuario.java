package com.arrobaciencia.app.models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder


@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(length = 20)
	private String nombre;
	
	@NotEmpty
	@Column(length = 15)
	private String apellido;
	
	@NotEmpty
	@Email 
	@Column(name = "mail", nullable = false, length = 40, unique = true)
	private String email;
	
	@NotEmpty
	@Size(min=10)
	@Column(name = "consulta",length = 50)
	private String consulta;	
	
}
