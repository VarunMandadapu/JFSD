package com.agrishop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.agrishop.models.Vendor;
import com.agrishop.service.VendorService;

@SpringBootApplication
@EnableJpaAuditing
public class AgriShopApplication {
	
	private static final Logger log = LoggerFactory.getLogger(AgriShopApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AgriShopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(VendorService srv) {
	    return (args) -> {
	    	if(srv.countVendor()==0) {
	    		Vendor user=new Vendor();
	    		user.setVendorid("admin");
	    		user.setPwd("admin123");
	    		user.setRole("Admin");
	    		user.setAddress("Noida");
	    		user.setActive(true);
	    		user.setPhone("9811763737");
	    		user.setName("Administrator");
	    		srv.saveVendor(user);
	    		log.info("Admin user created successfully");
	    	}else {
	    		log.info("Admin user already created");
	    	}
	    };
	}

}
