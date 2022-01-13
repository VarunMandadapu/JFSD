package com.agrishop.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.agrishop.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	List<Order> findByUseridOrderByIdDesc(String userid);

	List<Order> findByStatusOrderByIdDesc(String status);
	
	@Query(value = "SELECT * FROM orders where id in(SELECT order_id from order_details where vendorid=?1)",nativeQuery = true)
	List<Order> findVendorOrders(String vendorid);
	
}
