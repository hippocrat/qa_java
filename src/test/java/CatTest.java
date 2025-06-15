import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline mockFeline;

    @InjectMocks
    Cat cat;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSoundMau() {
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected, actual, "Кот должен говорить Мяу!");
    }

    @Test
    void testGetFood() throws Exception {
        List<String> food = List.of("Мышь", "Рыба");

        when(mockFeline.eatMeat()).thenReturn(food);

        List<String> result = cat.getFood();

        assertEquals(food, result);
        verify(mockFeline, times(1)).eatMeat();
    }
}
