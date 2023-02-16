
package tr.com.huseyinaydin.bookstore.api.services.Abstract;

import java.util.List;

import tr.com.huseyinaydin.bookstore.api.entities.Category;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;

//بسم الله الرحمن الرحيم

/**  
* Bootcamp BTK Akademi Innova
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
* 
*/

public interface CategoryService {
    ApiResponse<List<Category>> getAllCategories();

    ApiResponse<Category> getOneCategory(int id);

    ApiResponse<Category> postOneCategory(Category category);

    ApiResponse<Category> putOneCategory(int id, Category category);

    void deleteCategory(int id);
}