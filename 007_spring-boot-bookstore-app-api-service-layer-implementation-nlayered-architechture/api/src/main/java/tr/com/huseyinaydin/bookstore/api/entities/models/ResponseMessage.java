package tr.com.huseyinaydin.bookstore.api.entities.models;

//بسم الله الرحمن الرحيم

/**  
* Bootcamp BTK Akademi Innova
* 
* @author Huseyin_Aydin
* @since 1994
* @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
* 
*/

import java.sql.Timestamp;
import java.util.Date;

public class ResponseMessage {

    public static Timestamp timestamp = new Timestamp(new Date().getTime());
    public static String success = "Operation is OK.";
    public static String fail = "Operation is fail.";
}
