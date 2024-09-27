package webdemo.myshop.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import webdemo.myshop.Entity.Category;
import webdemo.myshop.Entity.ProductImages;

import java.math.BigDecimal;
import java.util.Set;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String productName;
    private String color;
    private String size;
    private BigDecimal price;
    private int stockQuantity;
    private String description;
    private Category category;
    private Set<ProductImages> images;
}
