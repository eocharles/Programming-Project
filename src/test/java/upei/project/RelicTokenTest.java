package upei.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link RelicToken}.
 * This class ensures that the functionality of RelicToken is working as intended,
 * including the addition of bonus points and the correctness of the output message.
 */
class RelicTokenTest {

    /**
     * Tests that invoking the performAction method on a {@link RelicToken}
     * correctly adds the specified bonus points to the player's total treasures.
     */
    @Test
    void performActionAddsBonusPoints() {
        // Arrange
        Players player = new Players("Alice");
        RelicToken relicToken = new RelicToken();
        int initialTreasures = player.getTotalTreasures();

        // Act
        relicToken.performAction(player);

        // Assert
        int bonusPoints = 5; // RelicToken grants 5 bonus points
        assertEquals(initialTreasures + bonusPoints, player.getTotalTreasures(),
                "Player's total treasures should increase by the bonus points.");
    }

    /**
     * Tests that the performAction method outputs the correct message
     * describing the relic discovery and awarded bonus points.
     */
    @Test
    void performActionPrintsCorrectMessage() {
        // Arrange
        Players player = new Players("Bob");
        RelicToken relicToken = new RelicToken();

        // Act & Capture Output
        String expectedMessage = player.getNameOfPlayer() +
                " discovered a Relic token.... ! 5 bonus points awarded.";
        String actualMessage = captureOutput(() -> relicToken.performAction(player));

        // Assert
        assertEquals(expectedMessage, actualMessage.trim(),
                "The output message should correctly describe the relic discovery and bonus points.");
    }

    /**
     * Helper method to capture console output for testing purposes.
     *
     * @param runnable The action that produces console output.
     * @return The captured output as a string.
     */
    private String captureOutput(Runnable runnable) {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(out));

        try {
            runnable.run();
        } finally {
            System.setOut(originalOut); // Restore the original System.out
        }

        return out.toString();
    }
}