package com.agrishop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.agrishop.models.Cart;
import com.agrishop.models.Customer;
import com.agrishop.models.Order;
import com.agrishop.models.OrderDetails;
import com.agrishop.repos.OrderRepository;

@Service
public class OrderService {
	
	@Autowired private OrderRepository orepo;
	@Autowired private CartService cartsrv;
	@Autowired private CustomerService custsrv;
	@Autowired private OrderDetailsService odsrv;
	
	public List<Order> allOrders(){
		return orepo.findAll(Sort.by(Direction.DESC,"id"));
	}
	
	public List<Order> vendorOrders(String vendorid){
		return orepo.findVendorOrders(vendorid);
	}
	
	public List<Order> pendingOrders(){
		return orepo.findByStatusOrderByIdDesc("Pending");
	}
	
	public List<Order> allUserOrders(String userid){
		return orepo.findByUseridOrderByIdDesc(userid);
	}
	
	public Order getOrderDetails(int orderid) {
		return orepo.findById(orderid).get();
	}
	
	public void cancelOrder(int orderid) {
		odsrv.deleteAllItems(orderid);
		orepo.deleteById(orderid);
	}
	
	public void confirmOrder(int id) {
		Order order=orepo.getById(id);
		order.setStatus("Confirmed");
		orepo.save(order);
	}
	
	public int placeOrder(Order o,String userid) {
		
		Customer customer=custsrv.findByUserId(userid);
		o.setUserid(userid);
		o.setCustomer(customer);
		Order order=orepo.save(o);
		List<Cart> cartitems=cartsrv.findItemsByUserId(userid);
		for(Cart c : cartitems) {
			OrderDetails od=new OrderDetails();
			od.setOrder(order);
			od.setOrderid(order.getId());
			od.setProduct(c.getProduct());
			od.setQty(c.getQty());
			od.setVendorid(c.getProduct().getVendorid());
			od.setProdid(c.getProdid());
			od.setVendor(c.getProduct().getVendor());
			od.setPrice(c.getProduct().getSaleprice());
			od.setStatus("Pending");
			odsrv.saveItem(od);
		}		
		cartsrv.emptyCart(userid);
		return o.getId();
	}
}
