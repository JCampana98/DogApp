package ar.edu.um.disenio.dogsupport.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vacunas")
@Getter
@Setter
@ToString
public class Vacuna implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2988244785801065218L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vacuna_id")
	private Integer vacunaId;
	private String nombre;
}
