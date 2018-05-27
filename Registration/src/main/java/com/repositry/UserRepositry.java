package com.repositry;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.User;

@SuppressWarnings("deprecation")
@Component
public class UserRepositry {

	@Autowired
	SessionFactory factory;
	
	Session session;

	
	@Transactional
	public void saveUserInfo(User user) {
		// TODO Auto-generated method stub
	
		session=factory.getCurrentSession();
		session.save(user);
		
	}

	@Transactional
	public List<User> getUser()
	{
		// TODO Auto-generated method stub
	
		session=factory.getCurrentSession();
		
		Criteria crit=session.createCriteria(User.class);
		  List list=crit.list();
		return list;
	}
	
	
	
	
}
