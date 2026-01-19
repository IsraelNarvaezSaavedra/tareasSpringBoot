package com.prueba.tareaProyecto.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="curriculums")
public class Curriculum {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String url;
	
	@Column(name="fechas_creacion")
	private Date fechaCreacion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="nombre")
	private Usuario usuario;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
    public Usuario getUsuario() {
        return usuario;
    }
	
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
	
}
