package com.agrishop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrishop.models.Vendor;
import com.agrishop.repos.VendorRepository;

@Service
public class VendorService {
	
	@Autowired VendorRepository vrepo;
	
	public void saveVendor(Vendor v) {
		vrepo.save(v);
	}
	
	public boolean updatePassword(String userid,String opwd,String pwd) {
		Vendor c=findVendorById(userid);
		System.err.println(pwd);
		if(c.getPwd().equals(opwd)) {
			c.setPwd(pwd);
			vrepo.save(c);
			return true;
		}
		return false;
	}
	
	public List<Vendor> allVendors(){
		return vrepo.findAll();
	}
	
	public Vendor findVendorById(String vid) {
		Optional<Vendor> v=vrepo.findById(vid);
		if(v.isPresent())
			return vrepo.findById(vid).get();
		else
			return null;
	}
	
	public long countVendor() {
		return vrepo.count();
	}
	
	public String generateId() {
		return "Vendor"+(vrepo.count()+1);
	}
	
	public Vendor ValidateLogin(String userid,String pwd) {
		Vendor c=findVendorById(userid);
		if(c==null) {
			return null;
		}
		else  {
			if(c.getPwd().equals(pwd))
				return c;
			else 
				return null;
		}
	}
	
	
}
