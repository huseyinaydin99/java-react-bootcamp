package tr.com.huseyinaydin.bookstore.api.entities.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

//بسم الله الرحمن الرحيم

/**
* Bootcamp BTK Akademi Innova
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
* 
*/

@Data
public class BookDtoForPost {
    @NotBlank(message = "Title cannot be blank.")
    @NotNull(message = "Title cannot be null.")
    @Size(min = 3, message = "Title must contains at least 3 characters.")
    private String title;

    @NotNull
    private int categoryId;

    @NotNull
    private List<Integer> authorIds;

    @NotNull
    private Double price;

    private String publisher;
}
