package webdemo.myshop.Service.ServiceImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webdemo.myshop.Dto.Request.CategoryRequest;
import webdemo.myshop.Dto.Response.CategoryResponse;
import webdemo.myshop.Dto.Response.ProductResponse;
import webdemo.myshop.Entity.Category;
import webdemo.myshop.HandleException.AppException;
import webdemo.myshop.HandleException.ErrorCode;
import webdemo.myshop.Repository.CategoryRepository;
import webdemo.myshop.Service.CategoryService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public String createCategory(CategoryRequest categoryRequest) {
        if (categoryRepository.existsCategoryByCategoryName(categoryRequest.getCategoryName())){
            return "category already exist";
        }
        Category category = modelMapper.map(categoryRequest, Category.class);
        categoryRepository.save(category);
        return "Category created!";
    }
    @Override
    public CategoryResponse getCategory(int categoryId) {
        if (!categoryRepository.existsById(categoryId)){
            throw new AppException(ErrorCode.CATEGORY_NOT_FOUND);
        }
        return modelMapper.map(categoryRepository.findById(categoryId).get(), CategoryResponse.class);
    }
    @Override
    public Set<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        Set<CategoryResponse> categoryResponses = new HashSet<>();
        for (Category category : categories) {
            categoryResponses.add(modelMapper.map(category, CategoryResponse.class));
        }
        return categoryResponses;
    }
}