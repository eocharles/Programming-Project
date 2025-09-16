package upei.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the TrapToken enum.
 * Verifies the correctness of trap token behavior, including forcing players out of the temple,
 * generating appropriate messages, and ensuring proper metadata (name and description) is assigned.
 */
class TrapTokenTest {

    /**
     * Tests that the trap token correctly performs its action by forcing the player out of the temple,
     * resetting their loot, and marking them as exited.
     */
    @Test
    void trapTokenPerformsAction() {
        // Create a player
        Players player = new Players("Explorer");

        // Put the player in the temple
        player.enteringTheTemple();
        assertTrue(player.getPresentInTemple(), "Player should initially be in the temple.");

        // Use a trap token
        TrapToken trap = TrapToken.SNAKES;

        // Perform the action of the trap on the player
        trap.performAction(player);

        // Verify the player is forced out of the temple and loot is lost
        assertTrue(player.getHasExited(), "Player should be marked as exited after encountering a trap.");
        assertFalse(player.getPresentInTemple(), "Player should no longer be in the temple after a trap.");
        assertEquals(0, player.getExpeditionLoot(), "Player's expedition loot should be reset to 0 after a trap.");
    }

    /**
     * Tests that the trap token generates the correct output message when performing its action.
     * Verifies both the trap name and description are included in the output.
     */
    @Test
    void trapTokenOutputsCorrectMessage() {
        // Create a player
        Players player = new Players("Adventurer");

        // Use a trap token
        TrapToken trap = TrapToken.LAVA_PITS;

        // Redirect console output for verification
        java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outputStream));

        // Perform the action of the trap
        trap.performAction(player);

        // Verify the output message
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Adventurer encountered a trap: LAVA PITS!"), "Output should mention the trap name.");
        assertTrue(output.contains("Molten lava floods the floor of the cave!"), "Output should mention the trap description.");

        // Restore the standard output
        System.setOut(System.out);
    }

    /**
     * Tests that the trap token correctly provides its name and description through the getter methods.
     */
    @Test
    void testTrapNameAndDescription() {
        // Arrange
        TrapToken trap = TrapToken.SNAKES;

        // Act & Assert
        assertEquals("SNAKES", trap.getName(), "Trap name should be 'SNAKES'.");
        assertEquals("Venomous snakes slither in the darkness!", trap.getDescription(),
                "Trap description should match.");
    }

    /**
     * Verifies that all trap tokens in the enum have non-null and non-empty names and descriptions.
     */
    @Test
    void allTrapTokensHaveDescriptions() {
        // Verify all traps have non-null and non-empty descriptions
        for (TrapToken trap : TrapToken.values()) {
            assertNotNull(trap.name(), "Trap name should not be null.");
            assertFalse(trap.name().isEmpty(), "Trap name should not be empty.");
        }
    }
}
