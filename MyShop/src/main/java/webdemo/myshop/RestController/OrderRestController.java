package webdemo.myshop.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webdemo.myshop.Dto.Request.OrderRequest;
import webdemo.myshop.Dto.Response.OrderResponse;
import webdemo.myshop.Service.OrderService;

@RestController
public class OrderRestController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder() {
        return ResponseEntity.ok(orderService.addOrder());
    }
    @GetMapping("/getOrder/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable int id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}
