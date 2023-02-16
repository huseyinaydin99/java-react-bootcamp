package tr.com.huseyinaydin.bookstore.api.services.Abstract;

import java.util.List;

import tr.com.huseyinaydin.bookstore.api.entities.Book;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;
import tr.com.huseyinaydin.bookstore.api.entities.requests.BookRequestForPost;
import tr.com.huseyinaydin.bookstore.api.entities.requests.BookRequestForPut;

//بسم الله الرحمن الرحيم

/**  
* Bootcamp BTK Akademi Innova
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
* 
*/

public interface BookService {
    ApiResponse<List<Book>> getAllBook();

    ApiResponse<Book> getOneBook(int id);

    // id, title, categoryId
    ApiResponse<Book> postOneBook(BookRequestForPost bookForPost);

    ApiResponse<Book> putOneBook(int id, BookRequestForPut book);

    void deleteOneBook(int id);  
}