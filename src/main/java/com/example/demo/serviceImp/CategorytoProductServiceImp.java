package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.CategorytoProductService;
import com.example.demo.beans.Category;
import com.example.demo.beans.Products;
import com.example.demo.dao.CategoryDao;
import com.example.demo.dao.ProductDao;

@Service
public class CategorytoProductServiceImp implements CategorytoProductService {

	 @Autowired
	 CategoryDao cd;
	 
	 @Autowired
	 ProductDao pd;
	
	@Override
	public Category addCategorytoProduct(int catId, Products p) {
		// TODO Auto-generated method stub
		Optional<Category>optional=cd.findById(catId);
		
		    if(optional.isPresent()) {
		    	Category cat=optional.get();
		    	p.setCategory(cat);
		    	List<Products>list=cat.getListProduct();
		    	cat.getListProduct().add(p);
		    	
		    	return cd.save(cat);
		    	
		    }
			return null;
	}

	@Override
	public Products getByIdCategoryToProduct(int catId, int pid) {
		// TODO Auto-generated method stub
		
		 Optional<Category> optional=cd.findById(catId);
		 if(optional.isPresent()) {
			 Category cat=optional.get();
			 List<Products>plist=cat.getListProduct();
			 for(Products p:plist) {
				 if(p.getProd_id()==pid) {
					 return p;
				 }
				 
			 }
		 }
		return null;
	}

	@Override
	public List<Products> getAllProductCategoryToProduct(int catId) {
		// TODO Auto-generated method stub
		
		    Optional<Category>optional=cd.findById(catId);
		    if(optional.isPresent()) {
		    	Category cat=optional.get();
		    	List<Products>plist=cat.getListProduct();
		    	return plist;
		    }
		return null;
	}

	@Override
	public void deleteByIdProductCategoryToProduct(int catId, int pid) {
		// TODO Auto-generated method stub
		
		Optional<Category>optional=cd.findById(catId);
		if(optional.isPresent()) {
			Category cat=optional.get();
			List<Products>plist=cat.getListProduct();
			for(Products p:plist) {
				if(p.getProd_id()==pid) {
					plist.remove(p);
					pd.deleteById(pid);
				}
			}
		}
		
	}

	@Override
	public void updateByIdProductCategoryToProduct(int catId, int pid, Products p) {
		// TODO Auto-generated method stub
		
		Optional<Category>optional=cd.findById(catId);
		
		if(optional.isPresent()) {
			
			Category cat=optional.get();
			
			List<Products>plist=cat.getListProduct();
			
			for(Products pt:plist) {
				if(pt.getProd_id()==pid) {
					pt.setProd_name(p.getProd_name());
					pt.setProd_sal(p.getProd_sal());
				}
				
			}
			cd.save(cat);
		}
		
	}

}
