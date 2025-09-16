package upei.project;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a type of treasure in the game. Each treasure type has a name and a weight,
 * which determines its value and how it impacts the player's loot.
 */
public class TreasureType {
    private String treasureName; // The name of the treasure (e.g., Ruby, Diamond)
    private int treasureWeight; // The value or weight of the treasure
    /**
     * Registry for all defined treasure types.
     */
    protected static final Map<String, TreasureType> treasureRegistry = new HashMap<>(); // Registry for all treasure types

    /**
     * Private constructor for creating a new treasure type.
     * Each treasure type is added to the registry for quick look-up.
     *
     * @param treasureName  The name of the treasure.
     * @param treasureWeight The value or weight of the treasure.
     */
    private TreasureType(String treasureName, int treasureWeight) {
        this.treasureName = treasureName;
        this.treasureWeight = treasureWeight;
        treasureRegistry.put(treasureName.toUpperCase(), this); // Store treasure type in registry
    }

    /**
     * Represents a Ruby treasure with a weight of 5.
     */
    public static final TreasureType RUBY = new TreasureType("RUBY", 5);

    /**
     * Represents a Diamond treasure with a weight of 10.
     */
    public static final TreasureType DIAMOND = new TreasureType("DIAMOND", 10);

    /**
     * Retrieves the name of the treasure.
     *
     * @return The name of the treasure.
     */
    public String getTreasureName() {
        return treasureName;
    }

    /**
     * Retrieves the weight of the treasure.
     *
     * @return The weight or value of the treasure.
     */
    public int getTreasureWeight() {
        return treasureWeight;
    }

    /**
     * Returns a string representation of the treasure type.
     *
     * @return A string describing the treasure type.
     */
    @Override
    public String toString() {
        return treasureName + " (Weight: " + treasureWeight + ")";
    }
}