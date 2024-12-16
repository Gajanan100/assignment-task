package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Products;

public interface ProductDao extends JpaRepository<Products, Integer> {
	
}
