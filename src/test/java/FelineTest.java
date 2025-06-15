import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FelineTest {

    @Test
    void testGetFamily() {
        Feline feline = new Feline();

        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void testGetKittensDefault() {
        Feline feline = new Feline();

        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "5,5", "10,10"})
    void testGetKittensWithDifferentNumbers(int input, int expected) {
        Feline feline = new Feline();

        assertEquals(expected, feline.getKittens(input));
    }

    @Test
    void testDefaultEatMeat() throws Exception {
        Feline feline = new Feline();

        List<String> food = feline.eatMeat();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void testGetFoodForUnknownThrowsException() {
        Feline feline = new Feline();

        Exception exception = assertThrows(Exception.class, () -> feline.getFood("Неизвестно"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "Хищник,'Животные, Птицы, Рыба'",
            "Травоядное,'Трава, Различные растения'"
    })
    void testGetFoodWithDifferentValues(String diet, String expected) throws Exception {
        Feline feline = new Feline();

        List<String> food = feline.getFood(diet);
        List<String> expectedList = List.of(expected.split(", "));

        assertEquals(expectedList, food);
    }
}
