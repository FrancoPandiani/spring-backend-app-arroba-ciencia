package com.arrobaciencia.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "Usuarios")
public class AppUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@Column(name = "nombre")
	private String name;
	
	@NotEmpty
	@Column(name = "cuenta")
	private String username;
	
	@NotEmpty
	@Column(name = "clave")
	private String password;
	
	@ManyToMany(fetch= FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<>();
	
}
