package assertThrows;

import java.io.File;
import java.io.FileNotFoundException;

public class AssertThrowsExampleClass {
    public int getStringLength(String string) {
        return string.length();
    }

    public int divide(int o1, int o2) {
        return o1 / o2;
    }

    public int getElementAtIndex(int[] array, int index) {
        return array[index];
    }

    public void throwUserDefinedException() throws UserDefinedException {
        throw new UserDefinedException("Wyjątek testowy");
    }

    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException("Nie takie argumenty");
    }

    public void readFromFile() throws FileNotFoundException{
        File file = new File("nonexistingfile.txt");
        if (!file.exists()) throw new FileNotFoundException("Plik nie istnieje");
    }

    public void throwMultipleExceptions(boolean condition){
        if(condition) throw new IllegalArgumentException();
        else throw new NullPointerException();
    }
}
