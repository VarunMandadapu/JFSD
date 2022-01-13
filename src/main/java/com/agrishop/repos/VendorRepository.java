package com.agrishop.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agrishop.models.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, String> {
	
	Vendor findByEmail(String email);

}
