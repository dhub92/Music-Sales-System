package pe.joedayz.demojsf2gae.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.Serializable;
import java.util.List;

import pe.joedayz.demojsf2gae.model.ItemCarrito;

import com.googlecode.objectify.Key;

public class ItemCarritoDAOObjectify implements Serializable, ItemCarritoDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 327753958477302117L;

	@Override
	public Long save(ItemCarrito itemCarrito) {
		ofy().save().entity(itemCarrito).now();
		return itemCarrito.getId();
	}

	@Override
	public List<ItemCarrito> getAll() {
		return ofy().load().type(ItemCarrito.class).list();
	}

	@Override
	public Boolean remove(ItemCarrito itemCarrito) {
		ofy().delete().entity(itemCarrito).now();
		return true;
	}

	@Override
	public ItemCarrito findById(Long id) {
		Key<ItemCarrito> k = Key.create(ItemCarrito.class, id);
		return ofy().load().key(k).get();
	}

}
