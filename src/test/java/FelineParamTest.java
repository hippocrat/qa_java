import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineParamTest {

    @ParameterizedTest
    @CsvSource({"0,0", "1,1", "5,5", "10,10"})
    void testGetKittensWithDifferentNumbers(int input, int expected) {
        Feline feline = new Feline();

        assertEquals(expected, feline.getKittens(input));
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
