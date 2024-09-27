package webdemo.myshop.Dto.Response;

import lombok.*;
import webdemo.myshop.Entity.Product;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class OrderResponse {
    private int orderId;
    private LocalDateTime orderDate;
}
