package webdemo.myshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webdemo.myshop.Entity.ProductImages;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Integer> {
}
