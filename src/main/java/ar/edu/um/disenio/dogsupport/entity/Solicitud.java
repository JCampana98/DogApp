package ar.edu.um.disenio.dogsupport.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="solicitudes")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Solicitud implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7150177043568722491L;
	@Column(name="cliente_id")
	private Integer clienteId;
	@Column(name="perro_id")
	private Integer perroId;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="solicitud_id")
	private Integer solicitudId;
	private Boolean adopcion;
}
