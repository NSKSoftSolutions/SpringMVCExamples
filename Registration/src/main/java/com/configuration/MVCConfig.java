package com.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.bean.User;
import com.repositry.UserRepositry;

@EnableTransactionManagement
@EnableWebMvc
@ComponentScan("com.control")
@Component
public class MVCConfig extends WebMvcConfigurerAdapter {

	
	@Bean
	public InternalResourceViewResolver irview()
	{
		
		InternalResourceViewResolver irv=new InternalResourceViewResolver();
		irv.setPrefix("/WEB-INF/jsp/");
		irv.setSuffix(".jsp");
		
		return irv;
	}
	
	@Bean
	public DataSource getDataSource()
	{
		
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/myspring");
		dmds.setUsername("root");
		dmds.setPassword("root");
		
		
		return dmds;
	}
	
	@Bean
	public SessionFactory getSessionFactoy(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		
		Properties p=new Properties();
		p.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		p.put("hibernate.show_sql", "true");
		p.put("hibernate.hbm2ddl.auto","update");
		
		builder.addProperties(p);
		builder.addAnnotatedClass(User.class);
		
		return builder.buildSessionFactory();
		
	}
	
	@Bean
	public HibernateTransactionManager manageTransactions(SessionFactory sessionFactory)
	{
		
		HibernateTransactionManager hm=new HibernateTransactionManager(sessionFactory);
		return hm;
		
	}
	
	@Bean
	public UserRepositry repositry()
	{
		UserRepositry repo=new UserRepositry();
		return repo;
	}
	
	
	
}
