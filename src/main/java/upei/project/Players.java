package upei.project;

/**
 * Represents a player in the game. Each player has a name, a strategy, and various attributes
 * such as treasures collected, diamonds, rubies, and their current state in the game.
 * Players can enter or leave the temple, secure their loot, and react to game events.
 */
public class Players {
    private Strategy strategy; // The strategy associated with the player
    private String nameOfPlayer; // The name of the player
    private boolean presentInTemple = false; // Indicates if the player is currently in the temple
    private boolean hasExited = false; // Indicates if the player has exited (either voluntarily or forcibly)
    private int totalTreasures; // Total treasures securely collected by the player
    private int totalDiamond; // Total diamonds collected by the player
    private int totalRubies; // Total rubies collected by the player
    private int expeditionLoot; // Temporary holding of treasures collected during expeditions

    /**
     * Constructor to initialize a player with a name only.
     *
     * @param name The name of the player.
     */
    public Players(String name) {
        this.nameOfPlayer = name;
    }

    /**
     * Constructor to initialize a player with a name and a strategy.
     *
     * @param name     The name of the player.
     * @param strategy The strategy to be used by the player.
     */
    public Players(String name, Strategy strategy) {
        this.nameOfPlayer = name;
        this.strategy = strategy;
    }

    /**
     * Secures the loot collected during expeditions by adding it to the player's total treasures.
     * Ensures the player is out of the temple before securing the loot.
     */
    public void depositLoot() {
        try {
            if (presentInTemple || hasExited) {
                throw new Exception("Uh oh! " + nameOfPlayer + ", you can't secure your loot right now! " +
                        "Make sure you're safely out of the temple and haven't been forced out by a nasty trap!");
            }
            totalTreasures += expeditionLoot;
            System.out.println(nameOfPlayer + " has successfully secured their loot, adding " + expeditionLoot +
                    " treasures to their chest!");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    /**
     * Marks the player as entering the temple.
     * Outputs a message indicating the player has entered the temple.
     */
    public void enteringTheTemple() {
        this.presentInTemple = true;
        System.out.println(this.nameOfPlayer + " strides boldly into the cave");
    }

    /**
     * Marks the player as leaving the temple. The player's collected loot is added to their total treasures.
     * Outputs a message indicating the player has left the temple.
     */
    public void leavingTheTemple() {
        this.presentInTemple = false;
        if (!this.hasExited) {
            this.setTotalTreasures(this.getExpeditionLoot());
            this.setExpeditionLoot(0);
            GameMessages.printPlayerLeft(this.nameOfPlayer);
        }
    }

    /**
     * Forces the player to exit the temple due to a trap.
     * Resets the player's expedition loot to zero.
     * Outputs a message indicating the player has been forced out.
     */
    public void forceExit() {
        this.hasExited = true;
        this.presentInTemple = false;
        this.setExpeditionLoot(0); // Losing all loot upon forced exit
        GameMessages.printPlayerForcedExit(nameOfPlayer);
    }

    // Getters and Setters

    /**
     * Gets the name of the player.
     * @return The name of the player.
     */
    public String getNameOfPlayer() {
        return nameOfPlayer;
    }


    /**
     * Checks if the player is currently present in the temple.
     *
     * @return True if the player is present in the temple, false otherwise.
     */
    public Boolean getPresentInTemple() {
        return presentInTemple;
    }

    /**
     * Retrieves the total treasures securely collected by the player.
     *
     * @return The total treasures collected by the player.
     */
    public int getTotalTreasures() {
        return totalTreasures;
    }

    /**
     * Checks if the player has left the cave (either voluntarily or forcibly).
     *
     * @return True if the player has left the cave, false otherwise.
     */
    public boolean getHasExited() {
        return hasExited;
    }

    /**
     * Retrieves the strategy associated with the player.
     *
     * @return The strategy used by the player.
     */
    public Strategy getTheStrategy() {
        return strategy;
    }


    /**
     * Updates the player's total treasures by adding the specified amount.
     *
     * @param totalTreasures The amount of treasures to add.
     */
    public void setTotalTreasures(int totalTreasures) {
        this.totalTreasures += totalTreasures;
    }

    /**
     * Updates the player's expedition loot by adding the specified amount.
     * If the specified amount is zero, the loot is reset.
     *
     * @param expeditionLoot The amount of loot to add.
     */
    public void setExpeditionLoot(int expeditionLoot) {
        if (expeditionLoot == 0) {
            this.expeditionLoot = 0;
        }
        this.expeditionLoot += expeditionLoot;
    }

    /**
     * Sets whether the player has exited due to a trap or other reasons.
     *
     * @param trapped True if the player is forced out, false otherwise.
     */
    public void setHasExited(boolean trapped) {
        this.hasExited = trapped;
    }

    /**
     * Retrieves the total number of diamonds collected by the player.
     *
     * @return The total number of diamonds collected.
     */
    public int getTotalDiamond() {
        return totalDiamond;
    }

    /**
     * Updates the player's total diamonds by adding the specified amount.
     * If the specified amount is zero, the diamonds are reset.
     *
     * @param totalDiamond The number of diamonds to add.
     */
    public void setTotalDiamond(int totalDiamond) {
        if (totalDiamond == 0) {
            this.totalDiamond = 0;
        }
        this.totalDiamond += totalDiamond;
    }

    /**
     * Retrieves the total number of rubies collected by the player.
     *
     * @return The total number of rubies collected.
     */
    public int getTotalRubies() {
        return totalRubies;
    }

    /**
     * Updates the player's total rubies by adding the specified amount.
     * If the specified amount is zero, the rubies are reset.
     *
     * @param totalRubies The number of rubies to add.
     */
    public void setTotalRubies(int totalRubies) {
        if (totalRubies == 0) {
            this.totalRubies = 0;
        }
        this.totalRubies += totalRubies;
    }

    /**
     * Retrieves the total loot collected during the current expedition.
     *
     * @return The total expedition loot collected by the player.
     */
    public int getExpeditionLoot() {
        return expeditionLoot;
    }
}