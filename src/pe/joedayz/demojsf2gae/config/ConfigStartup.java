package pe.joedayz.demojsf2gae.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import pe.joedayz.demojsf2gae.model.*;

import com.googlecode.objectify.ObjectifyService;

public class ConfigStartup implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(Articulo.class);
		ObjectifyService.register(Cliente.class);
		ObjectifyService.register(ItemCarrito.class);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}
	
}
