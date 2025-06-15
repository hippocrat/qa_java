import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.util.*;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
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

    @Test
    void testHasManeForMale() throws Exception {
        Lion lion = new Lion("Самец", mockFeline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testHasManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", mockFeline);
        assertFalse(lion.doesHaveMane());
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

