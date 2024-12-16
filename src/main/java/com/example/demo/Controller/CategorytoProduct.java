package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Products;
import com.example.demo.serviceImp.CategorytoProductServiceImp;

@RestController
@RequestMapping("/api/catToprod")
public class CategorytoProduct {

	public CategorytoProduct() {
		System.out.println("CategorytoProduct...");
	}

	@Autowired
	CategorytoProductServiceImp cpi;

	@PostMapping("/{catid}")
	public void createProductCatToProd(@PathVariable int catid, @RequestBody Products ps) {
		cpi.addCategorytoProduct(catid, ps);

	}

	@GetMapping("/{catid}")
	public List<Products> getAllProductCatToProd(@PathVariable int catid) {
		return cpi.getAllProductCategoryToProduct(catid);
	}

	@GetMapping("/{catid}/{pid}")
	public Products getByIdProductCatToProd(@PathVariable int catid, @PathVariable int pid) {
		return cpi.getByIdCategoryToProduct(catid, pid);
	}

	@DeleteMapping("/{catid}/{pid}")
	public String deleteByIdProductCatToProd(@PathVariable int catid, @PathVariable int pid) {
		cpi.deleteByIdProductCategoryToProduct(catid, pid);
		return "Delete Product Successfully.....";
	}

	@PutMapping("/{catid}/{pid}")
	public String UpdateProductCatToProd(@PathVariable int catid, @PathVariable int pid, @RequestBody Products p) {
		cpi.updateByIdProductCategoryToProduct(catid, pid, p);
		return "Update Product Successfully.....";
	}

}
