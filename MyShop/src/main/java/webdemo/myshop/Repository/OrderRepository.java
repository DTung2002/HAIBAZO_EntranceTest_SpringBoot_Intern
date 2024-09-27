package webdemo.myshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webdemo.myshop.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
