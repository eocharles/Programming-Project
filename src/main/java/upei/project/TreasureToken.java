package upei.project;

import upei.project.Actionable;
import upei.project.Players;
import upei.project.TreasureType;

/**
 * Represents a treasure token in the game.
 * A treasure token can be of different types (e.g., Ruby or Diamond) and has a specific value.
 * When activated, it rewards players with loot based on the treasure's value and type.
 */
public class TreasureToken implements Actionable {

    private int treasureCount; // The number of treasures in this token
    private TreasureType treasureCategory; // The category of the treasure (e.g., Ruby, Diamond)

    /**
     * Constructs a TreasureToken with a specific count and category.
     *
     * @param treasureCount    The number of treasures in this token.
     * @param treasureCategory The category of the treasure (Ruby or Diamond).
     */
    public TreasureToken(int treasureCount, TreasureType treasureCategory) {
        this.treasureCount = treasureCount;
        this.treasureCategory = treasureCategory;
    }

    /**
     * Gets the number of treasures associated with this token.
     *
     * @return The number of treasures.
     */
    public int getTreasureCount() {
        return this.treasureCount;
    }

    /**
     * Gets the category of the treasure (Ruby or Diamond).
     *
     * @return The category of the treasure.
     */
    public TreasureType getTreasureCategory() {
        return treasureCategory;
    }

    /**
     * Performs the treasure's effect on the player.
     * Adds loot to the player's expedition loot and updates the player's total ruby or diamond count.
     *
     * @param player The player encountering the treasure token.
     */
    @Override
    public void performAction(Players player) {
        if (this.getTreasureCategory() == TreasureType.RUBY) {
            player.setExpeditionLoot(TreasureType.RUBY.getTreasureWeight() * this.getTreasureCount());
            player.setTotalRubies(1); // Increment the ruby count
        } else if (this.getTreasureCategory() == TreasureType.DIAMOND) {
            player.setExpeditionLoot(TreasureType.DIAMOND.getTreasureWeight() * this.getTreasureCount());
            player.setTotalDiamond(1); // Increment the diamond count
        }
        System.out.println(player.getNameOfPlayer() + " found a treasure worth " + this.getTreasureCount() + " gems!");
    }

    /**
     * Returns a string representation of the TreasureToken for debugging and display purposes.
     *
     * @return A string describing the treasure token.
     */
    @Override
    public String toString() {
        return "TreasureToken{" +
                "treasureCount=" + treasureCount +
                ", treasureCategory=" + treasureCategory.getTreasureName() +
                '}';
    }
}