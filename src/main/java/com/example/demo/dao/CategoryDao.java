package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
