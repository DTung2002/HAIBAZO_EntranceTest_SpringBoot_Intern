package webdemo.myshop.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webdemo.myshop.Dto.Request.CategoryRequest;
import webdemo.myshop.Dto.Response.CategoryResponse;
import webdemo.myshop.Service.CategoryService;

import java.util.Set;

@RestController
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(@RequestBody CategoryRequest category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }
    @GetMapping("/getCategory/{id}")
    public ResponseEntity<?> getCategory(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }
    @GetMapping("/getAll")
    public ResponseEntity<Set<CategoryResponse>> getAllCategory() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
