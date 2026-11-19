package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    @DisplayName("Тест lion: Должен вернуть ошибку с верной формулировкой")
    public void constructorWithInvalidSexThrowsExceptionTest() {
        String incorrectSex = "Несамец";

        Executable executable = () -> new Lion(incorrectSex, feline);

        Exception exception = Assertions.assertThrows(
                Exception.class,
                executable
        );

        Assertions.assertEquals(
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage()
        );
    }

    @Test
    @DisplayName("Тест lion.getKittens(По умолчанию): Должно вернуть 1")
    public void getKittensReturnsValueFromFelineTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);

        Assertions.assertEquals(1, lion.getKittens());
    }

    @Test
    @DisplayName("Тест lion.getFood: Должен вернуться список еды для Хищника")
    public void getFoodReturnsPredatorFoodListTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", feline);

        Assertions.assertEquals(expectedFood, lion.getFood());
    }
}
