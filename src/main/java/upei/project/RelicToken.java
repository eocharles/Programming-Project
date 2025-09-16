package upei.project;

/**
 * Represents a relic token in the game.
 * A relic token awards bonus points to the player who discovers it.
 */
public class RelicToken implements Actionable {
    /**
     * Default constructor for RelicToken.
     * Initializes the relic token for gameplay.
     */
    public RelicToken() {
        // Default constructor logic remains unchanged
    }
    /**
     * Grants the player bonus points when they discover a relic token.
     * The player's total treasures are updated with the bonus points.
     *
     * @param player The player discovering the relic token.
     */
    @Override
    public void performAction(Players player) {
        int bonusPoints = 5; // Bonus points awarded for discovering a relic
        player.setTotalTreasures(bonusPoints);// Only add the bonus points to total treasures
        System.out.println(player.getNameOfPlayer() + " discovered a Relic token.... ! " + bonusPoints + " bonus points awarded.");
    }
}