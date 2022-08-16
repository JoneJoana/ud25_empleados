package com.ud25_Empleados.service;

import com.ud25_Empleados.dto.Departamentos;
import com.ud25_Empleados.dto.Empleados;

import java.util.List;

public interface IEmpleadoService {
	
	//Metodos del CRUD
	public List<Empleados> listEmpleados(); //ALL -  GET
	
	public Empleados saveEmpleado(Empleados empleado); //CREATE || UPDATE
	
	public Empleados findByDNI(String dni); //READ, SOLO 1 REGISTRO O NINGUNO
	
	public List<Empleados> findByName(String name); // GET BY NAME
	
	public List<Empleados> findEmplByDepart(Departamentos departamento); // GET
		
	public void deleteEmpleado(String dni);  //DELETE
	
}
