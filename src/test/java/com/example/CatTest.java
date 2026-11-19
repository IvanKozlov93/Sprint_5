package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    @DisplayName("Тест cat.getSound: Должно вернуться Мяу")
    public void getSoundReturnsMeowTest() {

        Cat cat = new Cat(feline);

        String actualSound = cat.getSound();

        Assertions.assertEquals("Мяу", actualSound);
    }

    @Test
    @DisplayName("Тест cat.getFood: Должен вернуться список еды для Хищника")
    public void getFoodReturnsMeatFoodTest() throws Exception {
        // Список того, что ожидаем получить после вызова метода
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(feline);

        List<String> actualFood = cat.getFood();

        Assertions.assertEquals(expectedFood, actualFood);
    }
}
