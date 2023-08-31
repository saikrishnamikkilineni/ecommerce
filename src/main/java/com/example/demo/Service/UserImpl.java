package com.example.demo.Service;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Model.Users;
import com.example.demo.Model.Cart;
import com.example.demo.MyRepo.CartRepository;
import com.example.demo.MyRepo.ProductRepository;
import com.example.demo.MyRepo.UsersRepository;

@Service
public class UserImpl  implements UserInterface{

	@Autowired
	UsersRepository UsersRepo;
	
	@Autowired
	CartRepository CartRepo;
	
	@Autowired
	ProductRepository ProductRepo;
	
	
	@Override
	public Users createUsers(Users user) {
		
		return UsersRepo.save(user);
	}


	@Override
	public Users login(String user_name, String password) {
		return UsersRepo.getUserPwd(user_name, password);
	}


	@Override
	public List<Users> getAllUsers() {
		return UsersRepo.findAll();
		
	}


	@Override
	public void addToCart(String user_name, List<Integer> product) {
		
		Users users=UsersRepo.findByUser_name(user_name);
		List<Integer> list= ProductRepo.getAllIds();
		for(int i=0;i<product.size();i++)
		{
		Cart cart=new Cart();
		if(list.contains(product.get(i)))
		{
			cart.setProduct_id(product.get(i));
			List<Cart> c=users.getCart();
			c.add(cart);
			users.setCart(c);
			CartRepo.save(cart);
			UsersRepo.save(users);
		}
		}
			
	}
	
	
	


	@Override
	public Users updateUser(int user_id, Users updatedUser) {
		Users existingUser = UsersRepo.findById(user_id).orElse(null);
		
		
		 if (updatedUser.getUser_name() != null) {
	            existingUser.setUser_name(updatedUser.getUser_name());
	        }
	        if (updatedUser.getPassword() != null) {
	            existingUser.setPassword(updatedUser.getPassword());
	        }
	        if (updatedUser.getEmail() != null) {
	            existingUser.setEmail(updatedUser.getEmail());
	        }
	        
	        if (updatedUser.getCart() != null) {
	            existingUser.setCart(updatedUser.getCart());
	        }

		return UsersRepo.save(existingUser);
	}


	@Override
	public Users getUserByUser_name(String user_name) {
		
		return UsersRepo.findByUser_name(user_name);
	}
}
	


	



	


	
	
	

