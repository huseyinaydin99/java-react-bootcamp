package tr.com.huseyinaydin.bookstore.api.security;

/**
 * 
 * @author Huseyin_Aydin
 * @since 1994
 * @category Java, Spring Boot, React Bootcamp BTK Akademi Innova.
 * 
 */

public enum ApplicationUserPermission {
    BOOK_GET("book:get"),
    BOOK_POST("book:post"),
    BOOK_PUT("book:put"),
    BOOK_DELETE("book:delete");
    
    private final String permission;

    public String getPermission() {
        return permission;
    }

    private ApplicationUserPermission(String permission) {
        this.permission = permission;
    }   
}