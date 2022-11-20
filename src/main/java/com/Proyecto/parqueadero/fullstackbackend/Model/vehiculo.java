package com.Proyecto.parqueadero.fullstackbackend.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.util.Date;

@Entity
@Table(name = "vehiculo")
public class vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehiculo_id;
	@NonNull
	@Column(name = "tipo_vehiculo")
	private String tipo_vehiculo;
	@NonNull
	@Column(name = "placa")
	private String placa;
	@NonNull
	@Column(name = "hora_llegada")
	private Date hora_llegada;
	@NonNull
	@Column(name = "hora_salida")
	private Date hora_salida;
	@NonNull
	@Column(name = "lugar_parqueadero")
	private String lugar_parqueadero;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private usuario usuarios;

	public vehiculo() {

	}

	public vehiculo(int vehiculo_id, String tipo_vehiculo, String placa, Date hora_llegada, Date hora_salida,
			String lugar_parqueadero, usuario usuarios) {
		super();
		this.vehiculo_id = vehiculo_id;
		this.tipo_vehiculo = tipo_vehiculo;
		this.placa = placa;
		this.hora_llegada = hora_llegada;
		this.hora_salida = hora_salida;
		this.lugar_parqueadero = lugar_parqueadero;
		this.usuarios = usuarios;
	}

	public int getVehiculo_id() {
		return vehiculo_id;
	}

	public void setVehiculo_id(int vehiculo_id) {
		this.vehiculo_id = vehiculo_id;
	}

	public String getTipo_vehiculo() {
		return tipo_vehiculo;
	}

	public void setTipo_vehiculo(String tipo_vehiculo) {
		this.tipo_vehiculo = tipo_vehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getHora_llegada() {
		return hora_llegada;
	}

	public void setHora_llegada(Date hora_llegada) {
		this.hora_llegada = hora_llegada;
	}

	public Date getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(Date hora_salida) {
		this.hora_salida = hora_salida;
	}

	public String getLugar_parqueadero() {
		return lugar_parqueadero;
	}

	public void setLugar_parqueadero(String lugar_parqueadero) {
		this.lugar_parqueadero = lugar_parqueadero;
	}

	public usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(usuario usuarios) {
		this.usuarios = usuarios;
	}
	
	

}