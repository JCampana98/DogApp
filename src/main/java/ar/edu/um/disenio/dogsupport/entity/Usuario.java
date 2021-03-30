package ar.edu.um.disenio.dogsupport.entity;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
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
@Table(name="usuarios")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8517604810769197338L;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String password;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuario_id")
	private Integer usuarioId;
}
