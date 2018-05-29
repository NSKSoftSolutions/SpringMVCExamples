package com.spring.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.demo.bean.Person;

public class SpringDAOTest {

	Session session;
    @Autowired
	SessionFactory factory;
	@Test
	public void testSavePostDetails() {

		Person p=new Person();
               p.setFirstname("sajju");
               p.setEmail("sajju@gmail.com");
		session=factory.openSession();
		session.save(p);
		
		}
		
		
	}

