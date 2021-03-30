package ar.edu.um.disenio.dogsupport.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vacunacion")
@Getter
@Setter
@ToString
public class Vacunacion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2988244785801065218L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vacunacion_id")
	private Integer vacunacionId;
	@JoinColumn(name="vacuna_id")
	@OneToOne
	private Vacuna vacuna;
	@JoinColumn(name="perro_id")
	@ManyToOne
	private Perro perro;
	private LocalDate fecha;
}
