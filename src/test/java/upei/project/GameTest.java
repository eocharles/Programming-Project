package upei.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Game} class.
 * Verifies the behavior of game mechanics such as player initialization, treasure acquisition,
 * trap handling, and winner determination.
 */
class GameTest {
    private Game game;
    private Players player1;
    private Players player2;
    private Players player3;

    /**
     * Sets up the test environment with three players and a new game instance before each test case.
     */
    @BeforeEach
    void setUp() {
        player1 = new Players("Alice");
        player2 = new Players("Bob");
        player3 = new Players("Charlie");
        game = new Game(player1, player2, player3);
    }

    /**
     * Verifies that the game initializes correctly with players, a deck, and played tokens.
     */
    @Test
    void testGameInitialization() {
        assertNotNull(game.getPlayers(), "Players should be initialized.");
        assertEquals(3, game.getPlayers().length, "Game should have 3 players.");
        assertNotNull(game.getPlayedTokens(), "Played tokens should be initialized.");
        assertNotNull(game.deck, "Deck should be initialized.");
    }

    /**
     * Simulates the playIncanGold method and verifies that game properties are updated as expected.
     */
    @Test
    void testPlayMethod() {
        game.playIncanGold();
        assertEquals(5, game.getMaxDays(), "The game should have 5 maximum days.");
        assertNotNull(game.getPlayedTokens(), "Played tokens should not be null after playing.");
    }

    /**
     * Verifies that drawing and playing a token increases the size of the played tokens list.
     */
    @Test
    void testAddToPlayedCard() {
        int initialSize = game.getPlayedTokens().size();
        game.drawAndPlayToken();
        assertEquals(initialSize + 1, game.getPlayedTokens().size(),
                "Played tokens should increase by 1 after drawing and playing a token.");
    }

    /**
     * Ensures that the newDay method resets the players' states correctly for a new round.
     */
    @Test
    void testNewRoundResetsPlayers() {
        game.playIncanGold(); // Simulate a round
        game.newDay();
        for (Players player : game.getPlayers()) {
            assertTrue(player.getPresentInTemple(), "Player should re-enter the temple.");
            assertEquals(0, player.getExpeditionLoot(), "Player's expedition loot should reset to 0.");
            assertFalse(player.getHasExited(), "Player's exit status should reset.");
        }
    }

    /**
     * Verifies that treasure tokens are processed correctly and added to the player's expedition loot.
     */
    @Test
    void testTreasureToPocket() {
        TreasureToken treasureToken = new TreasureToken(3, TreasureType.RUBY);
        game.getPlayedTokens().add(treasureToken);

        game.processTreasureAcquisition(player1);

        assertEquals(15, player1.getExpeditionLoot(), "Expedition loot should increase based on treasure value.");
        assertEquals(1, player1.getTotalRubies(), "Player's ruby count should increment.");
    }

    /**
     * Verifies that relic tokens are processed correctly and added as bonus treasures for the player.
     */
    @Test
    void testRelicCardToPocket() {
        RelicToken relicToken = new RelicToken();
        game.getPlayedTokens().add(relicToken);

        game.processRelicAcquisition(player1);

        assertEquals(5, player1.getTotalTreasures(), "Relic should award 5 bonus points to total treasures.");
    }

    /**
     * Ensures that the game detects consecutive traps and forces the player to exit the temple.
     */
    @Test
    void testCheckForTrapRepeats() {
        TrapToken trap1 = TrapToken.SNAKES;
        TrapToken trap2 = TrapToken.SNAKES;
        game.getPlayedTokens().add(trap1);
        game.getPlayedTokens().add(trap2);

        assertTrue(game.checkForTrapRepeats(player1), "Trap repeats should be detected.");
        assertTrue(player1.getHasExited(), "Player should be forced to exit due to consecutive traps.");
        assertEquals(0, player1.getExpeditionLoot(), "Player's expedition loot should reset to 0 after forced exit.");
    }

    /**
     * Verifies that the correct winner is determined based on the highest total treasures.
     */
    @Test
    void testDetermineWinner() {
        player1.setTotalTreasures(50);
        player2.setTotalTreasures(70);
        player3.setTotalTreasures(30);

        Players winner = game.determineWinner();
        assertEquals(player2, winner, "Player with the highest total treasures should be the winner.");
        assertEquals("Bob", winner.getNameOfPlayer(), "Winner's name should be Bob.");
    }

    /**
     * Ensures that the remaining available treasures in the game are updated correctly.
     */
    @Test
    void testRemainingGems() {
        game.setAvailableTreasures(90);
        assertEquals(90, game.getAvailableTreasures(), "Available treasures should match the set value.");
    }

    /**
     * Verifies that setting a treasure type decreases the available gems appropriately.
     */
    @Test
    void testTreasureTypeDecreasesGems() {
        int initialGems = game.getAvailableTreasures();
        game.setTreasureType(TreasureType.RUBY);
        assertEquals(initialGems - TreasureType.RUBY.getTreasureWeight(),
                game.getAvailableTreasures(), "Available gems should decrease based on the treasure type weight.");
    }
}