package webdemo.myshop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "ProductName", nullable = false)
    private String productName;

    @Column(name = "Color", nullable = false)
    private String color;

    @Column(name = "Size", nullable = false)
    private String size;

    @Column(name = "Price", nullable = false)
    private BigDecimal price;

    @Column(name = "StockQuantity", nullable = false)
    private int stockQuantity;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<ProductImages> images;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;
}
