package com.spring.demo;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.spring.demo.bean.Person;
import com.spring.demo.config.SpringConfig;
import com.spring.demo.dao.SpringDAO;

public class App {

	static SpringDAO dao;
    static Logger logger=Logger.getLogger(App.class.getName());  
	public static void main(String[] args) {

		logger.info("Excution Starts Here");
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		SpringDAO dao = (SpringDAO) context.getBean(SpringDAO.class);
		logger.info("Created the Person Object ");
		Person person=new Person();
		person.setEmail("saifali.khan@gmail.com");
		person.setFirstname(" N Saif Alikhan");
		
		dao.savePostDetails(person);
        
		/*dao.getPersonDetails();
      */
	/*      dao.updatePersonDetails(); 
	*/
	/*dao.deleteRecordFromPerson();*/
	}
}
