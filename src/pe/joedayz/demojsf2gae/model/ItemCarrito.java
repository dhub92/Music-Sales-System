package pe.joedayz.demojsf2gae.model;

import java.io.Serializable;




import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;


@Entity
public class ItemCarrito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -158135282307165997L;

	@Id
	private Long id;
	
	private String nombre;	
	
	private Double precio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
}

