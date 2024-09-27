package webdemo.myshop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "OrderDate", nullable = false)
    private LocalDateTime orderDate;

    @ManyToMany
    @JoinTable(
            name = "Order_Product",
            joinColumns = @JoinColumn(name = "OrderID"),
            inverseJoinColumns = @JoinColumn(name = "ProductID")
    )
    private Set<Product> products;
}
