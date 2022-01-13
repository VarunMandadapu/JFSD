package com.agrishop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {
	@Id
	@NotEmpty(message = "User Id must be given")
	private String userid;
	
	@NotEmpty(message = "Password must be given")
	private String pwd;
	
	@NotEmpty(message = "Confirm Password must be given")
	private String cpwd;
	
	@NotEmpty(message = "First name must be given")
	private String fname;
	@NotEmpty(message = "Last name must be given")
	private String lname;
	@NotEmpty(message = "Date of Birth must be given")
	private String dob;
	@NotEmpty(message= "Gender must be given")
	private String gender;
	
	@NotEmpty(message= "City must be given")
	private String city;

	@NotEmpty(message = "Email must be given")
	@NotNull
	@Column(unique = true)	
	private String email;
	public Customer() {
		// TODO Auto-generated constructor stub
	}	

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [userid=" + userid + ", pwd=" + pwd + ", cpwd=" + cpwd + ", fname=" + fname + ", lname="
				+ lname + ", dob=" + dob + ", gender=" + gender + ", city=" + city + ", email=" + email + "]";
	}

	
	
	
}
