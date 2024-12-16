package com.example.demo.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Service.ProductServices;
import com.example.demo.beans.Products;
import com.example.demo.dao.ProductDao;

@Service
public class ProductServicesImp implements ProductServices {

	@Autowired
	ProductDao pd;
	
	@Override
	public void addProducts(Products pts) {
		// TODO Auto-generated method stub
		pd.save(pts);
		
	}
	
	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		pd.deleteById(id);
		
	}
	@Override
	public List<Products> getAllProducts(int pageNo) {
		// TODO Auto-generated method stub
		PageRequest pageRequest=PageRequest.of(pageNo, 5);
		Page<Products> pagelist=pd.findAll(pageRequest);
		List<Products> plist=pagelist.getContent();
		
		return plist;
	}


	@Override
	public Products ProductById(int id) {
		// TODO Auto-generated method stub
		Optional<Products>optional=pd.findById(id);
		return optional.get();
	}


	@Override
	public void updateProductById(int id,@RequestBody Products pts) {
		// TODO Auto-generated method stub
		Optional<Products>optional=pd.findById(id);
		
		if(optional.isPresent()) {
			Products pts1=optional.get();
			
			pts1.setProd_id(pts.getProd_id());
			pts1.setProd_name(pts.getProd_name());
			pts1.setProd_sal(pts.getProd_sal());
			
			pd.save(pts1);
			
		}
		
	}

	
}
