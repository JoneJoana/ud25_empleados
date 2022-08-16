package com.ud25_Empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ud25_Empleados.dao.IDepartamentoDAO;
import com.ud25_Empleados.dto.Departamentos;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{

	@Autowired
	IDepartamentoDAO iDepartDao;
	
	
	@Override
	public List<Departamentos> listDepartamentos() {
		return iDepartDao.findAll();
	}

	@Override
	public Departamentos saveDepartamento(Departamentos departamento) {
		return iDepartDao.save(departamento);
	}

	@Override
	public Departamentos findByID(int id) {
		return iDepartDao.findById(id).get();
	}

	@Override
	public List<Departamentos> findByName(String name) {
		return iDepartDao.findByNombre(name);
	}

	@Override
	public void deleteDepartamento(int id) {
		iDepartDao.deleteById(id);	
	}

}
