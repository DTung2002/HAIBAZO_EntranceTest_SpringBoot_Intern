package webdemo.myshop.Dto.Response;

import lombok.*;
import webdemo.myshop.Entity.Category;
import webdemo.myshop.Entity.ProductImages;

import java.math.BigDecimal;
import java.util.Set;
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ProductResponse {
    private int productId;
    private String productName;
    private String color;
    private String size;
    private BigDecimal price;
    private int stockQuantity;
    private String description;
    private Category category;
    private Set<ProductImages> images;
}
