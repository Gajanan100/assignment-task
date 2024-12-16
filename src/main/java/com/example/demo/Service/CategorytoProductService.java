package com.example.demo.Service;

import java.util.List;

import com.example.demo.beans.Category;
import com.example.demo.beans.Products;

public interface CategorytoProductService {
	
	public Category addCategorytoProduct(int catId,Products p);
	
	public Products getByIdCategoryToProduct(int catId,int pid);
	public List<Products> getAllProductCategoryToProduct(int catId);
	
	public void deleteByIdProductCategoryToProduct(int catId,int pid);
	
	public void updateByIdProductCategoryToProduct(int catId, int pid, Products p);
	

}

