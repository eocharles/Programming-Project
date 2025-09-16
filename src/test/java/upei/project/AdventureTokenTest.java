package upei.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link AdventureToken} class and its subclasses.
 * Verifies the behavior of methods such as `getTitle` and `activate`.
 */
class AdventureTokenTest {

    /**
     * A test implementation of the {@link AdventureToken} class for testing purposes.
     * This class provides an implementation of the `activate` method to verify its functionality.
     */
    class TestAdventureToken extends AdventureToken {
        private boolean activated = false; // Tracks whether the token has been activated

        /**
         * Constructor for the test adventure token.
         *
         * @param title The title of the token.
         */
        public TestAdventureToken(String title) {
            super(title);
        }

        /**
         * Simulates activation of the token.
         * Sets the `activated` flag to true.
         */
        @Override
        public void activate() {
            activated = true;
        }

        /**
         * Checks if the token has been activated.
         *
         * @return True if the token is activated, false otherwise.
         */
        public boolean isActivated() {
            return activated;
        }
    }

    /**
     * Tests that the `getTitle` method correctly returns the title of the token.
     */
    @Test
    void testGetTitle() {
        AdventureToken token = new TestAdventureToken("Test Token");
        assertEquals("Test Token", token.getTitle(), "Title should match the input title.");
    }

    /**
     * Tests the `activate` method to ensure it properly updates the token's state.
     */
    @Test
    void testActivateMethod() {
        TestAdventureToken token = new TestAdventureToken("Test Token");
        assertFalse(token.isActivated(), "Token should not be activated initially.");

        token.activate(); // Activate the token
        assertTrue(token.isActivated(), "Token should be activated after calling activate.");
    }

    /**
     * Tests the behavior of the token's title to ensure it remains consistent.
     */
    @Test
    void testTitleChange() {
        AdventureToken token = new TestAdventureToken("Original Title");
        assertEquals("Original Title", token.getTitle(), "Initial title should match the input.");
    }
}
