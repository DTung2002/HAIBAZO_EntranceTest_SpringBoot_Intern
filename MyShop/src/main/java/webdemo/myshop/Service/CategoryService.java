package webdemo.myshop.Service;

import webdemo.myshop.Dto.Request.CategoryRequest;
import webdemo.myshop.Dto.Response.CategoryResponse;

import java.util.Set;

public interface CategoryService {
    public String createCategory(CategoryRequest categoryRequest);
    public CategoryResponse getCategory(int categoryId);
    public Set<CategoryResponse> getAllCategories();
}
