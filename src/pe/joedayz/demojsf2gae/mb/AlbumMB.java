package pe.joedayz.demojsf2gae.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.log4j.Logger;




//import pe.joedayz.demojsf2gae.dao.ArticuloDAO;
//import pe.joedayz.demojsf2gae.dao.ArticuloDAOObjectify;
import pe.joedayz.demojsf2gae.model.Album;
import pe.joedayz.demojsf2gae.model.ItemCarrito;

@ManagedBean
@SessionScoped
public class AlbumMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7584759093386335660L;

	private static Logger log = Logger.getLogger(AlbumMB.class);

	//private ArticuloDAO dao;
	
	private Album album;

	private Integer idSelecionado;
	

	private Map<Integer, Album> albumes;
	
	private String busqueda;
	
	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public AlbumMB() {
		//dao = new ArticuloDAOObjectify();
		fillArticulos();
	}	

	public void actualizar() {
		fillArticulos();
	}	

	private void fillArticulos() {
		try {
			albumes = new HashMap<Integer, Album>();
			Album a = new Album(1, "Deeksha", "Angelika", "Gospel y espiritual", "$ 20.00", "resources/img/Portadas/Gospel y espiritual/deekshaANGELIKA.jpg", "");
			
			albumes.put(a.getId(),a);			
			a = new Album (2, "El aire de tu casa", "Jesús Adrian Romero", "Gospel y espiritual", "$ 20.00", "resources/img/Portadas/Gospel y espiritual/elairedetucasaJESUSADRIANROMERO.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (3, "Fuego", "Esperanza de vida", "Gospel y espiritual", "$ 20.00", "resources/img/Portadas/Gospel y espiritual/fuegoESPERANZADEVIDA.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (4, "Jesús mi fiel amigo", "Abel Zavala", "Gospel y espiritual", "$ 20.00", "resources/img/Portadas/Gospel y espiritual/jesusmifielamigoABELZAVALA.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (5, "Mi Regalo", "Marcos Vidal", "Gospel y espiritual", "$ 20.00", "resources/img/Portadas/Gospel y espiritual/miregaloMARCOSVIDAL.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (6, "1989", "Taylor Swift", "Pop", "$ 20.00", "resources/img/Portadas/Pop/1989TAYLORSWIFT.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (7, "21", "Adele", "Pop", "$ 20.00", "resources/img/Portadas/Pop/21ADELE.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (8, "2", "Amaia Montero", "Pop", "$ 20.00", "resources/img/Portadas/Pop/2AMAIAMONTERO.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (9, "Perfecto", "Eros Ramazzotti", "Pop", "$ 20.00", "resources/img/Portadas/Pop/perfectoEROSRAMAZZOTTI.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (10, "Thriller", "Michael Jackson", "Pop", "$ 20.00", "resources/img/Portadas/Pop/thrillerMICHAELJACKSON.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (11, "A través de mi", "Nach", "Rap y hip-hop", "$ 20.00", "resources/img/Portadas/Rap y hip-hop/atravesdemiNACH.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (12, "Bush", "Snoop Dogg", "Rap y hip-hop", "$ 20.00", "resources/img/Portadas/Rap y hip-hop/bushSNOOPDOGG.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (13, "Dark sky paradise", "Big Sean", "Rap y hip-hop", "$ 20.00", "resources/img/Portadas/Rap y hip-hop/darkskyparadiseBIGSEAN.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (14, "Demon days", "Gorillaz", "Rap y hip-hop", "$ 20.00", "resources/img/Portadas/Rap y hip-hop/demondaysGORILLAZ.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (15, "Recovery", "Eminem", "Rap y hip-hop", "$ 20.00", "resources/img/Portadas/Rap y hip-hop/recoveryEMINEM.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (16, "Bark at the moon", "Ozzy Osbourne", "Rock", "$ 20.00", "resources/img/Portadas/Rock/barkatthemoonOZZYOSBOURNE.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (17, "Century child", "Nightwish", "Rock", "$ 20.00", "resources/img/Portadas/Rock/centurychildNIGHTWISH.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (18, "Greatest Hits", "Queen", "Rock", "$ 20.00", "resources/img/Portadas/Rock/greatesthitsQUEEN.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (19, "Ride the lightning", "Metallica", "Rock", "$ 20.00", "resources/img/Portadas/Rock/metallicaRIDETHELIGHTNING.jpg", "");			
			albumes.put(a.getId(),a);
			a = new Album (20, "The wall", "Pink Floyd", "Rock", "$ 20.00", "resources/img/Portadas/Rock/thewallPINKFLOYD.jpg", "");			
			albumes.put(a.getId(),a);
			
			/*Iterator<Integer> it = albumes.keySet().iterator();
			while(it.hasNext()){
			  Integer key = it.next();
			  Album auxAlbum = albumes.get(key);
			  System.out.println(auxAlbum.getTituloAlbum());
			  
			}
			
			System.out.println(albumes.size());*/
			
			/*List<Articulo> qryArticulos = new ArrayList<Articulo>(dao.getAll());
			articulos = new HashMap<Long, Articulo>();
			for (Articulo a: qryArticulos) {
				articulos.put(a.getId(), a);
			}*/
			
			log.debug("Tamaño de la Lista de Albumes ("+albumes.size()+")");
		} catch(Exception ex) {
			log.error("Error al cargar la lista de albumes.", ex);
			addMessage(getMessageFromI18N("msg.erro.listar.articulo"), ex.getMessage());
		}
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		AlbumMB.log = log;
	}

	/*public ArticuloDAO getDao() {
		return dao;
	}

	public void setDao(ArticuloDAO dao) {
		this.dao = dao;
	}*/

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Integer getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Integer idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

	public Map<Integer, Album> getAlbumes() {
		return albumes;
	}

	public void setAlbumes(Map<Integer, Album> albumes) {
		this.albumes = albumes;
	}
	
	
	public DataModel<Album> getDataAlbumes() {
		Map<String,String> params = getCurrentInstance().getExternalContext().getRequestParameterMap();			      
		String genero =  params.get("genero");		
		Map<Integer, Album> albumesAux = new HashMap<Integer, Album>();
		Iterator<Integer> it = albumes.keySet().iterator();
		if (genero==null)
		{
			Album albumAux = albumes.get(1);
			albumesAux.put(albumAux.getId(),albumAux);
			albumAux = albumes.get(6);
			albumesAux.put(albumAux.getId(),albumAux);
			albumAux = albumes.get(11);
			albumesAux.put(albumAux.getId(),albumAux);
			albumAux = albumes.get(16);
			albumesAux.put(albumAux.getId(),albumAux);			
		}
		else
		{
			while(it.hasNext())
			{
				Integer key = it.next();
				Album albumAux = albumes.get(key);
				if (albumAux.getGeneroAlbum().equals(genero))
				{
					albumesAux.put(albumAux.getId(),albumAux);
				}		  
			}
		}		
		return new ListDataModel<Album>(new ArrayList<Album>(albumesAux.values()));
		
	}
	
	public DataModel<Album> getDataAlbumesBusqueda() {
		Map<Integer, Album> albumesAux = new HashMap<Integer, Album>();
		Iterator<Integer> it = albumes.keySet().iterator();
		while(it.hasNext())
		{
			Integer key = it.next();
			Album albumAux = albumes.get(key);
			if (albumAux.getTituloAlbum().equals(busqueda) || albumAux.getArtistaAlbum().equals(busqueda) || albumAux.getGeneroAlbum().equals(busqueda) || albumAux.getGeneroAlbum().equals(busqueda))
			{
				albumesAux.put(albumAux.getId(),albumAux);
			}		  
		}				
		return new ListDataModel<Album>(new ArrayList<Album>(albumesAux.values()));
		
	}

	public void reset() {
		album = null;
		idSelecionado = null;
	}
	
	/*public void agregar(){
		articulo = new Articulo();
		log.debug("Articulo a incluir");
	}*/
	
	public void obtener() {
		if (idSelecionado == null) {
			return;
		}
		album = albumes.get(idSelecionado);
		log.debug("Vamos a mostrar el álbum");
	}	
	
	
	/*public String guardar() {
		try {
			dao.save(articulo);
			articulos.put(articulo.getId(), articulo);
		} catch(Exception ex) {
			log.error("Error al guardar articulo.", ex);
			addMessage(getMessageFromI18N("msg.error.guardar.articulo"), ex.getMessage());
			return "";
		}
		log.debug("Articulo guardado con id  "+articulo.getId());
		return "listaArticulos";
	}*/
	
	public String buscar() {
		if (busqueda.equals(""))
		{
			return "";
		}
		else
		{
			return "listaArticulosBusqueda";
		}		
	}
	
	public String buscarLogin() {
		if (busqueda.equals(""))
		{
			return "";
		}
		else
		{
			return "listaArticulosBusquedaLogin";
		}		
	}
	
	public String agregarItemCarrito()	{
		ItemCarrito itemCarrito = new ItemCarrito();
		itemCarrito.setNombre(album.getTituloAlbum());
		itemCarrito.setPrecio(20.0);
		ItemCarritoMB itemCarritoMB = new ItemCarritoMB();
		itemCarritoMB.guardarItem(itemCarrito);
		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El álbum ha sido añadido al carrito!",""));
		return "";
	}
		
	
	/*public String eliminar() {
		try {
			dao.remove(articulo);
			articulos.remove(articulo.getId());
		} catch(Exception ex) {
			log.error("Error al eliminar articulo.", ex);
			addMessage(getMessageFromI18N("msg.error.eliminar.articulo"), ex.getMessage());
			return "";
		}
		log.debug("Eliminar articulo "+articulo.getId());
		return "listaArticulos";
	}*/
		
	
	private String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	

	private void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}		
}
