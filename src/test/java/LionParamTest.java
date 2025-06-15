import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionParamTest {

    @Mock
    Feline mockFeline;

    @ParameterizedTest
    @CsvSource({ "Самец,true", "Самка,false" })
    void testDoesHaveManeWithDifferentSex(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, mockFeline);
        assertEquals(expected, lion.doesHaveMane());
    }
}
