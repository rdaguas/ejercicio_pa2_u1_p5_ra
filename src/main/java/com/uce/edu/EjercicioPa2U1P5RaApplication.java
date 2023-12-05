package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.IPropietarioService;
import com.uce.edu.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPa2U1P5RaApplication implements CommandLineRunner {

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IPropietarioService iPropietarioService;

	@Autowired
	private IMatriculaService iMatriculaService;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5RaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//1. Crear un Vehiculo
		Vehiculo vehi = new Vehiculo();
		vehi.setMarca("Nissan");
		vehi.setPlaca("PQJ");
		vehi.setTipo("pesado");
		vehi.setPrecio(new BigDecimal(23000));
		System.out.println("-------------------------- CREAR UN VEHICULO -----------------------------");
		this.iVehiculoService.guardar(vehi);
		
		//2. Crear un Propietario
		Propietario prop = new Propietario();
		prop.setNombre("Roberto");
		prop.setApellido("Aguas");
		prop.setCedula("1710");
		prop.setGenero("Masculino");
		System.out.println("-------------------------- CREAR UN PROPIETARIO -----------------------------");
		this.iPropietarioService.guardar(prop);
		
		//3. Actualizar 2 atributos del propietario creado en punto2.
		
		prop.setNombre("Daniela");
		prop.setGenero("Femenino");
		System.out.println("-------------------------- Actualizar 2 Atributos -----------------------------");
		this.iPropietarioService.actualizar(prop);
		
		//4. Realizar Matricula
		System.out.println("-------------------------- REALIZAR MATRICULA -----------------------------");
		this.iMatriculaService.matricular("1710", "PQJ");

	}

}
