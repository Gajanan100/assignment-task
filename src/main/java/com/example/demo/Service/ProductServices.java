package com.example.demo.Service;

import java.util.List;

import com.example.demo.beans.Products;

public interface ProductServices {

	public void addProducts(Products pts);

	public void deleteProductById(int id);

	public List<Products> getAllProducts(int pageNo);

	Products ProductById(int id);

	public void updateProductById(int id, Products pts);

}
