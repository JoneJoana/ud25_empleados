package com.ud25_Empleados.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="departamentos")
public class Departamentos {

	@Id
	//busca ultimo valor e incrementa desde id final de db
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "presupuesto")
	private int presupuesto;
	
	@OneToMany
    @JoinColumn(name="DNI_empl")
    private List<Empleados> empleados;
	
	public Departamentos() {}

	public Departamentos(String nombre, int presupuesto) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	/**
	 * @return los empleados
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empleados")
	public List<Empleados> getEmpleados() {
		return empleados;
	}

	/**
	 * @param empleados 
	 * the articulos to set
	 */
	public void setArticulo(List<Empleados> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Departamentos [id=" + id + ", nombre=" + nombre + ", presupuesto=" + presupuesto + "]";
	}
	
	
}