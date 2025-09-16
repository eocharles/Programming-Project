package upei.project;

import java.util.HashMap;
import java.util.Map;

/**
 * Tracks and summarizes the results of the simulation experiment, including win counts,
 * average loot collected, and players with no wins.
 */
public class SimulationResult {
    private final Map<String, Integer> winCounts; // Tracks the number of wins for each player
    private final Map<String, Double> totalLoot; // Tracks the total loot collected by each player
    private int totalGames; // Total number of games played

    /**
     * Constructor for SimulationResult.
     * Initializes the data structures to track win counts, loot, and total games.
     */
    public SimulationResult() {
        this.winCounts = new HashMap<>();
        this.totalLoot = new HashMap<>();
        this.totalGames = 0;
    }

    /**
     * Records a win for a specific player.
     *
     * @param playerName The name of the player who won the game.
     */
    public void recordWin(String playerName) {
        winCounts.put(playerName, winCounts.getOrDefault(playerName, 0) + 1);
    }

    /**
     * Adds the loot collected by a player to their total.
     *
     * @param playerName The name of the player.
     * @param loot       The amount of loot collected by the player in a game.
     */
    public void addLoot(String playerName, int loot) {
        totalLoot.put(playerName, totalLoot.getOrDefault(playerName, 0.0) + loot);
    }

    /**
     * Increments the total number of games played by one.
     */
    public void incrementGames() {
        totalGames++;
    }

    /**
     * Calculates the final average loot collected for each player by dividing their
     * total loot by the number of games played.
     */
    public void calculateFinalAverages() {
        for (Map.Entry<String, Double> entry : totalLoot.entrySet()) {
            String playerName = entry.getKey();
            totalLoot.put(playerName, entry.getValue() / totalGames);
        }
    }

    /**
     * Prints a human-readable report of the simulation results.
     * This includes:
     * - Total games played
     * - Win counts and win rates for each player
     * - Average loot collected by each player
     * - Players with no wins
     */
    public void printReport() {
        System.out.println("\n=== Simulation Results ===");
        System.out.println("Total Games Played: " + totalGames);

        // Print win rates and counts
        System.out.println("\nWin Rates and Counts:");
        for (Map.Entry<String, Integer> entry : winCounts.entrySet()) {
            String playerName = entry.getKey();
            int wins = winCounts.getOrDefault(playerName, 0);
            double winRate = ((double) wins / totalGames) * 100;
            System.out.printf("%s: %d wins (%.2f%%)\n", playerName, wins, winRate);
        }

        // Print average loot collected
        System.out.println("\nAverage Loot Collected:");
        for (Map.Entry<String, Double> entry : totalLoot.entrySet()) {
            String playerName = entry.getKey();
            System.out.printf("%s: %.2f gems\n", playerName, entry.getValue());
        }

        // Print players with no wins
        System.out.println("\nPlayers with No Wins:");
        for (String playerName : totalLoot.keySet()) {
            if (!winCounts.containsKey(playerName) || winCounts.get(playerName) == 0) {
                System.out.printf("%s: 0 wins (0.00%%)\n", playerName);
            }
        }
    }
}
