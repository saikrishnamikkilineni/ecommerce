package com.example.demo.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Model.Orders;
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
	
	
	@Override
	public Orders addOrders(OrderDto orders) {
		Orders o=new Orders();
		o.setUsers(urepo.findById(orders.getUser_id()).get());
		o.setProduct(prepo.findById(orders.getProduct_id()).get());
		o.setStatus(orders.getStatus());
		LocalDate ld=LocalDate.now();
		o.setOrder_date(Date.valueOf(ld));
return OrdersRepo.save(o);
		
		
	}


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

}
