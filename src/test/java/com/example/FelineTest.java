package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FelineTest {

    @Test
    @DisplayName("Тест feline.eatMeat: Должен вернуться список еды для Хищника")
    public void eatMeatReturnsMeatFoodTest() throws Exception {

        Feline feline = new Feline();

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.eatMeat();

        Assertions.assertEquals(expectedFood, actualFood);
    }

    @Test
    @DisplayName("Тест feline.getFamily: Должно вернуть Кошачьи")
    public void getFamilyReturnsFelinesTest() {
        Feline feline = new Feline();

        String actualFamily = feline.getFamily();

        Assertions.assertEquals("Кошачьи", actualFamily);
    }

    @Test
    @DisplayName("Тест feline.getKittens(По умолчанию): Должно вернуть 1")
    public void getKittensReturnsOneTest() {
        Feline feline = new Feline();

        int actualKittensCount = feline.getKittens();

        Assertions.assertEquals(1, actualKittensCount);
    }

    @Test
    @DisplayName("Тест feline.getKittens(С аргументом 5): Должно вернуть 5")
    public void getKittensReturnsFiveTest() {
        Feline feline = new Feline();

        int expectedCount = 5;

        int actualKittensCount = feline.getKittens(expectedCount);

        Assertions.assertEquals(expectedCount, actualKittensCount);
    }
}
