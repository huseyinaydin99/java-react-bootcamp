public class App {
    public static void main(String[] args) throws Exception {
        
       var user = User.builder()
        .firstName("Hüseyin")
        .lastName("Aydın");

        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
       

        // User.builder().firstName("Ahmet").lastName("Gunes");
    }
}
