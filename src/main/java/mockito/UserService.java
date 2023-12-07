package mockito;

public class UserService {
    private final EmailService emailService;

    private final AddressService addressService;

    public UserService(EmailService emailService, AddressService addressService) {
        this.emailService = emailService;
        this.addressService = addressService;
    }
    public void createUser(String username, String email){
        emailService.sendWelcomeEmail(username, email);
    }

    public String createUserAndGetEmail(String username, String email) {
        if (username.equals("Adres")){
            addressService.printAddress(username);
            return null;
        }
        return emailService.returnWelcomeEmail(username, email);
    }
}
