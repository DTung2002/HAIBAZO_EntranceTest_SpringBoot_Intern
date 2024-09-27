package webdemo.myshop.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webdemo.myshop.Dto.Request.ProductRequest;
import webdemo.myshop.Dto.Response.ProductResponse;
import webdemo.myshop.Service.ProductService;

import java.util.List;
import java.util.Set;

@RestController
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.CreateProduct(productRequest));
    }
    @GetMapping(value = "/getProduct/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable int id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @GetMapping("/getAllProducts")
    public ResponseEntity<Set<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}