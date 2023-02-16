package tr.com.huseyinaydin.bookstore.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tr.com.huseyinaydin.bookstore.api.entities.Category;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;
import tr.com.huseyinaydin.bookstore.api.entities.models.ResponseMessage;
import tr.com.huseyinaydin.bookstore.api.exceptions.notFoundExceptions.CategoryNotFoundException;
import tr.com.huseyinaydin.bookstore.api.exceptions.notFoundExceptions.NotFoundException;
import tr.com.huseyinaydin.bookstore.api.repositories.CategoryRepository;
import tr.com.huseyinaydin.bookstore.api.services.Abstract.CategoryService;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ApiResponse<List<Category>> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(path = "/{id}")
    public ApiResponse<Category> getOneCategory(@PathVariable(name = "id", required = true) int id) {
        return categoryService.getOneCategory(id);
    }

    @PostMapping
    public ResponseEntity<?> postOneCategory(@RequestBody Category category) {
        var response = categoryService.postOneCategory(category);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putOneCategory(@PathVariable(name = "id") int id, @RequestBody Category category) {
        var response = categoryService.putOneCategory(id, category);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOneCategory(@PathVariable(name = "id") int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
