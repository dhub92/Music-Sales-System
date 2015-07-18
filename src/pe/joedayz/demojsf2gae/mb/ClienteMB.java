package pe.joedayz.demojsf2gae.mb;

import static javax.faces.context.FacesContext.getCurrentInstance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
//import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.apache.log4j.Logger;

import pe.joedayz.demojsf2gae.dao.ClienteDAO;
import pe.joedayz.demojsf2gae.dao.ClienteDAOObjectify;
import pe.joedayz.demojsf2gae.model.Cliente;

@ManagedBean
@SessionScoped
public class ClienteMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8149277260790273226L;
	
	private static Logger log = Logger.getLogger(ClienteMB.class);

	private ClienteDAO dao;
	
	private Cliente cliente;

	private Long idSelecionado;
	

	private Map<Long, Cliente> clientes;
	
	public ClienteMB() {
		dao = new ClienteDAOObjectify();
		fillClientes();
	}
	
	

	public void actualizar() {
		fillClientes();
	}	

	private void fillClientes() {
		try {
			List<Cliente> qryClientes = new ArrayList<Cliente>(dao.getAll());
			clientes = new HashMap<Long, Cliente>();
			for (Cliente a: qryClientes) {
				clientes.put(a.getId(), a);
			}
			
			log.debug("Tamaño de la Lista de Articulos ("+clientes.size()+")");
		} catch(Exception ex) {
			log.error("Error al cargar la lista de clientes.", ex);
			addMessage(getMessageFromI18N("msg.erro.listar.cliente"), ex.getMessage());
		}
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		ClienteMB.log = log;
	}

	public ClienteDAO getDao() {
		return dao;
	}

	public void setDao(ClienteDAO dao) {
		this.dao = dao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Long getIdSelecionado() {
		return idSelecionado;
	}

	public void setIdSelecionado(Long idSelecionado) {
		this.idSelecionado = idSelecionado;
	}

	public Map<Long, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Map<Long, Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	public DataModel<Cliente> getDataClientes() {
		return new ListDataModel<Cliente>(new ArrayList<Cliente>(clientes.values()));
	}

	public void reset() {
		cliente = null;
		idSelecionado = null;
	}
	
	public void agregar(){
		cliente = new Cliente();
		log.debug("Cliente a incluir");
	}
	
	public void editar() {
		if (idSelecionado == null) {
			return;
		}
		cliente = clientes.get(idSelecionado);
		log.debug("Vamos a editar cliente");
	}	
	
	
	public String guardar() {
		Iterator<Long> it = clientes.keySet().iterator();
		boolean existe=false;
		while(it.hasNext()){
		  Long key = it.next();
		  Cliente auxCliente = clientes.get(key);
		  if (cliente.getCorreo().equals(auxCliente.getCorreo()))
		  {
			  existe=true;
			  getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Correo Electrónico: Error de validación: el correo electrónico ya esta siendo usado."));			  
		  }
		}		
		if (existe==false)
		{
			try 
			{
				dao.save(cliente);
				clientes.put(cliente.getId(), cliente);			
			} 
			catch(Exception ex) 
			{
				log.error("Error al guardar cliente.", ex);
				addMessage(getMessageFromI18N("msg.error.guardar.cliente"), ex.getMessage());
				return "";
			}
			log.debug("Cliente guardado con id  "+cliente.getId());
			return "usuarioAgregado";
		}
		else
		{
			return "listarClientes"; //Se mantiena en la ventana dado que no existe listar clientes
		}
	}
		
	
	public String eliminar() {
		try {			
			dao.remove(cliente);
			clientes.remove(cliente.getId());
		} catch(Exception ex) {
			log.error("Error al eliminar cliente.", ex);
			addMessage(getMessageFromI18N("msg.error.eliminar.cliente"), ex.getMessage());
			return "";
		}
		log.debug("Eliminar cliente "+cliente.getId());
		return "listaArticulos";
	}
		
	
	private String getMessageFromI18N(String key) {
		ResourceBundle bundle = ResourceBundle.getBundle("messages_labels", getCurrentInstance().getViewRoot().getLocale());
		return bundle.getString(key);
	}
	

	private void addMessage(String summary, String detail) {
		getCurrentInstance().addMessage(null, new FacesMessage(summary, summary.concat("<br/>").concat(detail)));
	}
	
	public String permitirAcceso()
	{
		Iterator<Long> it = clientes.keySet().iterator();
		while(it.hasNext()){
		  Long key = it.next();
		  Cliente auxCliente = clientes.get(key);
		  if (cliente.getCorreo().equals(auxCliente.getCorreo()) && cliente.getPassword().equals(auxCliente.getPassword()))
		  {
			  cliente.setNombre(auxCliente.getNombre());
			  return "listaArticulosLogin";
		  }
		}		
		getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Usuario y/o contraseña incorrectos."));
		return "iniciarSesion";
	}
	
}
