package com.agrishop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agrishop.models.OrderDetails;
import com.agrishop.repos.OrderDetailsRepository;

@Service
public class OrderDetailsService {

	@Autowired private OrderDetailsRepository odrepo;
	
	public List<OrderDetails> allItemsinOrder(int orderid){
		return odrepo.findByOrderid(orderid);
	}
	
	public List<OrderDetails> allVendorItemsinOrder(int orderid,String vendorid){
		return odrepo.findVendorItems(orderid, vendorid);
	}
	
	public OrderDetails findById(int id) {
		return odrepo.getById(id);
	}
	
	public void saveItem(OrderDetails od) {		
		odrepo.save(od);
	}
	
	public void deleteAllItems(int orderid) {
		odrepo.deleteByOrderid(orderid);
	}
	
}
