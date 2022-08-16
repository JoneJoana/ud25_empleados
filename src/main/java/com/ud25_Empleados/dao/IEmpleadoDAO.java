package com.ud25_Empleados.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ud25_Empleados.dto.Departamentos;
import com.ud25_Empleados.dto.Empleados;

//interface que hereta de JPA repo dnde estan todas las funciones para 
//trabajar  con la bbdd. Empleado es de donde va a mapear, Integer el tipo de la PK
public interface IEmpleadoDAO extends JpaRepository<Empleados,String>{

	//listar clientes por campo nombre
	public List<Empleados> findByDepartamento(Departamentos departamento);
	
	public Empleados findByDNI(String DNI);

	public void deleteByDNI(String dni);
	
	public List<Empleados> findByName(String name);
	
}