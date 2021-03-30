package ar.edu.um.disenio.dogsupport.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="imagenes")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Imagen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6146320868420380676L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="imagenes_id")
	private Integer imagenesId;
	private String title;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="perros_id")
	private Perro perro;
	private String url;
}
