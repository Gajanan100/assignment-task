package com.example.demo.Service;

import java.util.List;

import com.example.demo.beans.Category;

public interface CategoryService {

	public void addCategory(Category cd);

	public void deleteCategoryByID(int id);

	public List<Category> getAllCategories(int pageNo);

	Category categoryByID(int id);

	public void updateCategoryById(int id, Category cd);

}
