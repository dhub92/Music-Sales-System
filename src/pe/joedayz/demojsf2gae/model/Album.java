package pe.joedayz.demojsf2gae.model;

import java.io.Serializable;

public class Album implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4442264430090665349L;
	
	private Integer id;
	private String tituloAlbum;
	private String artistaAlbum;
	private String generoAlbum;
	private String precioAlbum;
	private String fotoAlbum;
	private String paginaAlbum;		

	public Album()
	{
		
	}	
	
	public Album(Integer id, String tituloAlbum, String artistaAlbum,
			String generoAlbum, String precioAlbum, String fotoAlbum,
			String paginaAlbum) {
		super();
		this.id = id;
		this.tituloAlbum = tituloAlbum;
		this.artistaAlbum = artistaAlbum;
		this.generoAlbum = generoAlbum;
		this.precioAlbum = precioAlbum;
		this.fotoAlbum = fotoAlbum;
		this.paginaAlbum = paginaAlbum;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTituloAlbum() {
		return tituloAlbum;
	}
	public void setTituloAlbum(String tituloAlbum) {
		this.tituloAlbum = tituloAlbum;
	}
	public String getArtistaAlbum() {
		return artistaAlbum;
	}
	public void setArtistaAlbum(String artistaAlbum) {
		this.artistaAlbum = artistaAlbum;
	}
	public String getGeneroAlbum() {
		return generoAlbum;
	}
	public void setGeneroAlbum(String generoAlbum) {
		this.generoAlbum = generoAlbum;
	}
	public String getPrecioAlbum() {
		return precioAlbum;
	}
	public void setPrecioAlbum(String precioAlbum) {
		this.precioAlbum = precioAlbum;
	}
	
	public String getFotoAlbum() {
		return fotoAlbum;
	}

	public void setFotoAlbum(String fotoAlbum) {
		this.fotoAlbum = fotoAlbum;
	}

	public String getPaginaAlbum() {
		return paginaAlbum;
	}

	public void setPaginaAlbum(String paginaAlbum) {
		this.paginaAlbum = paginaAlbum;
	}
}