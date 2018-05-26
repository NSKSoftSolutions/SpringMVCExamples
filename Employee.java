package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Employee {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empid;
	private String empname;
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	private String orgemail;
	public String getOrgemail() {
		return orgemail;
	}
	public void setOrgemail(String orgemail) {
		this.orgemail = orgemail;
	}
	private String emppresentadd;
	private String emppermanent;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmppresentadd() {
		return emppresentadd;
	}
	public void setEmppresentadd(String emppresentadd) {
		this.emppresentadd = emppresentadd;
	}
	public String getEmppermanent() {
		return emppermanent;
	}
	public void setEmppermanent(String emppermanent) {
		this.emppermanent = emppermanent;
	}
}
