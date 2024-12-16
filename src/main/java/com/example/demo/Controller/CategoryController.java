package com.example.demo.Controller;

import com.example.demo.beans.Category;
import com.example.demo.serviceImp.CategoryServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	public CategoryController() {
		System.out.println("hello CategoryController.....");
	}
	
	@Autowired
	CategoryServiceImp csi;
	
	@GetMapping("")
	public List<Category> getAllCategories(@Param("page") int page){
		return csi.getAllCategories(page);
	}

	
	@PostMapping("")
	public String addcategory(Category cd) {
	        csi.addCategory(cd);
		return "Category Added SucceesFully....";
			
	}
		
	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable int id) {
	 	return csi.categoryByID(id);
			
	}
	
	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable int id) {
		   csi.deleteCategoryByID(id);
		return "Delete Category SuccessFully...";
		
	}
	
	@PutMapping("/{id}")
	public String updateCategory(@PathVariable int id, Category cd) {
		  csi.updateCategoryById(id, cd);
		return "Update Data Successfully.....";
		
	}

}
