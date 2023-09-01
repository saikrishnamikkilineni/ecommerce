package com.example.demo.Service;

import java.util.List;


import com.example.demo.Model.Orders;


public interface OrdersInterface {

	
	public List<Orders> getAllOrder();
	
	public void deleteOrderById(int order_id);	
	Orders submitCart(String users);
}
