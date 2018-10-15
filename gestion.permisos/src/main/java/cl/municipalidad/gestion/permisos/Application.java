package cl.municipalidad.gestion.permisos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import cl.municipalidad.gestion.permisos.config.DataBaseConfiguration;

@Configuration
@Import(DataBaseConfiguration.class)
@SpringBootApplication(exclude=JpaRepositoriesAutoConfiguration.class)
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
