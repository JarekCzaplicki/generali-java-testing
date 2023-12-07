package mockito;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoExamplesTests {

    @Mock
    private EmailService emailService;
    @Mock
    private AddressService addressService;

    @InjectMocks
    private UserService userService;

    @Test
    void givenUsernameAndEmail_WhenCreatedUser_ThenSendWelcomeEmailIsUsedOnce() {
        // given
        String username = "Jarek";
        String email = "jarek@jarek.pl";

        // when
        userService.createUser(username, email);
        // then
        verify(emailService, times(1)).sendWelcomeEmail(username, email);
    }

    @Test
    void givenUsernameAndEmail_WhenCreatedUser_DoNothingWithSendWelcomeEmail() {
        // given
        String username = "Jarek";
        String email = "jarek@jarek.pl";
        doNothing().when(emailService).sendWelcomeEmail(username, email); // definiowanie pustej akcji, bez wyrzucania wyjątków z testowanej metody

        // when
        userService.createUser(username, email);

        // then
        verify(emailService, times(1)).sendWelcomeEmail(username, email);
    }
    @Test
    void givenUserNameAndEmail_WhenThenThrowException(){
        // given
        String username = "Jarek";
        String email = "jarek@jarek.pl";
        doThrow(new RuntimeException("Email sending failed")).when(emailService).sendWelcomeEmail(username, email);

        // when
        // then
        assertThrows(RuntimeException.class, () -> userService.createUser(username, email));
    }

    @Test
    void givenUserNameAndEmail_WhenMethodReturnWelcomeEmailUsed_ThenReturnCustomValue(){
        // given
        String username = "Jarek";
        String email = "jarek@jarek.pl";
        String expected = "Inna treść";
        when(emailService.returnWelcomeEmail(username, email)).thenReturn(expected);

        // when
        String actual = userService.createUserAndGetEmail(username, email);
        System.out.println(actual);

        // then
        verify(emailService, times(1)).returnWelcomeEmail(username, email);
        assertEquals(expected, actual);
    }
    @Test
    void givenAddress_WhenCreateUserAndGetEmailGetsCustomAddressThenShouldUseAddressServiceNotEmailService(){
        // given
        String adres = "Adres";

        // when
        userService.createUserAndGetEmail(adres, null);

        // then
        verify(addressService, times(1)).printAddress(adres);
        verifyNoInteractions(emailService);
    }

    @Test
    void x(){
        // given
        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> nameCaptor = ArgumentCaptor.forClass(String.class);
        String username = "Jarek";
        String email = "jarek@jarek.pl";

        // when
        userService.createUser(username, email);

        // then
        verify(emailService).sendWelcomeEmail(nameCaptor.capture(), emailCaptor.capture());
        assertEquals(email, emailCaptor.getValue());
    }




}
