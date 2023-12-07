package tdd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;

class MealRepositoryTest {
    private MealRepository mealRepository = new MealRepository();

    @AfterEach
    void cleanUp(){
        mealRepository.clear();
    }

    @Test
    void shouldCreateRepositoryObject() {
        MealRepository mealRepository = new MealRepository();
        Assertions.assertNotNull(mealRepository);
    }

    @Test
    void shouldBeAbleToAddMealToRepository() {
        // given
        Meal meal = new Meal(10, "Pizza");

        // when
        mealRepository.add(meal);

        // then
        assertThat(mealRepository.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToFindMealByExactName() {
        // given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(20, "Spagetti");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        // when
        List<Meal> result = mealRepository.findByName("pizza", false);
        result.forEach(System.out::println);

        // then
        assertThat(result.size(), is(1));
    }
    @Test
    void shouldBeAbleToFindMealByPrice(){
        // given
        Meal meal = new Meal(10, "Pizza");
        Meal meal2 = new Meal(20, "Spagetti");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        // when
        List<Meal> result = mealRepository.findByPrice(10);
        result.forEach(System.out::println);

        // then
        assertThat(result.size(), is(1));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository(){
        // given
        Meal meal = new Meal(10, "Pizza");
        mealRepository.add(meal);

        // when
        mealRepository.delete(meal);

        // then
        assertThat(mealRepository.getAllMeals(), not(contains(meal)));
    }
}