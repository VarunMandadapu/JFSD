package com.agrishop.service;

import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.agrishop.models.Product;
import com.agrishop.repos.ProductRepository;

@Service
public class ProductService {
	
	@Autowired private ProductRepository productrepo;
	@Autowired ServletContext ctx;
	
	public Page<Product> allProducts(int page,String name){
		if(name!=null) {
			return productrepo.findByDeletedAndPnameContainingOrderByProdidDesc(false,name,PageRequest.of(page, 8));
		}else {
			return productrepo.findByDeletedOrderByProdidDesc(false,PageRequest.of(page, 8));
		}
	}
	
	public Page<Product> allHomePageProducts(int page){
		List<Product> plist=productrepo.findByDeletedOrderByProdidDesc(false);
		Page<Product> prods=new PageImpl<Product>(plist, PageRequest.of(page, 8), plist.size());
		System.err.println(prods.getSize());
		return prods;
	}
	
	public List<Product> allProducts(){
		return productrepo.findByDeletedOrderByProdidDesc(false);
	}
	
	public Page<Product> allVendorProducts(String userid,int page){
		return productrepo.findByDeletedAndVendoridOrderByProdidDesc(false,userid,PageRequest.of(page, 8));
	}
	
	public long countProducts() {
		return productrepo.count();
	}
	
	public List<Product> allCategoryProducts(int catid){
		return productrepo.findByCatidOrderByProdidDesc(catid);
	}
	
	public Product findProductById(int prodid) {
		Optional<Product> p=productrepo.findById(prodid);
		if(p.isPresent())
			return p.get();
		else 
			return null;
	}
	
	public void deleteProduct(int prodid) {
		Optional<Product> p=productrepo.findById(prodid);
		if(p.isPresent()) {
			Product product=p.get();
			product.setDeleted(true);
			productrepo.save(product);
		}
	}
	
	public Product saveProduct(Product p,MultipartFile photo) {
		try {
			photo.transferTo(Paths.get(ctx.getRealPath("/pics/"), photo.getOriginalFilename()));
		}catch(Exception ex) {
			System.err.println("Error "+ex.getMessage());
		}
		
		p.setPic("/pics/"+photo.getOriginalFilename());
		System.out.println(p);
		return productrepo.save(p);
	}
	
	public long totalProducts() {
		return productrepo.count();
	}
	
}
