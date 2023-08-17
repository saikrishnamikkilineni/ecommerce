package com.example.demo.Service;

import java.util.List;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Model.Orders;

public interface OrdersInterface {

	
	public Orders addOrders(OrderDto orders);
	public List<Orders> getAllOrder();
	
	public void deleteOrderById(int order_id);	
	
}
