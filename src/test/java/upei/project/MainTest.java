//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package upei.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the {@link Main} class.
 * Contains unit tests to verify the functionality of the {@link Main} class.
 */
public class MainTest {

    /**
     * Default constructor for the {@code MainTest} class.
     */
    public MainTest() {
        // Default constructor logic, if needed
    }

    /**
     * Tests the default constructor of the {@link Main} class.
     * Ensures that the initial value of {@code exampleVar} is set correctly.
     */
    @Test
    public void testMainConstructor() {
        Main myMain = new Main();
        assertEquals(0.0F, (float) myMain.getExampleVar(), 1.0F,
                "Test Main Constructor: Expected: 1, Received: " + myMain.getExampleVar());
    }

    /**
     * Tests the {@link Main#setExampleVar(int)} method of the {@link Main} class.
     * Ensures that {@code exampleVar} is updated correctly when the setter is invoked.
     */

    @Test
    void testSetExampleVar() {
        Main main = new Main();

        // Verify the initial value
        assertEquals(0, main.getExampleVar(), "Initial value of exampleVar should be 0.");

        // Set a new value
        main.setExampleVar(100);

        // Verify the updated value
        assertEquals(100, main.getExampleVar(), "Value of exampleVar should update to 100.");
    }

}
