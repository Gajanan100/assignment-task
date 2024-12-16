package com.example.demo.beans;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductType")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int prod_id;
	public String prod_name;
	public double prod_sal;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonBackReference
	public Category category;

	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(int prod_id, String prod_name, double prod_sal, Category category) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_sal = prod_sal;
		this.category = category;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public double getProd_sal() {
		return prod_sal;
	}

	public void setProd_sal(double prod_sal) {
		this.prod_sal = prod_sal;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Products [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_sal=" + prod_sal + ", category="
				+ category + "]";
	}

}
