package com.agrishop.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agrishop.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	List<Category> findByVendorid(String vendorid);
}
