package pe.joedayz.demojsf2gae.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.log4j.Logger;

import pe.joedayz.demojsf2gae.dao.ItemCarritoDAO;
import pe.joedayz.demojsf2gae.dao.ItemCarritoDAOObjectify;
import pe.joedayz.demojsf2gae.model.ItemCarrito;

@ManagedBean
@SessionScoped
public class ItemCarritoMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4142189334666977618L;

	private static Logger log = Logger.getLogger(ItemCarritoMB.class);

	private ItemCarritoDAO dao;
	
	private ItemCarrito itemCarrito;

	private Long idSelecionado;	

	private Map<Long, ItemCarrito> itemsCarrito;
	
	private Double totalCarrito;
	
	public Double getTotalCarrito() {
		return totalCarrito;
	}



	public void setTotalCarrito(Double totalCarrito) {
		this.totalCarrito = totalCarrito;
	}



	public ItemCarritoMB() {
		dao = new ItemCarritoDAOObjectify();
		fillItemsCarrito();
	}
	
	

	public void actualizar() {
		fillItemsCarrito();
	}	

	private void fillItemsCarrito() {
		try {
			List<ItemCarrito> qryItemsCarritos = new ArrayList<ItemCarrito>(dao.getAll());
			itemsCarrito = new HashMap<Long, ItemCarrito>();
			for (ItemCarrito a: qryItemsCarritos) {
				itemsCarrito.put(a.getId(), a);
			}
			
			log.debug("Tamaño de la Lista de items de carrito ("+itemsCarrito.size()+")");
		} catch(Exception ex) {
			log.error("Error al cargar la lista de items de carrito.", ex);
			addMessage(getMessageFromI18N("msg.erro.listar.articulo"), ex.getMessage());
		}
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		ItemCarritoMB.log = log;
	}

	public ItemCarritoDAO getDao() {
		return dao;
	}

	public void setDao(ItemCarritoDAO dao) {
		this.dao = dao;
	}

	public ItemCarrito getItemCarrito() {
		return itemCarrito;
	}

	public void setItemCarrito(ItemCarrito itemCarrito) {
		this.itemCarrito = itemCarrito;
	}

	public Long getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

	public Map<Long, ItemCarrito> getItemsCarrito() {
		return itemsCarrito;
	}

	public void setItemsCarrito(Map<Long, ItemCarrito> itemsCarrito) {
		this.itemsCarrito = itemsCarrito;
	}
	
	
	public DataModel<ItemCarrito> getDataItemsCarrito() {
		fillItemsCarrito();
		totalCarrito=0.0;
		Iterator<Long> it = itemsCarrito.keySet().iterator();
		while(it.hasNext())
		{
		  Long key = it.next();
		  ItemCarrito auxItemCarrito = itemsCarrito.get(key);
		  totalCarrito=totalCarrito+auxItemCarrito.getPrecio();
		  
		}
		return new ListDataModel<ItemCarrito>(new ArrayList<ItemCarrito>(itemsCarrito.values()));
	}

	public void reset() {
		itemCarrito = null;
		idSelecionado = null;
	}
	
	public void agregar(){
		itemCarrito = new ItemCarrito();
		log.debug("Item a incluir");
	}
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		itemCarrito = itemsCarrito.get(idSelecionado);
		log.debug("Vamos a editar un item");
	}	
	
	
	public String guardar() {
		try {
			dao.save(itemCarrito);
			itemsCarrito.put(itemCarrito.getId(), itemCarrito);
		} catch(Exception ex) {
			log.error("Error al guardar el item.", ex);
			addMessage(getMessageFromI18N("msg.error.guardar.articulo"), ex.getMessage());
			return "";
		}
		log.debug("Item guardado con id  "+itemCarrito.getId());
		return ""; //No vamos a ningún lado
	}
	
	public String guardarItem(ItemCarrito itemCarrito) {
		try {
			dao.save(itemCarrito);
			itemsCarrito.put(itemCarrito.getId(), itemCarrito);
		} catch(Exception ex) {
			log.error("Error al guardar el item.", ex);
			addMessage(getMessageFromI18N("msg.error.guardar.articulo"), ex.getMessage());
			return "";
		}
		log.debug("Item guardado con id  "+itemCarrito.getId());
		return ""; //No vamos a ningún lado
	}
		
	
	public String eliminar() {		
		try {			
			itemCarrito = itemsCarrito.get(idSelecionado);
			dao.remove(itemCarrito);
			itemsCarrito.remove(itemCarrito.getId());
		} catch(Exception ex) {
			log.error("Error al eliminar item.", ex);
			addMessage(getMessageFromI18N("msg.error.eliminar.articulo"), ex.getMessage());
			return "";
		}
		log.debug("Eliminar item "+itemCarrito.getId());
		return "listaItemsCarrito";
	}
	
	public void obtener() {
		if (idSelecionado == null) {
			return;
		}
		itemCarrito = itemsCarrito.get(idSelecionado);
		log.debug("Vamos a mostrar el álbum");
	}
		
	
	private String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	

	private void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
	
}

