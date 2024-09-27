package webdemo.myshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webdemo.myshop.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public boolean existsCategoryByCategoryName(String name);
}
