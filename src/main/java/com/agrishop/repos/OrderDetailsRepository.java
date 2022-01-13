package com.agrishop.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.agrishop.models.OrderDetails;

@Repository
@Transactional
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer>{
	
	@Query("SELECT o FROM OrderDetails o WHERE o.orderid=?1")
	List<OrderDetails> findByOrderid(int orderid);
	
	@Query("SELECT o FROM OrderDetails o WHERE o.orderid=?1 and o.vendorid=?2")
	List<OrderDetails> findVendorItems(int orderid,String vendorid);
		
	void deleteByOrderid(int orderid);
	
}
