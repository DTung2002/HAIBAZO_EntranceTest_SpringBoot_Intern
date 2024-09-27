package webdemo.myshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webdemo.myshop.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public boolean existsProductByProductName(String name);
}
