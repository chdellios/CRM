package gr.codehub.crminnovative.repository;


import gr.codehub.crminnovative.model.Customer;
import gr.codehub.crminnovative.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO
//change it with paging

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);
    List<Product> findByPriceLessThan(double price);
    List<Product> findByInventoryQuantityGreaterThan(int quantity);

    @Query("select p from Product p where p.name like %?1")
    List<Product> findByNameEndsWith(String chars);

    @Query("select p.inventoryQuantity from Product p where p.name like %?1")
    List<Integer> findQuantityByName(String chars);




}
