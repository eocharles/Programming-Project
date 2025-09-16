package upei.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the TreasureToken class.
 * Verifies the initialization, functionality, and representation of TreasureToken objects.
 */
class TreasureTokenTest {

    /**
     * Tests the initialization of TreasureToken objects with Ruby and Diamond treasures.
     * Verifies that the treasure count and category match the input values.
     */
    @Test
    void treasureTokenInitialization() {
        // Test initialization with Ruby treasure
        TreasureToken rubyToken = new TreasureToken(5, TreasureType.RUBY);
        assertEquals(5, rubyToken.getTreasureCount(), "Treasure count should match initialization.");
        assertEquals(TreasureType.RUBY, rubyToken.getTreasureCategory(), "Treasure category should match initialization.");

        // Test initialization with Diamond treasure
        TreasureToken diamondToken = new TreasureToken(10, TreasureType.DIAMOND);
        assertEquals(10, diamondToken.getTreasureCount(), "Treasure count should match initialization.");
        assertEquals(TreasureType.DIAMOND, diamondToken.getTreasureCategory(), "Treasure category should match initialization.");
    }

    /**
     * Tests the performAction method for a Ruby treasure token.
     * Verifies that the player's expedition loot and ruby count are updated correctly.
     */
    @Test
    void performActionWithRubyToken() {
        // Create a player and a Ruby treasure token
        Players player = new Players("Ruby Hunter");
        TreasureToken rubyToken = new TreasureToken(3, TreasureType.RUBY);

        // Perform the action of the token
        rubyToken.performAction(player);

        // Verify the player's expedition loot and ruby count
        assertEquals(15, player.getExpeditionLoot(), "Expedition loot should be correct for Ruby (5 weight * 3 count).");
        assertEquals(1, player.getTotalRubies(), "Player's total rubies should be incremented.");
    }

    /**
     * Tests the performAction method for a Diamond treasure token.
     * Verifies that the player's expedition loot and diamond count are updated correctly.
     */
    @Test
    void performActionWithDiamondToken() {
        // Create a player and a Diamond treasure token
        Players player = new Players("Diamond Hunter");
        TreasureToken diamondToken = new TreasureToken(4, TreasureType.DIAMOND);

        // Perform the action of the token
        diamondToken.performAction(player);

        // Verify the player's expedition loot and diamond count
        assertEquals(40, player.getExpeditionLoot(), "Expedition loot should be correct for Diamond (10 weight * 4 count).");
        assertEquals(1, player.getTotalDiamond(), "Player's total diamonds should be incremented.");
    }

    /**
     * Tests the toString method for TreasureToken objects.
     * Verifies that the string representation is accurate for Ruby and Diamond tokens.
     */
    @Test
    void toStringRepresentation() {
        // Test toString method for Ruby treasure token
        TreasureToken rubyToken = new TreasureToken(3, TreasureType.RUBY);
        String expectedRubyString = "TreasureToken{treasureCount=3, treasureCategory=RUBY}";
        assertEquals(expectedRubyString, rubyToken.toString(), "toString() should provide correct representation for Ruby token.");

        // Test toString method for Diamond treasure token
        TreasureToken diamondToken = new TreasureToken(5, TreasureType.DIAMOND);
        String expectedDiamondString = "TreasureToken{treasureCount=5, treasureCategory=DIAMOND}";
        assertEquals(expectedDiamondString, diamondToken.toString(), "toString() should provide correct representation for Diamond token.");
    }
}
