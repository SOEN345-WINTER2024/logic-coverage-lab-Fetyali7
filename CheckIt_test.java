import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CheckIt_test {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testPredicateTrue() {
        CheckIt.checkIt(true, false, false);
        assertEquals("P is true", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testPredicateFalse() {
        CheckIt.checkIt(false, false, false);
        assertEquals("P isn't true", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testClauses() {
        CheckIt.checkIt(false, true, true);
        assertEquals("P is true", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset(); // Clear the output stream before the next test

        CheckIt.checkIt(false, false, true);
        assertEquals("P isn't true", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testCACC_RACC() {
        CheckIt.checkIt(true, true, false); // a overrides b and c
        assertEquals("P is true", outputStreamCaptor.toString().trim());

        outputStreamCaptor.reset(); // Clear the output stream before the next test

        CheckIt.checkIt(false, true, false); // Demonstrates b doesn't override a
        assertEquals("P isn't true", outputStreamCaptor.toString().trim());
    }
}
