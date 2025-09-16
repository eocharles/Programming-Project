package upei.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Players} class.
 * Ensures the correct functionality of player-related actions such as entering, leaving,
 * depositing loot, handling strategies, and managing player states.
 */
class PlayersTest {

    /**
     * Tests the initialization of a player to ensure default values are correctly set.
     */
    @Test
    void testPlayerInitialization() {
        Players player = new Players("Ruby");
        assertEquals("Ruby", player.getNameOfPlayer(), "Player name should be initialized correctly.");
        assertEquals(0, player.getTotalTreasures(), "Player's total treasures should start at 0.");
        assertFalse(player.getPresentInTemple(), "Player should not be in the temple initially.");
        assertFalse(player.getHasExited(), "Player should not have exited initially.");
    }

    /**
     * Tests the action of entering the temple, verifying the player's state is updated correctly.
     */
    @Test
    void testEnteringTheTemple() {
        Players player = new Players("Alice");
        player.enteringTheTemple();
        assertTrue(player.getPresentInTemple(), "Player should be in the temple after entering.");
    }

    /**
     * Tests the action of leaving the temple, ensuring expedition loot is transferred to total treasures
     * and that the player's state is updated.
     */
    @Test
    void testLeavingTheTemple() {
        Players player = new Players("Bob");
        player.enteringTheTemple();
        player.setExpeditionLoot(10);
        player.leavingTheTemple();

        assertFalse(player.getPresentInTemple(), "Player should not be in the temple after leaving.");
        assertEquals(10, player.getTotalTreasures(), "Player's total treasures should be updated after leaving the temple.");
        assertEquals(0, player.getExpeditionLoot(), "Player's expedition loot should reset after leaving the temple.");
    }

    /**
     * Tests the action of being forced out of the temple, ensuring expedition loot is lost and
     * the player's state is updated correctly.
     */
    @Test
    void testForceExit() {
        Players player = new Players("Charlie");
        player.enteringTheTemple();
        player.setExpeditionLoot(15);
        player.forceExit();

        assertFalse(player.getPresentInTemple(), "Player should not be in the temple after being forced out.");
        assertEquals(0, player.getExpeditionLoot(), "Player should lose all expedition loot when forced out.");
        assertTrue(player.getHasExited(), "Player's exited status should be true after being forced out.");
    }

    /**
     * Tests the deposit of loot, ensuring total treasures are updated correctly.
     */
    @Test
    void testDepositLoot() {
        Players player = new Players("Dave");
        player.enteringTheTemple();
        player.setExpeditionLoot(20);
        player.leavingTheTemple();
        player.depositLoot();

        assertEquals(20, player.getTotalTreasures(), "Player's total treasures should match the deposited loot.");
    }

    /**
     * Tests setting and retrieving expedition loot.
     */
    @Test
    void testSetAndGetExpeditionLoot() {
        Players player = new Players("Eve");
        player.setExpeditionLoot(25);
        assertEquals(25, player.getExpeditionLoot(), "Expedition loot should match the set value.");
    }

    /**
     * Tests setting and retrieving total treasures.
     */
    @Test
    void testSetAndGetTotalTreasures() {
        Players player = new Players("Frank");
        player.setTotalTreasures(30);
        assertEquals(30, player.getTotalTreasures(), "Total treasures should match the set value.");
    }

    /**
     * Tests setting and retrieving total diamonds collected by the player.
     */
    @Test
    void testSetAndGetTotalDiamond() {
        Players player = new Players("Grace");
        player.setTotalDiamond(5);
        assertEquals(5, player.getTotalDiamond(), "Total diamonds should match the set value.");
    }

    /**
     * Tests setting and retrieving total rubies collected by the player.
     */
    @Test
    void testSetAndGetTotalRubies() {
        Players player = new Players("Hank");
        player.setTotalRubies(8);
        assertEquals(8, player.getTotalRubies(), "Total rubies should match the set value.");
    }

    /**
     * Tests that a player's assigned strategy is executed correctly.
     */
    @Test
    void testStrategy() {
        Strategy testStrategy = player -> {
            if (player.getExpeditionLoot() > 0) {
                player.leavingTheTemple();
            }
        };

        Players player = new Players("Ivy", testStrategy);
        player.enteringTheTemple();
        player.setExpeditionLoot(10);
        player.getTheStrategy().decide(player);

        assertFalse(player.getPresentInTemple(), "Player should leave the temple based on the strategy.");
    }
}