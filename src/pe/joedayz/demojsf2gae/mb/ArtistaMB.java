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
import pe.joedayz.demojsf2gae.model.Artista;

@ManagedBean
@SessionScoped
public class ArtistaMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7584759093386335660L;

	private static Logger log = Logger.getLogger(AlbumMB.class);

	//private ArticuloDAO dao;
	
	private Artista artista;

	private Integer idSelecionado;
	

	private Map<Integer, Artista> artistas;
	
	public ArtistaMB() {
		//dao = new ArticuloDAOObjectify();
		fillArticulos();
	}	

	public void actualizar() {
		fillArticulos();
	}	

	private void fillArticulos() {
		try {
			artistas = new HashMap<Integer, Artista>();
			Artista a = new Artista(1, "Angelika", "Gospel y espiritual", "resources/img/Portadas/Gospel y espiritual/deekshaANGELIKA.jpg");
			
			artistas.put(a.getId(),a);			
			a = new Artista (2, "Jesús Adrian Romero", "Gospel y espiritual", "resources/img/Portadas/Gospel y espiritual/elairedetucasaJESUSADRIANROMERO.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (3, "Esperanza de vida", "Gospel y espiritual", "resources/img/Portadas/Gospel y espiritual/fuegoESPERANZADEVIDA.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (4, "Abel Zavala", "Gospel y espiritual", "resources/img/Portadas/Gospel y espiritual/jesusmifielamigoABELZAVALA.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (5, "Marcos Vidal", "Gospel y espiritual", "resources/img/Portadas/Gospel y espiritual/miregaloMARCOSVIDAL.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (6, "Taylor Swift", "Pop", "resources/img/Portadas/Pop/1989TAYLORSWIFT.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (7, "Adele", "Pop", "resources/img/Portadas/Pop/21ADELE.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (8, "Amaia Montero", "Pop", "resources/img/Portadas/Pop/2AMAIAMONTERO.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (9, "Eros Ramazzotti", "Pop", "resources/img/Portadas/Pop/perfectoEROSRAMAZZOTTI.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (10, "Michael Jackson", "Pop", "resources/img/Portadas/Pop/thrillerMICHAELJACKSON.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (11, "Nach", "Rap y hip-hop", "resources/img/Portadas/Rap y hip-hop/atravesdemiNACH.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (12, "Snoop Dogg", "Rap y hip-hop", "resources/img/Portadas/Rap y hip-hop/bushSNOOPDOGG.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (13, "Big Sean", "Rap y hip-hop", "resources/img/Portadas/Rap y hip-hop/darkskyparadiseBIGSEAN.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (14, "Gorillaz", "Rap y hip-hop", "resources/img/Portadas/Rap y hip-hop/demondaysGORILLAZ.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (15, "Eminem", "Rap y hip-hop", "resources/img/Portadas/Rap y hip-hop/recoveryEMINEM.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (16, "Ozzy Osbourne", "Rock", "resources/img/Portadas/Rock/barkatthemoonOZZYOSBOURNE.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (17, "Nightwish", "Rock", "resources/img/Portadas/Rock/centurychildNIGHTWISH.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (18, "Queen", "Rock", "resources/img/Portadas/Rock/greatesthitsQUEEN.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (19, "Metallica", "Rock", "resources/img/Portadas/Rock/metallicaRIDETHELIGHTNING.jpg");			
			artistas.put(a.getId(),a);
			a = new Artista (20, "Pink Floyd", "Rock", "resources/img/Portadas/Rock/thewallPINKFLOYD.jpg");			
			artistas.put(a.getId(),a);
			
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
			
			log.debug("Tamaño de la Lista de Artistas ("+artistas.size()+")");
		} catch(Exception ex) {
			log.error("Error al cargar la lista de artistas.", ex);
			addMessage(getMessageFromI18N("msg.erro.listar.articulo"), ex.getMessage());
		}
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		ArtistaMB.log = log;
	}

	/*public ArticuloDAO getDao() {
		return dao;
	}

	public void setDao(ArticuloDAO dao) {
		this.dao = dao;
	}*/

	public Artista getArtista() {
		return artista;
	}

	public void setArticulo(Artista artista) {
		this.artista = artista;
	}

	public Integer getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Integer idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

	public Map<Integer, Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(Map<Integer, Artista> artistas) {
		this.artistas = artistas;
	}
	
	
	public DataModel<Artista> getDataArtistas() {
		Map<String,String> params = getCurrentInstance().getExternalContext().getRequestParameterMap();			      
		String genero =  params.get("genero");		
		Map<Integer, Artista> artistasAux = new HashMap<Integer, Artista>();
		Iterator<Integer> it = artistas.keySet().iterator();
		if (genero==null)
		{
			Artista artistaAux = artistas.get(1);
			artistasAux.put(artistaAux.getId(),artistaAux);
			artistaAux = artistas.get(6);
			artistasAux.put(artistaAux.getId(),artistaAux);
			artistaAux = artistas.get(11);
			artistasAux.put(artistaAux.getId(),artistaAux);
			artistaAux = artistas.get(16);
			artistasAux.put(artistaAux.getId(),artistaAux);						
		}
		else
		{
			while(it.hasNext())
			{
				Integer key = it.next();
				Artista artistaAux = artistas.get(key);
				if (artistaAux.getGeneroArtista().equals(genero))
				{
					artistasAux.put(artistaAux.getId(),artistaAux);
				}		  
			}
		}		
		return new ListDataModel<Artista>(new ArrayList<Artista>(artistasAux.values()));
		
	}

	public void reset() {
		artista = null;
		idSelecionado = null;
	}
	
	/*public void agregar(){
		articulo = new Articulo();
		log.debug("Articulo a incluir");
	}
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		articulo = articulos.get(idSelecionado);
		log.debug("Vamos a editar articulo");
	}	
	
	
	public String guardar() {
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
	}
		
	
	public String eliminar() {
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
