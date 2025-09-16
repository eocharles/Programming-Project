package upei.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link ExpeditionDeck} class.
 * Verifies the behavior of the deck, including token counts, shuffling, and drawing mechanics.
 */
class ExpeditionDeckTest {

    private ExpeditionDeck expeditionDeck; // Instance of the ExpeditionDeck for testing

    /**
     * Sets up a new {@link ExpeditionDeck} instance before each test case.
     */
    @BeforeEach
    void setUp() {
        expeditionDeck = new ExpeditionDeck();
    }

    /**
     * Verifies that the initial deck size matches the expected total number of tokens (44).
     */
    @Test
    void testInitialDeckSize() {
        assertEquals(44, expeditionDeck.getExpeditionTokens().size(),
                "Deck should have 44 tokens initially.");
    }

    /**
     * Ensures the correct number of treasure tokens are present in the deck (15).
     */
    @Test
    void testTreasureTokenCount() {
        long treasureCount = expeditionDeck.getExpeditionTokens().stream()
                .filter(token -> token instanceof TreasureToken)
                .count();
        assertEquals(15, treasureCount, "Deck should have 15 treasure tokens.");
    }

    /**
     * Ensures the correct number of trap tokens are present in the deck (24).
     */
    @Test
    void testTrapTokenCount() {
        long trapCount = expeditionDeck.getExpeditionTokens().stream()
                .filter(token -> token instanceof TrapToken)
                .count();
        assertEquals(24, trapCount, "Deck should have 24 trap tokens.");
    }

    /**
     * Ensures the correct number of relic tokens are present in the deck (5).
     */
    @Test
    void testRelicTokenCount() {
        long relicCount = expeditionDeck.getExpeditionTokens().stream()
                .filter(token -> token instanceof RelicToken)
                .count();
        assertEquals(5, relicCount, "Deck should have 5 relic tokens.");
    }

    /**
     * Verifies that shuffling the deck changes the order of tokens
     * but does not alter the size of the deck.
     */
    @Test
    void testShuffleChangesOrder() {
        Stack<Actionable> originalDeck = new Stack<>();
        originalDeck.addAll(expeditionDeck.getExpeditionTokens());

        expeditionDeck.shuffleDeck();

        // Check if the size remains the same
        assertEquals(originalDeck.size(), expeditionDeck.getExpeditionTokens().size(),
                "Deck size should not change after shuffling.");

        // Verify if the order has changed
        boolean isOrderChanged = false;
        for (int i = 0; i < originalDeck.size(); i++) {
            if (originalDeck.get(i) != expeditionDeck.getExpeditionTokens().get(i)) {
                isOrderChanged = true;
                break;
            }
        }
        assertTrue(isOrderChanged, "Shuffling should change the order of the tokens.");
    }

    /**
     * Tests that drawing a token removes it from the deck and decreases the deck size.
     */
    @Test
    void testShowCardRemovesToken() {
        int initialSize = expeditionDeck.getExpeditionTokens().size();
        Actionable drawnToken = expeditionDeck.drawToken();

        assertNotNull(drawnToken, "The drawn token should not be null.");
        assertEquals(initialSize - 1, expeditionDeck.getExpeditionTokens().size(),
                "Deck size should decrease by 1 after showing a card.");
    }

    /**
     * Verifies that drawing from an empty deck returns null.
     */
    @Test
    void testDrawTokenFromEmptyDeck() {
        // Deplete the deck
        while (!expeditionDeck.getExpeditionTokens().isEmpty()) {
            expeditionDeck.drawToken();
        }

        // Attempt to draw from an empty deck
        Actionable token = expeditionDeck.drawToken();
        assertNull(token, "Drawing from an empty deck should return null.");
    }
}
