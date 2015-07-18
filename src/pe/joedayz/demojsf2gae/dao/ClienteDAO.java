package pe.joedayz.demojsf2gae.dao;

import java.util.List;

import pe.joedayz.demojsf2gae.model.Cliente;

public interface ClienteDAO {

	
	
	Long save(Cliente cliente);

	List<Cliente> getAll();

	Boolean remove(Cliente cliente);
	

	Cliente findById(Long id);	
	
}
