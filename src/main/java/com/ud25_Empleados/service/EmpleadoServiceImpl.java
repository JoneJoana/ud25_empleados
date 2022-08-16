package com.ud25_Empleados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ud25_Empleados.dto.Departamentos;
import com.ud25_Empleados.dto.Empleados;
import com.ud25_Empleados.dao.IEmpleadoDAO;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	//Utilizamos los metodos de la interface IEmpleadoDAO, es como si instaciaramos.
	@Autowired
	IEmpleadoDAO iEmpleadoDao;
	
	@Override 
	public List<Empleados> listEmpleados() {		
		return iEmpleadoDao.findAll();
	}

	@Override 
	public Empleados saveEmpleado(Empleados empleado) {		
		return iEmpleadoDao.save(empleado);		
	}

	@Override 
	public Empleados findByDNI(String dni) {		
		return iEmpleadoDao.findByDNI(dni);
	}

	public List<Empleados> findByName(String name){
		return iEmpleadoDao.findByName(name);
	}
	
	@Override  
	public List<Empleados> findEmplByDepart(Departamentos departamento) {		
		return iEmpleadoDao.findByDepartamento(departamento);
	}

	@Override
	public void deleteEmpleado(String dni) {		
		iEmpleadoDao.deleteByDNI(dni);		
	}	

}
