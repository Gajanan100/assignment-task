package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.Service.CategoryService;
import com.example.demo.beans.Category;
import com.example.demo.dao.CategoryDao;
import com.example.demo.dao.ProductDao;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	CategoryDao cat;
    	 
	@Override
	public void addCategory(Category cd) {
		// TODO Auto-generated method stub
		cat.save(cd);
		
	}

	@Override
	
	public void deleteCategoryByID(int id) {
		// TODO Auto-generated method stub
		cat.deleteById(id);
		
	}
	
	@Override
	public List<Category> getAllCategories(int pageNo) {
		// TODO Auto-generated method stub

		PageRequest pagerequest=PageRequest.of(pageNo, 1);
		
		Page<Category> page=cat.findAll(pagerequest);
		List<Category> categories=page.getContent();
		return categories;
	}


	@Override
	public Category categoryByID(int id) {
		// TODO Auto-generated method stub
		Optional<Category>optional=cat.findById(id);
		return optional.get();
	}

	

	@Override
	public void updateCategoryById(int id, Category cd) {
		// TODO Auto-generated method stub
		
		Optional<Category>optional=cat.findById(id);
		
		if(optional.isPresent()) {
			Category cd1=optional.get();
			
			cd1.setCat_id(cd.getCat_id());
			cd1.setCat_name(cd.getCat_name());
			
			cat.save(cd1);
		}
		
	}


	

	
}
