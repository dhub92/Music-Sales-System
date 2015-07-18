package pe.joedayz.demojsf2gae.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.Serializable;
import java.util.List;

import pe.joedayz.demojsf2gae.model.Cliente;

import com.googlecode.objectify.Key;

public class ClienteDAOObjectify implements Serializable, ClienteDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -488841606199484060L;

	@Override
	public Long save(Cliente cliente) {
		ofy().save().entity(cliente).now();
		return cliente.getId();
	}

	@Override
	public List<Cliente> getAll() {
		return ofy().load().type(Cliente.class).list();
	}

	@Override
	public Boolean remove(Cliente articulo) {
		ofy().delete().entity(articulo).now();
		return true;
	}

	@Override
	public Cliente findById(Long id) {
		Key<Cliente> k = Key.create(Cliente.class, id);
		return ofy().load().key(k).get();
	}

}
