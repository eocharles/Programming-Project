package upei.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Actionable} interface and its implementations.
 * These tests verify that actionable objects correctly interact with the {@link Players} class.
 */
class ActionableTest {

    /**
     * A test implementation of {@link Actionable} that simulates increasing a player's expedition loot.
     */
    class TestActionable implements Actionable {
        private final int lootAmount; // The amount of loot to be added to the player's expedition loot

        /**
         * Constructor for TestActionable.
         *
         * @param lootAmount The amount of loot to be added.
         */
        public TestActionable(int lootAmount) {
            this.lootAmount = lootAmount;
        }

        /**
         * Simulates the action of increasing the player's expedition loot.
         *
         * @param player The player receiving the loot.
         */
        @Override
        public void performAction(Players player) {
            player.setExpeditionLoot(lootAmount);
        }
    }

    /**
     * Tests that performing an action correctly increases the player's expedition loot.
     */
    @Test
    void testPerformActionIncreasesExpeditionLoot() {
        Players player = new Players("Test Player");
        int initialLoot = player.getExpeditionLoot(); // Player's initial loot
        int lootAmount = 10; // The amount of loot to add

        Actionable actionable = new TestActionable(lootAmount);
        actionable.performAction(player); // Perform the action

        // Assert that the expedition loot has increased by the expected amount
        assertEquals(initialLoot + lootAmount, player.getExpeditionLoot(),
                "Player's expedition loot should increase by the specified amount.");
    }

    /**
     * A test implementation of {@link Actionable} that forces the player to exit the temple.
     */
    class ForceExitActionable implements Actionable {
        /**
         * Simulates the action of forcing the player to exit the temple.
         *
         * @param player The player being forced to exit.
         */
        @Override
        public void performAction(Players player) {
            player.forceExit();
        }
    }

    /**
     * Tests that performing an action forces the player to exit the temple.
     */
    @Test
    void testPerformActionForcesPlayerExit() {
        Players player = new Players("Test Player");
        player.enteringTheTemple(); // Simulate the player entering the temple

        Actionable actionable = new ForceExitActionable();
        actionable.performAction(player); // Perform the action

        // Assert that the player has been forced out of the temple
        assertFalse(player.getPresentInTemple(), "Player should be forced out of the temple.");
        assertTrue(player.getHasExited(), "Player's exit status should be set to true.");
    }
}
