package upei.project;

/**
 * Represents various trap tokens in the game.
 * Each trap token has a name and a description that defines its effect on players.
 * When activated, the trap forces the player to exit the temple and lose their current loot.
 */
public enum TrapToken implements Actionable {

    /**
     * Represents venomous snakes in the cave.
     * Players must exit the temple when they encounter this trap.
     */
    SNAKES("SNAKES", "Venomous snakes slither in the darkness!"),

    /**
     * Represents poisonous gas filling the air.
     * Players must exit the temple when they encounter this trap.
     */
    POISONOUS_GAS("POISONOUS GAS", "Toxic fumes fill the air, making it hard to breathe!"),

    /**
     * Represents a swarm of giant spiders descending from the ceiling.
     * Players must exit the temple when they encounter this trap.
     */
    SPIDERS("SPIDERS", "A swarm of giant spiders descends from the ceiling!"),

    /**
     * Represents cave-ins where rocks fall from the ceiling and block the path.
     * Players must exit the temple when they encounter this trap.
     */
    CAVE_INS("CAVE-INS", "Rocks fall from the ceiling, blocking your path!"),

    /**
     * Represents battering rams charging through the cave.
     * Players must exit the temple when they encounter this trap.
     */
    BATTERING_RAMS("BATTERING RAMS", "Powerful rams charge through the cave!"),

    /**
     * Represents lava pits flooding the floor of the cave.
     * Players must exit the temple when they encounter this trap.
     */
    LAVA_PITS("LAVA PITS", "Molten lava floods the floor of the cave!"),

    /**
     * Represents floods rushing into the cave and threatening to drown everyone.
     * Players must exit the temple when they encounter this trap.
     */
    FLOODS("FLOODS", "Water rushes into the cave, threatening to drown everyone!"),

    /**
     * Represents massive rolling boulders blocking the escape path.
     * Players must exit the temple when they encounter this trap.
     */
    ROLLING_BOULDERS("ROLLING BOULDERS", "Massive boulders block your escape path!");

    private final String name;        // The name of the trap
    private final String description; // A brief description of the trap's effect

    /**
     * Constructs a TrapToken with a name and description.
     *
     * @param name        The name of the trap.
     * @param description A brief description of the trap's effect.
     */
    TrapToken(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Performs the trap's effect on a player.
     * Forces the player to exit the temple and lose all their expedition loot.
     *
     * @param player The player encountering the trap.
     */
    @Override
    public void performAction(Players player) {
        System.out.println(player.getNameOfPlayer() + " encountered a trap: " + name + "! " + description);
        player.forceExit();
        player.leavingTheTemple();
    }

    /**
     * Gets the name of the trap.
     *
     * @return The name of the trap.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the trap's effect.
     *
     * @return The description of the trap.
     */
    public String getDescription() {
        return description;
    }
}
