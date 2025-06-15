import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import com.example.Feline;
import org.junit.jupiter.api.Test;

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

    @Test
    void testGetKittensCustomCount() {
        Feline feline = new Feline();

        assertEquals(5, feline.getKittens(5));
    }

    @Test
    void testDefaultEatMeat() throws Exception {
        Feline feline = new Feline();

        List<String> food = feline.eatMeat();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    void testGetFoodForHerbivoreFromParentClass() throws Exception {
        Feline feline = new Feline();

        List<String> food = feline.getFood("Травоядное");

        assertEquals(List.of("Трава", "Различные растения"), food);
    }

    @Test
    void testGetFoodForUnknownThrowsException() {
        Feline feline = new Feline();

        Exception exception = assertThrows(Exception.class, () -> feline.getFood("Неизвестно"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }

    @Test
    void testGetFamilyFromParentClass() {
        Feline feline = new Feline();

        assertEquals("Кошачьи",
                feline.getFamily());
    }
}

