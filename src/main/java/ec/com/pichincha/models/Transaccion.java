package ec.com.pichincha.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaccion")
public class Transaccion {
	@Id
	@Column(name = "id_transaccion", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_transaccion;

	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "id_cuenta")
	private Integer cuenta;

	public Transaccion() {
		
	}
	public Transaccion(Date fecha, Integer cuenta) {
		// TODO Auto-generated constructor stub
	}

	public Long getId_transaccion() {
		return id_transaccion;
	}

	public void setId_transaccion(Long id_transaccion) {
		this.id_transaccion = id_transaccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}


}
