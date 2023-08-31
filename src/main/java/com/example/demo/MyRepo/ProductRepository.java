package com.example.demo.MyRepo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Modifying
	@Query(value="delete from product where stock=?1",nativeQuery=true)
	
	void deleteBystock(long stock);

	
	@Query(value="select * from product where product_name=?1", nativeQuery=true)
	Product getProductByname(String product_name); 
	
	 @Query(value="select product_id from product",nativeQuery=true)
	    List<Integer>  getAllIds();
	    
}
