package com.ud25_Empleados.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ud25_Empleados.dto.Departamentos;
import com.ud25_Empleados.dto.Empleados;
import com.ud25_Empleados.service.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
	
	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;
	
	@GetMapping("/empleados")
	public List<Empleados> listarEmpleados(){
		return empleadoServiceImpl.listEmpleados();
	}
	
	@GetMapping("/empleados/departamento/{departamento}")	
	public List<Empleados> listarEmpleadoXDepartamento(@PathVariable(name="departamento") Departamentos departamento){
		return empleadoServiceImpl.findEmplByDepart(departamento);
	}
	
	@GetMapping("/empleados/{dni}")
	public Empleados buscEmplXDNI(@PathVariable(name="dni") String dni) {		
		return empleadoServiceImpl.findByDNI(dni);
	}
	
	@GetMapping("/empleados/nombre/{nombre}")
	public List<Empleados> findByNombre(@PathVariable(name="nombre") String nombre) {
		return empleadoServiceImpl.findByName(nombre);
	}
	
	@PostMapping("/empleados")  //tambien actualiza si ya existe
	public String guardarEmpleado(@RequestBody Empleados empleado) {
		boolean exists = false;
		
		for (Empleados f : empleadoServiceImpl.listEmpleados()) {
			if(f.getDNI().equals(empleado.getDNI())) {
				exists = true;
			}
		}
		if(!exists) {
			empleadoServiceImpl.saveEmpleado(empleado);
			return "Empleado "+ empleado.getDNI()+" guardado!";
		}
		return "Empleado ya existe";		
		
		//validar datos que entran por body
		//Empleados empleadoInput = new Empleados(empleado.getDNI(),empleado.getNombre(),empleado.getApellidos(),empleado.getDepartamento());		
				
		//empleadoServiceImpl.saveEmpleado(empleadoInput);
		//return "Empleado "+ empleadoInput.getDNI()+" guardado.";
	}
	
	@DeleteMapping("/empleados/{dni}")
	@Transactional
	public void eliminarEmpleado(@PathVariable(name="dni") String dni) {
		empleadoServiceImpl.deleteEmpleado(dni);
	}
	
	@PutMapping("/empleados/{dni}")
	public Empleados guardarEmpleado(@PathVariable(name="dni") String dni, @RequestBody Empleados empleado) {
		Empleados empleado_selec = empleadoServiceImpl.findByDNI(dni);
		
		empleado_selec.setNombre(empleado.getNombre());
		empleado_selec.setApellidos(empleado.getApellidos());
		empleado_selec.setDepartamento(empleado.getDepartamento());		
		
		return empleadoServiceImpl.saveEmpleado(empleado_selec);
	}
	
}
