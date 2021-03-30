package ar.edu.um.disenio.dogsupport.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="perros")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Perro implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1026048883649208845L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="perro_id")
	private Integer perroId;
	private String nombre;
	private String raza;
    @Enumerated(EnumType.STRING)
	private Sexo sexo;
    @Enumerated(EnumType.STRING)
	private Tamanio tamanio;
	private String descripcion;
    @Enumerated(EnumType.STRING)
	private Edad edad;
	@Column(name="apto_perros")
	private Boolean aptoPerros;
	@Column(name="apto_ninios")
	private Boolean aptoNinios;
	private Boolean entrenado;
	private Boolean esterilizado;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="perro")
	private List<Vacunacion> vacunaciones;
	private String fotoperfil;
	private Boolean adoptado;
	private Boolean ingresado;
	@JoinColumn(name="cliente_ingreso_id")
	@ManyToOne(fetch=FetchType.EAGER)
	private Cliente clienteIngreso;
	@JoinColumn(name="cliente_adoptado_id")
	@OneToOne(fetch=FetchType.EAGER)
	private Cliente clienteAdoptado;
	
}
