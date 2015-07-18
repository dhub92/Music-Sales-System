package pe.joedayz.demojsf2gae.dao;

import java.util.List;

import pe.joedayz.demojsf2gae.model.ItemCarrito;

public interface ItemCarritoDAO {

	
	
	Long save(ItemCarrito itemCarrito);

	List<ItemCarrito> getAll();

	Boolean remove(ItemCarrito itemCarrito);
	

	ItemCarrito findById(Long id);
	
	
}

