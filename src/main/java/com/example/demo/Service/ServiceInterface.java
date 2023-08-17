package com.example.demo.Service;



import com.example.demo.Model.Product;

public interface ServiceInterface {

	public Product addProduct(Product product);
    void deleteBystock(long stock);
	public Product getProductByname(String Product_name);
	
}
