package com.spring.demo.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.demo.bean.Person;

@Component
public class SpringDAO {

	List<Person> persondetails;

	@Autowired
	SessionFactory factory;

	int i;

	@Autowired
	HibernateTemplate template;
	Session session;
	Logger logger = Logger.getLogger(SpringDAO.class.getName());

	@Transactional
	public int savePostDetails(Person p) {
		logger.info("came inside the SaveDetails()");
		// TODO Auto-generated method stub
		session = factory.openSession();
        i = (Integer) session.save(p);
		logger.info(i + "Object Saved Successfully");
		logger.info("done the Transaction Coming outside of the Method");
		return i;
	}

	public List<Person> getPersonDetails() {
		logger.info("came inside the getPersonDetails() and started executing the method");
		session = factory.openSession();
		Query q = session.createQuery("from Person p");
		persondetails = q.list();
		Iterator itr = persondetails.iterator();
		while (itr.hasNext()) {
			Object obj = itr.next();
			Person p = (Person) obj;
			System.out.println(p.getFirstname());
			System.out.println(p.getEmail());
		}

		logger.info("Close the Execution ");
		return persondetails;

	}

	@Transactional
	public void updatePersonDetails() {
		logger.info("came inside the UdpatePersonDetails() method and Statred Updating the things");
		session = factory.openSession();
		Query q = session.createQuery(
				"Update Person p set p.firstname='NAVAB SHABEER KHAN', p.email='shabeer.khan@gmail.com' where p.firstname='shabeer khan'");
		int row_updates = q.executeUpdate();
		logger.info("Row Udpated:" + row_updates);
	}

	public void deleteRecordFromPerson() {
		logger.info("Coming inside the DeleteRecordFromPerson() method and started Deleteing the Record");
		session = factory.openSession();
		Query q = session.createQuery("delete from Person p where p.firstname='NAVABSAJJAD ALIKHAN'");
		int row_deleted = q.executeUpdate();
		logger.info("Row deleted:" + row_deleted);
	}

}
