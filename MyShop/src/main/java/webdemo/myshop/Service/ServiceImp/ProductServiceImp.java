package webdemo.myshop.Service.ServiceImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webdemo.myshop.Dto.Request.ProductRequest;
import webdemo.myshop.Dto.Response.ProductResponse;
import webdemo.myshop.Entity.Product;
import webdemo.myshop.Entity.ProductImages;
import webdemo.myshop.HandleException.AppException;
import webdemo.myshop.HandleException.ErrorCode;
import webdemo.myshop.Repository.CategoryRepository;
import webdemo.myshop.Repository.ProductRepository;
import webdemo.myshop.Repository.ProductImagesRepository;
import webdemo.myshop.Service.ProductService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductImagesRepository productImagesRepository;
    @Override
    public String CreateProduct(ProductRequest productRequest) {
        if (productRepository.existsProductByProductName(productRequest.getProductName())){
            return "Product Already Exists";
        };
        if (!categoryRepository.existsCategoryByCategoryName(productRequest.getCategory().getCategoryName())){
            return "Category Not Exists";
        };
        Product product = modelMapper.map(productRequest, Product.class);
        productRepository.save(product);
        productRequest.getImages().forEach(img -> {
            ProductImages productImages = new ProductImages();
            productImages.setImageUrl(img.getImageUrl());
            productImages.setProduct(product);
            productImagesRepository.save(productImages);
        });
        return "Create Product Successfully!";
    }

    @Override
    public ProductResponse getProductById(int productId) {
        if (!productRepository.existsById(productId)){
            throw new AppException(ErrorCode.PRODUCT_NOT_FOUND);
        }
        return modelMapper.map(productRepository.findById(productId).get(), ProductResponse.class);
    }

    @Override
    public Set<ProductResponse> getAllProducts() {
        List<Product> categories = productRepository.findAll();
        Set<ProductResponse> productResponses = new HashSet<>();
        for (Product Product : categories) {
            productResponses.add(modelMapper.map(Product, ProductResponse.class));
        }
        return productResponses;
    }
}
