package com.Proyecto.parqueadero.fullstackbackend.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = { "Nombre" }) })
public class usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	@Column(name = "Nombre")
	private String nombre;
	@NonNull
	@Column(name = "Apellido")
	private String apellido;
	@NonNull
	@Column(name = "ciudad")
	private String ciudad;
	@NonNull
	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;

	@OneToMany(mappedBy = "vehiculo_id", cascade = CascadeType.ALL)
	private Set<vehiculo> vehiculos = new HashSet<>();

	public usuario() {

	}

	public usuario(int id, String nombre, String apellido, String ciudad, String email, Set<vehiculo> vehiculos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.email = email;
		this.vehiculos = vehiculos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}	
	
}





