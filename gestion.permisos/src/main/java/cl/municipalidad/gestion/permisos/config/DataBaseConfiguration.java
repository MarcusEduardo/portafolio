package cl.municipalidad.gestion.permisos.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@EnableTransactionManagement
@Configuration
public class DataBaseConfiguration {

	@Autowired
	private ResourceLoader rl;

	@Autowired
	private Environment env;
	
	@Value("${datasource.driver}")
	private String driverClassName;
	
	@Value("${datasource.url}")
	private String jdbcURL;
	
	@Value("${datasource.username}")
	private String username;
	
	@Value("${datasource.password}")
	private String password;
	
	@Value("${datasource.connection-timeout}")
	private Long connectionTimeout;
	
	@Value("${datasource.maximum-pool-size}")
	private Integer poolSize;

	@Bean(destroyMethod = "close")
	public DataSource dataSource(){
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setJdbcUrl(jdbcURL);
	    hikariConfig.setDriverClassName(driverClassName); 
	    hikariConfig.setUsername(username);
	    hikariConfig.setPassword(password);
	    hikariConfig.setMaximumPoolSize(poolSize);
	    hikariConfig.setConnectionTestQuery("select 1 from dual");
	    hikariConfig.setAutoCommit(true);
	    hikariConfig.setPoolName("springHikariCP");
	    hikariConfig.setConnectionTimeout(connectionTimeout);

	    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

	    return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(@Autowired DataSource datasource) throws IOException {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setMappingLocations(loadResources());
		sessionFactoryBean.setDataSource(datasource);

		return sessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

	@Bean
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

	@SuppressWarnings("unused")
	private Properties hibernateProperties() {
		return new Properties() {

			private static final long serialVersionUID = 1L;

			{
				setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
				setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}

	private Resource[] loadResources() {
		Resource[] resources = null;
		try {
			resources = ResourcePatternUtils.getResourcePatternResolver(rl).getResources("classpath:/hbm/*.hbm.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resources;
	}

}
