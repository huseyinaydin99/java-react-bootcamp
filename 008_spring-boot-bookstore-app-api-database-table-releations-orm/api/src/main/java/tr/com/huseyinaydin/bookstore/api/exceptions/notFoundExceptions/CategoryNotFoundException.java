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

public class CategoryNotFoundException extends NotFoundException {

    public CategoryNotFoundException(int id) {
        super(String.format("Category with %s id could not fould.", id));
    }

}
