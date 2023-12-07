package mockito;

public class EmailService {
    public void sendWelcomeEmail(String username, String email) {
        System.out.println("Wysłałem email o treści: " + email + "do użytkownika " + username);
//        System.out.printf("Wysłąłem email o treści: %s do użytkownika: %s", email, username);
    }

    public String returnWelcomeEmail(String username, String email) {
        return "Wysłałem email o treści: " + email + "do użytkownika " + username;
    }
}
