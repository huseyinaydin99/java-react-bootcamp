package tr.com.huseyinaydin.bookstore.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.huseyinaydin.bookstore.api.entities.Author;

//بسم الله الرحمن الرحيم

/**  
* Bootcamp BTK Akademi Innova
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
* 
*/

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    Iterable<Author> findByIdIn(List<Integer> authorIds);   
}