package pe.joedayz.demojsf2gae.dao;

import java.util.List;

import pe.joedayz.demojsf2gae.model.Articulo;

public interface ArticuloDAO {

	
	
	Long save(Articulo articulo);

	List<Articulo> getAll();

	Boolean remove(Articulo articulo);
	

	Articulo findById(Long id);
	
	
}
