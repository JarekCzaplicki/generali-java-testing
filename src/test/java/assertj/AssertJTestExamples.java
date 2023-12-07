package assertj;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import unitTests.Person;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTestExamples {
    private static final String FIRST_NAME = "Adam";
    private static final String LAST_NAME = "Małysz";
    private static Person person;

    @BeforeAll
    static void setUp() {
        person = Person.create(FIRST_NAME, LAST_NAME);
    }

    @Test
    void shouldGetFullName() {
        System.out.println(person);
        assertThat(person.getFullName())
                .startsWith(FIRST_NAME)
                .endsWith(LAST_NAME)
                .contains(" ");
    }

    @Disabled
    @Test
    void givenPersonObject_WhenSetFirstAndLastNameWithSpace_ThenTestShouldFail() {

        System.out.println(person);
        assertThat(person.getFullName())
                .startsWith(FIRST_NAME)
                .endsWith(LAST_NAME)
                .doesNotContainAnyWhitespaces();
    }

    @Test
    void givenWhenPersonObjectWithNameAndSurnameIsEqualToExpectedName_ThenTestShouldPas() {
        System.out.println(person);
        assertThat(person.getFullName())
                .isEqualTo(FIRST_NAME + " " + LAST_NAME);
    }


    @Test
    void shouldReverseOrderAndCopyList() {
        final List<String> testedList = List.of("raz", "dwa", "trzy");

        final List<String> reversed = Lists.reverse(testedList);

        assertThat(reversed)
                .isNotEmpty()
                .isNotSameAs(testedList)
                .containsExactly("trzy", "dwa", "raz");
    }

    @Test
    void givenTwoLists_WhenNotEquals_ThenTestShouldPass() {
        final List<String> testedList = List.of("raz", "dwa", "trzy");
        final List<String> reversed = Lists.reverse(testedList);

        assertThat(reversed).isNotEqualTo(testedList);
    }

    @Test
    void givenTwoLists_WhenContainsElement_ThenTestShouldPass() {
        final List<String> testedList = List.of("raz", "dwa", "trzy");
        final List<String> reversed = Lists.reverse(testedList);

        assertThat(reversed).contains("raz", "dwa");
    }

    @Test
    void givenTwoLists_WhenContainsAnyElement_ThenTestShouldPass() {
        final List<String> testedList = List.of("raz", "dwa", "trzy");
        final List<String> reversed = Lists.reverse(testedList);

        assertThat(reversed).containsAnyOf("raz", "dwa");
    }

    @Test
    void givenTwoLists_WhenContainsExactlyInAnyOrder_ThenTestShouldPass() {
        final List<String> testedList = List.of("raz", "dwa", "trzy");
        final List<String> reversed = Lists.reverse(testedList);

        assertThat(reversed).containsExactlyInAnyOrder("trzy", "raz", "dwa");
    }
}
