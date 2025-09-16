package upei.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the TokenDecision class.
 * This class verifies the correctness of the TokenDecision's functionality, including title management,
 * activation, equality checks, and string representation.
 */
class TokenDecisionTest {

    /**
     * Tests that a TokenDecision object is created with the correct title.
     */
    @Test
    void decisionTokenHasCorrectTitle() {
        // Test with "Continue" decision
        TokenDecision continueToken = new TokenDecision("Continue");
        assertEquals("Continue", continueToken.getTitle(), "The title should be 'Continue'.");

        // Test with "Exit" decision
        TokenDecision exitToken = new TokenDecision("Exit");
        assertEquals("Exit", exitToken.getTitle(), "The title should be 'Exit'.");
    }

    /**
     * Tests the activate method of TokenDecision.
     * Ensures that activation does not throw an exception regardless of the token title.
     */
    @Test
    void decisionTokenActivateDoesNotThrowException() {
        // Test activation with a valid title
        TokenDecision continueToken = new TokenDecision("Continue");
        assertDoesNotThrow(continueToken::activate, "Activating a 'Continue' token should not throw an exception.");

        // Test activation with another valid title
        TokenDecision exitToken = new TokenDecision("Exit");
        assertDoesNotThrow(exitToken::activate, "Activating an 'Exit' token should not throw an exception.");

        // Test activation with an invalid title
        TokenDecision invalidToken = new TokenDecision("Invalid");
        assertDoesNotThrow(invalidToken::activate, "Activating an invalid token should not throw an exception.");
    }

    /**
     * Tests the equality of TokenDecision objects.
     * Ensures that tokens with the same title are equal and those with different titles are not.
     */
    @Test
    void decisionTokenEqualityCheck() {
        TokenDecision token1 = new TokenDecision("Continue");
        TokenDecision token2 = new TokenDecision("Continue");
        TokenDecision token3 = new TokenDecision("Exit");

        assertEquals(token1, token2, "Tokens with the same title should be equal.");
        assertNotEquals(token1, token3, "Tokens with different titles should not be equal.");
    }

    /**
     * Tests the toString method of TokenDecision.
     * Ensures that the string representation matches the expected format.
     */
    @Test
    void decisionTokenToStringProvidesCorrectOutput() {
        TokenDecision continueToken = new TokenDecision("Continue");
        assertEquals("DecisionToken: Continue", continueToken.toString(),
                "toString() should return the correct representation for 'Continue'.");

        TokenDecision exitToken = new TokenDecision("Exit");
        assertEquals("DecisionToken: Exit", exitToken.toString(),
                "toString() should return the correct representation for 'Exit'.");
    }
}