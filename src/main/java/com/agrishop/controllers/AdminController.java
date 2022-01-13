package com.agrishop.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.agrishop.models.Category;
import com.agrishop.models.Order;
import com.agrishop.models.OrderDetails;
import com.agrishop.models.Product;
import com.agrishop.models.Vendor;
import com.agrishop.service.CategoryService;
import com.agrishop.service.CustomerService;
import com.agrishop.service.OrderDetailsService;
import com.agrishop.service.OrderService;
import com.agrishop.service.ProductService;
import com.agrishop.service.VendorService;

@Controller
public class AdminController {
	
	@Autowired private CategoryService catsrv;
	@Autowired private ProductService prodsrv;
	@Autowired private CustomerService custsrv;
	@Autowired private OrderService ordersrv;
	@Autowired private OrderDetailsService odsrv;
	@Autowired private VendorService vsrv;
	@Autowired private HttpSession session;
	

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("totalusers", custsrv.allCustomers().size());
		model.addAttribute("totalproducts", prodsrv.countProducts());
		model.addAttribute("totalcategories", catsrv.totalCategories());
		model.addAttribute("totalorders", ordersrv.allOrders().size());		
		return "dashboard";
	}
	
	@GetMapping("/customers")
	public String customerlist(Model model){	
		model.addAttribute("users",custsrv.allCustomers());
		return "customers";
	}
	
	@GetMapping("/orders")
	public String orderslist(Model model){
		String userid=session.getAttribute("userid").toString();
		model.addAttribute("orders", ordersrv.vendorOrders(userid));
		return "orders";
	}
	
	@GetMapping("/confirm/{id}")
	public String confirmOrder(@PathVariable("id") int orderid){
		ordersrv.confirmOrder(orderid);
		session.setAttribute("msg", "Order Confirmed successfully");
		return "redirect:/orders";
	}
	
	@GetMapping("/details/{id}")
	public String orderdetails(@PathVariable("id") int orderid, Model model){
		String userid=session.getAttribute("userid").toString();
		Order order=ordersrv.getOrderDetails(orderid);
		List<OrderDetails> odlist=odsrv.allVendorItemsinOrder(orderid, userid);
		System.out.println("Total items : "+odlist.size());
		model.addAttribute("cats", catsrv.getAllCategories());
		model.addAttribute("o", order);
		model.addAttribute("items",odlist);		
		model.addAttribute("cqty", odlist.size());
		return "orderdetails";
	}
	
	@GetMapping("/changepwd")
	public String changepassword(){		
		return "achangepwd";
	}
	
	@GetMapping("/vendors")
	public String vendors(Model model) {
		model.addAttribute("vendorid", vsrv.generateId());
		model.addAttribute("items", vsrv.allVendors());
		return "vendors";
	}
	
	@PostMapping("/vendors")
	public String saveVendor(Vendor v) {
		vsrv.saveVendor(v);
		session.setAttribute("msg", "Vendor saved successfully");
		return "redirect:/vendors";
	}
	
	@PostMapping("/changepwd")
	public String changepassword(String userid,String cpwd,String pwd,String opwd) {	
		System.out.println(userid);
		if(vsrv.updatePassword(userid, opwd, pwd)) {
			session.setAttribute("msg", "Password updated successfully");
		}
		else {
			session.setAttribute("error", "Incorrect current password");
		}
		return "redirect:/changepwd";
	}
	
	@GetMapping(path = {"/products","/products/{page}"})
	public String products(@PathVariable("page") Optional<Integer> page,Model model,String name) {
		int pageno=page.isPresent() ? page.get()-1 : 0;
		Page<Product> plist=prodsrv.allProducts(pageno,name);
		model.addAttribute("prods", plist.toList());
		model.addAttribute("current", pageno+1);
		model.addAttribute("totalpages", plist.getTotalPages());
		model.addAttribute("totalprods", plist.getTotalElements());
		model.addAttribute("cats", catsrv.getAllCategories());
		return "products";
	}
	
	@GetMapping("/delprod/{id}")
	public String deleteproduct(@PathVariable("id") int id) {
		prodsrv.deleteProduct(id);
		session.setAttribute("msg", "Product deleted successfully");
		return "redirect:/products";
	}
	
	@PostMapping("/products")
	public String saveProduct(MultipartFile photo,Product p) {

		Category cat=catsrv.findByCatId(p.getCatid());
		p.setCategory(cat);
		p.setVendor(vsrv.findVendorById(p.getVendorid()));
		System.err.println(p);
		prodsrv.saveProduct(p, photo);
		session.setAttribute("msg", "Product saved successfully");
		return "redirect:/products";
	}
	
	@GetMapping(path = {"/categories","/categories/{id}"})
	public String categories(Model model,@PathVariable("id") Optional<Integer> id) {
		if(id.isPresent()) {
			Category cat=catsrv.findByCatId(id.get());
			model.addAttribute("catid",cat.getCatid());
			model.addAttribute("catname",cat.getCatname());				
		}else {			
			model.addAttribute("catid", catsrv.generateCatId());		
		}
		model.addAttribute("cats", catsrv.getAllCategories());		
		return "category";
	}	

	@PostMapping(path = {"/categories","/categories/{id}"})
	public String saveCategories(Category cat) {
		cat.setVendor(vsrv.findVendorById(cat.getVendorid()));
		System.out.println("catid : "+cat.getCatname());
		catsrv.saveCategory(cat);
		session.setAttribute("msg", "Category saved successfully");
		return "redirect:/categories";
	}
	
	@GetMapping("/logout")
	public String logout(){
		session.invalidate();
		return "redirect:/";
	}
}
