package upei.project;

import upei.project.Players;

/**
 * Provides various messages for the game to enhance the user experience.
 * This class handles all printed output related to game events, player actions,
 * and results. This class is not meant to be instantiated.
 */
public class GameMessages {
    private GameMessages() {
        // Prevent instantiation
    }

    /**
     * Prints a welcome message at the start of the game.
     */
    public static void printWelcomeMessage() {
        System.out.println("\nWelcome to the enchanting realm of Incan Gold!");
        System.out.println("Prepare yourself for a thrilling journey brimming with hidden treasures, ancient traps, and mystical relics.");
        System.out.println("Each brave explorer has selected their character and stands ready to delve into the depths of enigmatic caves over the coming five days.");
        System.out.println("Tread carefully; untold perils hide in every shadow, waiting to thwart those who dare to seek the fortunes below.");
        System.out.println("Fortune favors the bold... ");
        System.out.println("Let the quest for glory begin!\n");
    }

    /**
     * Prints a message indicating the start of a new day in the game.
     *
     * @param currentDay The current day of the game.
     * @param maxDays    The total number of days in the game.
     */
    public static void printDayStart(int currentDay, int maxDays) {
        System.out.println("\n  ###  DAY " + currentDay + "  ### ");
        System.out.println("You have " + (maxDays - currentDay) + " days left to claim your riches!\n");
    }

    /**
     * Prints a message when a trap is triggered.
     *
     * @param trapName The name of the trap that was triggered.
     */
    public static void printTrapPlayed(String trapName) {
        System.out.println("A trap has been triggered: " + trapName + "! Be careful as you continue to explore");
    }

    /**
     * Prints a message when a player leaves the cave voluntarily.
     *
     * @param playerName The name of the player leaving the cave.
     */
    public static void printPlayerLeft(String playerName) {
        System.out.println(playerName + " has left the cave with their loot. Safe travels and get ready for the " +
                "next adventure!");
    }

    /**
     * Prints a message when a player is forced out of the cave due to a disaster.
     *
     * @param playerName The name of the player forced out of the cave.
     */
    public static void printPlayerForcedExit(String playerName) {
        System.out.println("Disaster! " + playerName + " was forced out of the cave and lost all their loot!");
    }

    /**
     * Prints the winner of the game along with their score.
     *
     * @param winnerName The name of the winning player.
     * @param score      The total score of the winning player.
     */
    public static void printWinner(String winnerName, int score) {
        System.out.println("\n The Winner of the Game is " + winnerName + " with " + score + " points! " +
                "Congratulations!");
    }

    /**
     * Prints the final scores of all players at the end of the game.
     *
     * @param players An array of all players in the game.
     */
    public static void printPlayerScores(Players[] players) {
        System.out.println("\n Final Scores:");
        for (Players player : players) {
            System.out.println(" - " + player.getNameOfPlayer() + ": " + player.getTotalTreasures() + " points");
        }
    }
}