package com.example.demo.Controller;

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

import com.example.demo.beans.Products;
import com.example.demo.serviceImp.ProductServicesImp;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	public ProductController() {
		System.out.println("productController ....");
	}

	@Autowired
	ProductServicesImp psi;

	@PostMapping("")
	public String addProduct(Products pts) {
		psi.addProducts(pts);
		return "Product Added Successfully ...";
	}

	@GetMapping("")
	public List<Products> getAllProduct(@Param("page") int page) {
		return psi.getAllProducts(page);
	}


	@GetMapping("/{id}")
	public Products getByid(@PathVariable int id) {
		Products prods = psi.ProductById(id);
		return prods;

	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {

		psi.deleteProductById(id);
		return "Product Deleted Successfully....";
	}

	@PutMapping("/{id}")
	public String updateProduct(@PathVariable int id, Products prod) {

		psi.updateProductById(id, prod);
		return "product Update SuccessFully ....";

	}

}
