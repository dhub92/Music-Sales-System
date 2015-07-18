package pe.joedayz.demojsf2gae.model;

import java.io.Serializable;

public class Artista implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5600450508638479703L;
	
	private Integer id;
	private String nombreArtista;
	private String generoArtista;	
	private String fotoArtista;
	
	public Artista()
	{
		
	}
	
	public Artista(Integer id, String nombreArtista, String generoArtista,
			String fotoArtista) {
		super();
		this.id = id;
		this.nombreArtista = nombreArtista;
		this.generoArtista = generoArtista;
		this.fotoArtista = fotoArtista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreArtista() {
		return nombreArtista;
	}

	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	public String getGeneroArtista() {
		return generoArtista;
	}

	public void setGeneroArtista(String generoArtista) {
		this.generoArtista = generoArtista;
	}

	public String getFotoArtista() {
		return fotoArtista;
	}

	public void setFotoArtista(String fotoArtista) {
		this.fotoArtista = fotoArtista;
	}
	
}
