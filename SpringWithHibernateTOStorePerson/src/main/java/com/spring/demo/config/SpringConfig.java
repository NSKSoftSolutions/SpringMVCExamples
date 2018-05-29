package com.spring.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.spring.demo.bean.Person;
import com.spring.demo.dao.SpringDAO;


@Configuration
@EnableTransactionManagement
public class SpringConfig {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/myspring");
		ds.setUsername("root");
		ds.setPassword("root");

		return ds;
	}


	@Bean
	public SessionFactory getSessionFactory(DataSource ds) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);

		Properties prop = new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		builder.addAnnotatedClass(Person.class);
		builder.addProperties(prop);

		return builder.buildSessionFactory();
	}

	@Bean
	public HibernateTransactionManager getTransations(SessionFactory factory)
	{
	HibernateTransactionManager hm=new HibernateTransactionManager(factory);
	return hm;
	}

	@Bean
	public HibernateTemplate addTemplate(SessionFactory factory)
	{
		HibernateTemplate t=new HibernateTemplate(factory);
		return t;
	}
	
	@Bean
	public SpringDAO getDAO()
	{
		SpringDAO dao=new SpringDAO();
		
		return dao;
	}

}

