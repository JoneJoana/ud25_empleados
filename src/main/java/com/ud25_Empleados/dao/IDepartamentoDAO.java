package com.ud25_Empleados.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ud25_Empleados.dto.Departamentos;

public interface IDepartamentoDAO extends JpaRepository<Departamentos,Integer>{

	public List<Departamentos> findByNombre(String name);
	
}
