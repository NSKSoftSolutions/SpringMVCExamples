package com.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Orgnization {

	@Id
	private String orgemail;
	private String orgname;
	private String orgadd;
	@OneToMany(targetEntity=Employee.class,cascade=CascadeType.ALL)
	@JoinColumn(name="orgemail")
	private Set emplyeedetails;
	public String getOrgemail() {
		return orgemail;
	}
	public void setOrgemail(String orgemail) {
		this.orgemail = orgemail;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getOrgadd() {
		return orgadd;
	}
	public void setOrgadd(String orgadd) {
		this.orgadd = orgadd;
	}
	public Set getEmplyeedetails() {
		return emplyeedetails;
	}
	public void setEmplyeedetails(Set emplyeedetails) {
		this.emplyeedetails = emplyeedetails;
	}
	
	
}
