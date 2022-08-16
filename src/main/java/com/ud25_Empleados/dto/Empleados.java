package com.ud25_Empleados.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="empleados")//en caso que la tabla sea diferente
public class Empleados {

	//Atributos de entidad empleado
	@Id
	private String DNI;
	
	@Column(name = "nombre")//no hace falta si se llama igual
	private String nombre;	
	
	@Column(name = "apellidos")//no hace falta si se llama igual
	private String apellidos;	
	
	@OneToOne
    @JoinColumn(name="departamento")
    private Departamentos departamento;
	
	//Constructores
	public Empleados() {	}	
	
	
	public Empleados(String DNI, String nombre, String apellidos, Departamentos departamento) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.departamento = departamento;
	}


	@Override
	public String toString() {
		return "Empleados [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", Departamento="
				+ departamento + "]";
	}


	//Getters y Setters
	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public Departamentos getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento;
	}
		
}