package com.agrishop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.agrishop.models.Category;
import com.agrishop.repos.CategoryRepository;

@Service
public class CategoryService  {
	
	@Autowired
	private CategoryRepository catrepo;
	private ProductService prodsrv;
	
	public List<Category> getAllCategories(){		
		return catrepo.findAll(Sort.by(Sort.Direction.DESC,"catid"));
	}
	
	public List<Category> getAllVendorCategories(String vendorid){		
		return catrepo.findByVendorid(vendorid);
	}
	
	public void saveCategory(Category cat) {
		System.out.println(catrepo.existsById(cat.getCatid()));
		if(catrepo.existsById(cat.getCatid())) {
			Category cc=catrepo.findById(cat.getCatid()).get();
			cc.setCatname(cat.getCatname());
			catrepo.save(cc);
		}else {
			catrepo.save(cat);
		}
	}
	
	public Category findByCatId(int id) {
		Optional<Category> cat=catrepo.findById(id);
		return cat.get();
	}
	
	public long generateCatId() {
		return catrepo.count()==0 ? 1 : catrepo.count()+1;
	}
	
	public long totalCategories() {
		return catrepo.count();
	}
	
	public Map<String,Integer> getCategoriesDataForChart(){
		Map<String,Integer> map=new HashMap<String, Integer>();
		for(Category cat  : getAllCategories()) {
			int items=prodsrv.allCategoryProducts(cat.getCatid()).size();
			map.put(cat.getCatname(), items);
		}
		System.err.println(map);
		return map;
	}
}
