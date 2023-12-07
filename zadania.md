Zadanie 1:
- Napisz prosty kalkulator
- napisz metody add, subtract, multiply, divide
- napisz testy gdzie:
    - przed każdym testem inicjalizuj nowy obiekt kalkulatora
    - po każdym teście przypisz do zmiennej wartość null
- napisz testy dla każdej metody
    - gdzie do metody add przekazujemy dowolną ilość elementów
    - metody  multiply, divide otrzymują po 2 elementy
- jeden test ma zwracać wyjątek w związku z dzieleniem przez 0

Zadanie 2:
Napisz metodę 'isValid' która przyjmuje obiekt typu String. 
Metoda m być częścią klasy 'EmailValidator'
zdefiniuj w klasie:
- regex dla sprawdzania email
Napisz testy gdzie jako źródło danych będzie:
- pojedynczy mail
- @ValueSource
- @MethodSource (jeden test z listą prawidłowych maili, drugi z listą nieprawidłowych maili)
- @CsvSource

Zadanie 3
Napisz interfejs 'AnimalRepository' z dwoma metodami:
- Optional<Animal> findByIdAndType(Long id, String type);
- Animal save(Animal animal);
Napisz service 'AnimalService' i wstrzyknij do niego przez konstruktor
- Animal getAnimalByIdAndType(Long id, String type)
- Animal createAnimal(Animal animal)
Napisz testy w 2 wersjach:
- AnimalServiceWithoutMockTest.java
- AnimalServiceWithMockTest.java
