package webdemo.myshop.Service;

import webdemo.myshop.Dto.Request.ProductRequest;
import webdemo.myshop.Dto.Response.ProductResponse;

import java.util.Set;

public interface ProductService {
    public String CreateProduct(ProductRequest productRequest);
    public ProductResponse getProductById(int productId);
    public Set<ProductResponse> getAllProducts();
}
