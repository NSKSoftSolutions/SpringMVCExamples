package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.bean.Employee;
import com.bean.Orgnization;
import com.repositry.OrganizationRepo;

@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.controller")
@Configuration
public class MVCConfiguration extends WebMvcConfigurerAdapter {

	
	@Bean
	public InternalResourceViewResolver viewresolvere()
	{
		
		InternalResourceViewResolver irv=new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/jsp/");
		irv.setSuffix(".jsp");
		
		return irv; 
	}
	
	@Bean
	public DataSource getDs()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/myspring");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	}
	
	@Bean
	public SessionFactory getSessionfactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		Properties p=new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		p.put("hibernate.hbm2ddl.auto","update");
		p.put("hibernate.show_sql", "true");
		
		builder.addProperties(p);
		builder.addAnnotatedClasses(Orgnization.class,Employee.class);
		
		return builder.buildSessionFactory();
	}
	
	@Bean
	public HibernateTransactionManager manageAllTxs(SessionFactory sessionFactory)
	{
		
		HibernateTransactionManager hm=new HibernateTransactionManager(sessionFactory);
		return hm;
		
		
	}

	@Bean
	public OrganizationRepo getRepo()
	{
		OrganizationRepo rrepo=new OrganizationRepo();
		return rrepo;
		
	}
	
}
