package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LionParameterizedTest {

    @Mock
    private Feline feline;

    @ParameterizedTest
    @DisplayName("Тест параметризованный lion.doesHaveMane: Должна выполняться логика пола(sex) животного")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void doesHaveManeReturnsExpectedValueTest(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, feline);
        Assertions.assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
