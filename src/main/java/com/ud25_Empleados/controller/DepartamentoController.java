package com.ud25_Empleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ud25_Empleados.service.DepartamentoServiceImpl;
import com.ud25_Empleados.dto.Departamentos;


@RestController
@RequestMapping("/api")
public class DepartamentoController {
	
	@Autowired
	DepartamentoServiceImpl departServImpl;
	
	@GetMapping("/departamentos")
	public List<Departamentos> listDepartamentos(){
		return departServImpl.listDepartamentos();
	}

	@GetMapping("/departamentos/{id}")
	public Departamentos findByID(@PathVariable(name="id") int id) {
		return departServImpl.findByID(id);
	}
	
	@GetMapping("/departamentos/nombre/{nombre}")
	public List<Departamentos> findByNombre(@PathVariable(name="nombre") String nombre) {
		return departServImpl.findByName(nombre);
	}	
	
	@PostMapping("/departamentos") //crear
	public String guardarDepartamento(@RequestBody Departamentos departamento) {				
		//validar datos que entran por body , que no se repita el nombre
		boolean exists = false;
		
		for (Departamentos f : departServImpl.listDepartamentos()) {
			if(f.getNombre().equals(departamento.getNombre())) {
				exists = true;
			}
		}
		if(!exists) {
			departServImpl.saveDepartamento(departamento);
			return "Departamento guardado!";
		}
		return "El departamento ya existe!";			
	}
	
	@DeleteMapping("/departamentos/{id}")
	public void deleteDepartamento(@PathVariable(name="id") int id) {
		departServImpl.deleteDepartamento(id);
	}
	
	@PutMapping("/departamentos/{id}") //actualizar
	public Departamentos actualizarDepartamento(@PathVariable(name="id") int id, @RequestBody Departamentos departamento) {
		Departamentos dpt_selec = new Departamentos();
		Departamentos dpt_actualizado = new Departamentos();
		
		dpt_selec = departServImpl.findByID(id);
		
		dpt_selec.setNombre(departamento.getNombre());
		dpt_selec.setPresupuesto(departamento.getPresupuesto());
		
		dpt_actualizado = departServImpl.saveDepartamento(dpt_selec);
		
		return dpt_actualizado;
	}

}
