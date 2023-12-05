package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;

@Repository
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Autowired
	private IPropietarioRepository iPropietarioRepository;

	@Override
	public void matricular(String cedula, String placa) {
		// TODO Auto-generated method stub

		Propietario propietario = this.iPropietarioRepository.seleccionar(cedula);
		Vehiculo vehiculo = this.iVehiculoRepository.seleccionar(placa);

		Matricula matri = new Matricula();

		matri.setFechaDeMatricula(LocalDateTime.now());
		matri.setPropietario(propietario);
		matri.setVehiculo(vehiculo);

		BigDecimal valorDeMatricula = null;

		if (vehiculo.getTipo().equals("pesado")) {
			valorDeMatricula = vehiculo.getPrecio().multiply(new BigDecimal(0.25));
		} else if (vehiculo.getTipo().equals("liviano")) {
			valorDeMatricula = vehiculo.getPrecio().multiply(new BigDecimal(0.20));
		}
		if (valorDeMatricula.compareTo(new BigDecimal(2200)) > 0) {
			valorDeMatricula = valorDeMatricula.subtract(valorDeMatricula.multiply(new BigDecimal(0.05)));
		}

		matri.setValorDeMatricula(valorDeMatricula);
		this.iMatriculaRepository.insertar(matri);
		System.out.println(matri);

	}

}
