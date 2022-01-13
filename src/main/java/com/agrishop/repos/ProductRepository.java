package com.agrishop.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agrishop.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Page<Product> findByDeletedOrderByProdidDesc(boolean isdeleted,Pageable pageable);

	Page<Product> findByDeletedAndPnameContainingOrderByProdidDesc(boolean isdeleted,String pname,Pageable pageable);
	
	List<Product> findByDeletedOrderByProdidDesc(boolean isdeleted);
	
	Page<Product> findByDeletedAndVendoridOrderByProdidDesc(boolean isdeleted,String Vendorid,Pageable pageable);
	
	List<Product> findByCatidOrderByProdidDesc(int catid);

}
