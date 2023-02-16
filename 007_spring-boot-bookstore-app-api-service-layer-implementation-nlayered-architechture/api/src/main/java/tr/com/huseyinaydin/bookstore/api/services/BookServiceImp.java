package tr.com.huseyinaydin.bookstore.api.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import tr.com.huseyinaydin.bookstore.api.entities.Book;
import tr.com.huseyinaydin.bookstore.api.entities.models.ApiResponse;
import tr.com.huseyinaydin.bookstore.api.entities.models.ResponseMessage;
import tr.com.huseyinaydin.bookstore.api.exceptions.notFoundExceptions.BookNotFoundException;
import tr.com.huseyinaydin.bookstore.api.repositories.BookRepository;
import tr.com.huseyinaydin.bookstore.api.services.Abstract.BookService;

//بسم الله الرحمن الرحيم

/**  
* Bootcamp BTK Akademi Innova
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
* 
*/

@Service
public class BookServiceImp implements BookService {

    private final BookRepository bookRepository; // IoC

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ApiResponse<List<Book>> getAllBook() {
        List<Book> list = bookRepository.findAll();
        return ApiResponse.default_OK(list);
    }

    @Override
    public ApiResponse<Book> getOneBook(int id) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return ApiResponse.default_OK(book);
    }

    @Override
    public ApiResponse<Book> postOneBook(Book book) {
        Book bookAdd = bookRepository.save(book);
        return ApiResponse.default_CREATED(bookAdd);
    }

    @Override
    public ApiResponse<Book> putOneBook(int id, Book book) {
        // Book var mı?
        getOneBook(id); // yoksa hata fırlatır!
        book.setId(id);
        return ApiResponse.default_ACCEPTED(bookRepository.save(book));
    }

    @Override
    public void deleteOneBook(int id) {
        // getOneBook(id); // kitap yoksa hata fırlatır.
        // bookRepository.deleteById(id);
        bookRepository.delete(getOneBook(id).getData());
    }
}
