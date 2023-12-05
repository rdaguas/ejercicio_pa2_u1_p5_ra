package com.uce.edu.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
@Component
public class Matricula {

	private LocalDateTime fechaDeMatricula;
	private BigDecimal valorDeMatricula;
	private Propietario propietario;
	private Vehiculo vehiculo;

	//set y get
	public LocalDateTime getFechaDeMatricula() {
		return fechaDeMatricula;
	}

	public void setFechaDeMatricula(LocalDateTime fechaDeMatricula) {
		this.fechaDeMatricula = fechaDeMatricula;
	}

	public BigDecimal getValorDeMatricula() {
		return valorDeMatricula;
	}

	public void setValorDeMatricula(BigDecimal valorDeMatricula) {
		this.valorDeMatricula = valorDeMatricula;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	@Override
	public String toString() {
		return "Matricula [fechaDeMatricula=" + fechaDeMatricula + ", valorDeMatricula=" + valorDeMatricula
				+ ", propietario=" + propietario + ", vehiculo=" + vehiculo + "]";
	}

}
