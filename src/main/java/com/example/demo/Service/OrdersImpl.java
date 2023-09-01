package com.example.demo.Service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Cart;
import com.example.demo.Model.Orders;
import com.example.demo.Model.Users;
import com.example.demo.MyRepo.OrdersRepository;
import com.example.demo.MyRepo.ProductRepository;
import com.example.demo.MyRepo.UsersRepository;


@Service
public class OrdersImpl implements OrdersInterface {

	@Autowired
	OrdersRepository OrdersRepo;
	
	@Autowired
	UsersRepository urepo;
	
	@Autowired
	ProductRepository prepo;
	
	


	@SuppressWarnings("unused")
	@Override
	public List<Orders> getAllOrder() {
		List<Orders> viewAll=OrdersRepo.findAll();
		for(Orders orders:viewAll) 
		{
			
		}
		return viewAll;
		
		
		
	}


	@Override
	public void deleteOrderById(int order_id) {
		OrdersRepo.deleteById(order_id);
		
	}


	@Override
	public Orders submitCart(String user_name) {
		 Users users = urepo.findByUser_name(user_name);
		List<Cart> cart=users.getCart();
		List<Integer> cartPro=new ArrayList<>();
		for(int i=0;i<cart.size();i++)
		{
			cartPro.add(cart.get(i).getProduct_id());
		}
		
		Orders order =new Orders();
		order.setUsers(users);
		order.setProducts(prepo.findAllById(cartPro));
		order.setOrder_date(Calendar.getInstance().getTime());
		OrdersRepo.save(order);
		
		return order;
	}

}
