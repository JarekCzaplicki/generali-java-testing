package zadania;

import java.util.regex.Pattern;

//Napisz metodę 'isValid' która przyjmuje obiekt typu String.
//Metoda m być częścią klasy 'EmailValidator'
//zdefiniuj w klasie:
//- regex dla sprawdzania email
public class EmailValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);
    public boolean isValid(String email){
        return pattern.matcher(email).matches();
    }
}
