package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Propietario;

public interface IPropietarioRepository {

	public void insertar(Propietario propietario);
	public Propietario seleccionar(String cedula);
	public void eliminar(String cedula);
	public void actualizar(Propietario propietario);
	
}
