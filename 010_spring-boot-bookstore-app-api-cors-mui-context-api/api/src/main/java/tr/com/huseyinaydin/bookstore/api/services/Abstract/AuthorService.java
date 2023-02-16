package tr.com.huseyinaydin.bookstore.api.services.Abstract;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import tr.com.huseyinaydin.bookstore.api.entities.Author;
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

public interface AuthorService {
    ApiResponse<List<Author>> getAllAuthors();

    ApiResponse<Author> getOneAuthor(int id);

    ApiResponse<Author> postOneAuthor(Author author);

    ApiResponse<Author> putOneAuthor(int id, Author author);

    void deleteOneAuthor(int id);

    Set<Author> getAuthorsByIds(List<Integer> authorIds);
}