package cl.municipalidad.gestion.permisos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cl.municipalidad.gestion.permisos.dao.UsuarioDao;
import cl.municipalidad.gestion.permisos.dto.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	
	private final static Logger logger = LoggerFactory.getLogger(ApplicationTests.class);
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Transactional
	@Test
	public void grabaUsuario() throws Exception {
		
		logger.info("Se realiza prueba de creacion de usuario...");
		
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNombre("marcos");
		usuario.setContrasenia("marcos123");
		
		Long id = (Long) usuarioDao.save(usuario);
		
		if(id==null) throw new Exception("No se grabo el usuario");
		
		Usuario u = usuarioDao.getUsuario(1);
		logger.info("usuario:{}",u);
		
		
		logger.info("Prueba finalizada.");
	}

}
