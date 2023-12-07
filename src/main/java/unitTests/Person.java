package unitTests;

public class Person extends Object{
    private  String firstName;
    private  String lastName;

    public Person(){}
    private Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Person create(String firstName, String lastName) {
        return new Person(firstName, lastName);
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
