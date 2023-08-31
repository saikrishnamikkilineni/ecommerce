package com.example.demo.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.MyRepo.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	ProductRepository ProductRepo;
	
	
	@Override
	public Product addProduct(Product product) {
		return ProductRepo.save(product); 
	}


	@Override
	@Transactional
	public void deleteBystock(long stock) {
		ProductRepo.deleteBystock(stock);
		
	}


	public Product getProductByname(String product_name) {
		return ProductRepo.getProductByname(product_name);
	}


	public List<Product> getAllProduct() {
		
		return ProductRepo.findAll();
	}


	


	

	

}
