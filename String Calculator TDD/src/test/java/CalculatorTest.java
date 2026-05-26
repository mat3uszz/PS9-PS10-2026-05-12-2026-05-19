import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void shouldReturnZeroForEmptyString() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void shouldReturnNumberForSingleNumber() {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void shouldReturnSumForTwoNumbers() {
        assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void shouldReturnSumForMultipleNumbers() {
        assertEquals(15, Calculator.add("1,2,3,4,5"));
    }

    @Test
    public void shouldHandleNewLinesBetweenNumbers() {
        assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void shouldSupportCustomDelimiters() {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void shouldThrowExceptionForNegativeNumbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.add("1,-2,3,-4");
        });
        assertTrue(exception.getMessage().contains("Negatives not allowed: -2, -4"));
    }

    @Test
    public void shouldIgnoreNumbersBiggerThan1000() {
        assertEquals(2, Calculator.add("2,1001"));
    }
}