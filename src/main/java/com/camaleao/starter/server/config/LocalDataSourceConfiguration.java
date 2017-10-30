package com.camaleao.starter.server.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.camaleao.starter.server.model.Usuario;

@Configuration
@Profile("default")
public class LocalDataSourceConfiguration {

	@Bean
	public DataSource dataSource(Environment environment) throws Exception {

		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUsername("root");
		//basicDataSource.setPassword("senha");
		basicDataSource.setUrl("jdbc:mysql://localhost/starter");
		basicDataSource.setInitialSize(5);
		basicDataSource.setMaxActive(10);

		return basicDataSource;

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource)
			throws Exception {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan(Usuario.class.getPackage().getName());
		em.setPersistenceProvider(new HibernatePersistence());
		Map<String, String> p = new HashMap<String, String>();
		p.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
		//p.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "create-drop");
		//p.put(org.hibernate.cfg.Environment.HBM2DDL_IMPORT_FILES, "import_psql.sql");
		p.put(org.hibernate.cfg.Environment.DIALECT, MySQLDialect.class.getName());
		//p.put(org.hibernate.cfg.Environment.SHOW_SQL, "true");
		//p.put(org.hibernate.cfg.Environment.FORMAT_SQL, "true");
		p.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		em.setJpaPropertyMap(p);
		return em;
	}

}
