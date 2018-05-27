package com.control;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.User;
import com.repositry.UserRepositry;

@Controller
public class UserController {

	@Autowired
	UserRepositry repo;
	
	User u;
	@RequestMapping("/register")
	public ModelAndView userregister(@ModelAttribute User user)
	{
		ModelAndView mv=new ModelAndView();
		repo.saveUserInfo(user);
		mv.addObject("user",user);
		mv.setViewName("success");
		return mv;
	}
	
	@GetMapping("/userget")
	public ModelAndView getUsers()
	{
		
		ModelAndView mv=new ModelAndView();
		List list=repo.getUser();
		
		
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			Object obj=itr.next();
		      u=(User)obj;
		    System.out.println("FirstName:"+u.getFirstname());
		    System.out.println("MiddleName:"+u.getMiddlename());
		    System.out.println("LastName:"+u.getLastname());
            System.out.println("Email:"+u.getEmail());
            System.out.println("Mobile:"+u.getMobile());
		}
		mv.addObject("u",u);
		mv.setViewName("getusersuccess");
		return mv;
		
		
		
	}
	
}
