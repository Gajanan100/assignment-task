package com.example.demo.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "producCategories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int cat_id;
	public String cat_name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonManagedReference
	List<Products> listProduct;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(int cat_id, String cat_name, List<Products> listProduct) {
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.listProduct = listProduct;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public List<Products> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Products> listProduct) {
		this.listProduct = listProduct;
	}

	@Override
	public String toString() {
		return "Category [cat_id=" + cat_id + ", cat_name=" + cat_name + ", listProduct=" + listProduct + "]";
	}

}
