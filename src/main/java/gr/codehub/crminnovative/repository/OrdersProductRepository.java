package gr.codehub.crminnovative.repository;

import gr.codehub.crminnovative.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersProductRepository
        extends JpaRepository<OrderProduct, Long> {


}
