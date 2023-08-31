package com.example.demo.Service;

import java.util.List;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Model.Orders;
import com.example.demo.Model.Users;

public interface OrdersInterface {

	
	public Orders addOrders(OrderDto orders);
	public List<Orders> getAllOrder();
	
	public void deleteOrderById(int order_id);	
	Orders submitCart(String users);
}
