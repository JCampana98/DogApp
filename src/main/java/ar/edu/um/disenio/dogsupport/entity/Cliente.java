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
@Table(name="clientes")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1300341220971117325L;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cliente_id")
	private Integer clienteId;
	
}
