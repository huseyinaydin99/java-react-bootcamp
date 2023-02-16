package tr.com.huseyinaydin.bookstore.api.exceptions.notFoundExceptions;

//بسم الله الرحمن الرحيم

/**
* Bootcamp BTK Akademi Innova
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
* 
*/

public class BookNotFoundException extends NotFoundException {

    public BookNotFoundException(int id) {
        super(String.format("Book with %s id could not found", id));
    }
}