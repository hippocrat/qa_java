import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.*;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline mockFeline;

    @Test
    void testGetKittensDelegation() throws Exception {
        when(mockFeline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", mockFeline);

        int kittens = lion.getKittens();

        assertEquals(3, kittens);
        verify(mockFeline).getKittens();
    }

    @ParameterizedTest
    @CsvSource({ "Самец,true", "Самка,false" })
    void testDoesHaveManeWithDifferentSex(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    void testGetFoodDelegation() throws Exception {
        List<String> food = List.of("Антилопа", "Зебра");

        when(mockFeline.getFood("Хищник")).thenReturn(food);
        Lion lion = new Lion("Самец", mockFeline);

        List<String> result = lion.getFood();

        assertEquals(food, result);
        verify(mockFeline).getFood("Хищник");
    }

    @Test
    void testInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Неизвестно", mockFeline));

        assertEquals("Используйте допустимые значения пола животного - самец или самка.", exception.getMessage());
    }
}

