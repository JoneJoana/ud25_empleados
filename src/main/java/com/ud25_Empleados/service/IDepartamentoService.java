package com.ud25_Empleados.service;

import java.util.List;

import com.ud25_Empleados.dto.Departamentos;

public interface IDepartamentoService {

	//Metodos del CRUD
	public List<Departamentos> listDepartamentos(); //ALL -  GET
	
	public Departamentos saveDepartamento(Departamentos departamento); //CREATE || UPDATE
	
	public Departamentos findByID(int id); //READ, SOLO 1 REGISTRO O NINGUNO
	
	public List<Departamentos> findByName(String name);  //GET BY NAME
		
	public void deleteDepartamento(int id);  //DELETE
	
}
