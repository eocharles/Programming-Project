package upei.project;

/**
 * The main class to simulate the Incan Gold game.
 * It defines various strategies, creates players, and runs a series of trials to compare the performance of different strategies.
 * Simulation results include win rates, average loot collected, and other metrics.
 */
public class SimulationExperiment {
    /**
     * Default constructor for SimulationExperiment.
     * Sets up the simulation experiment environment.
     */
    public SimulationExperiment() {
        // Default constructor logic remains unchanged
    }

    /**
     * The main method to run the simulation experiment.
     * It defines player strategies, runs a series of trials, and collects results for analysis.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {

        // Define player strategies
        Strategy cautiousCollector = (players) -> {
            // Leaves the temple after collecting at least 20 gems
            if (players.getExpeditionLoot() >= 20) {
                players.leavingTheTemple();
                System.out.println(players.getNameOfPlayer() + " collected enough loot and left cautiously!");
            } else if (players.getHasExited()) {
                players.forceExit();
            }
        };

        Strategy recklessRiskTaker = (players) -> {
            // Stays in the temple until they encounter a trap
            if (players.getHasExited()) {
                players.forceExit();
                System.out.println(players.getNameOfPlayer() + " stayed too long and got caught in a trap!");
            }
        };

        Strategy aggressiveDiamondSeeker = (players) -> {
            // Leaves the temple as soon as they collect at least 5 diamonds
            if (players.getTotalDiamond() >= 5) {
                players.leavingTheTemple();
                System.out.println(players.getNameOfPlayer() + " grabbed some diamonds and left the temple!");
            } else if (players.getHasExited()) {
                players.forceExit();
            }
        };

        Strategy rubyPrioritySeeker = (players) -> {
            // Leaves the temple as soon as they collect at least 8 rubies
            if (players.getTotalRubies() >= 8) {
                players.leavingTheTemple();
                System.out.println(players.getNameOfPlayer() + " grabbed some rubies and has left the temple!");
            } else if (players.getHasExited()) {
                players.forceExit();
            }
        };

        Strategy relicHunter = (players) -> {
            // Prioritizes relics and leaves the temple after securing any loot
            if (players.getExpeditionLoot() > 0) {
                players.leavingTheTemple();
                System.out.println(players.getNameOfPlayer() + " secured a relic and escaped the temple!");
            } else if (players.getHasExited()) {
                players.forceExit();
            }
        };

        Strategy calculatedGambler = (players) -> {
            // Stays longer based on the player's current score
            int remainingTreasures = players.getTotalTreasures();
            if (remainingTreasures < 20 && players.getExpeditionLoot() > 30) {
                players.leavingTheTemple(); // Leave after significant gain
            } else if (remainingTreasures >= 100) {
                players.leavingTheTemple(); // Plays cautiously with a lead
            } else if (players.getHasExited()) {
                players.forceExit();
            }
        };

        Strategy milestoneSeeker = (players) -> {
            // Leaves the temple upon hitting a loot milestone (multiples of 10)
            if (players.getExpeditionLoot() > 0 && players.getExpeditionLoot() % 10 == 0) {
                players.leavingTheTemple();
                System.out.println(players.getNameOfPlayer() + " hit a milestone and decided to leave!");
            } else if (players.getHasExited()) {
                players.forceExit();
            }
        };

        Strategy treasureHoarder = (players) -> {
            // Stays in the temple until they collect treasures worth at least 100 gems
            if (players.getExpeditionLoot() >= 100) {
                players.leavingTheTemple();
                System.out.println(players.getNameOfPlayer() + " maximized their loot and left the temple!");
            } else if (players.getHasExited()) {
                players.forceExit();
            }
        };

        // Initialize simulation results container
        SimulationResult results = new SimulationResult();
        int trials = 1000; // Number of simulation trials

        // Run the simulation for the specified number of trials
        for (int i = 0; i < trials; i++) {
            System.out.println("\n=== Running Trial " + (i + 1) + " ===");

            // Create players with different strategies
            Players cautiousClara = new Players("Cautious Clara", cautiousCollector);
            Players recklessElijah = new Players("Reckless Elijah", recklessRiskTaker);
            Players diamondDaphne = new Players("Diamond Daphne", aggressiveDiamondSeeker);
            Players relicRhea = new Players("Relic Rhea", relicHunter);
            Players rubyDavid = new Players("Ruby David", rubyPrioritySeeker);
            Players milestoneRyan = new Players("Milestone Ryan", milestoneSeeker);
            Players gamblerGary = new Players("Calculated Gambler Gary", calculatedGambler);
            Players hoarderHannah = new Players("Treasure Hoarder Hannah", treasureHoarder);

            // Initialize the game with players
            Game gameplay = new Game(cautiousClara, recklessElijah, diamondDaphne, relicRhea, rubyDavid, milestoneRyan, gamblerGary, hoarderHannah);

            // Print welcome message
            GameMessages.printWelcomeMessage();

            // Play the game
            gameplay.playIncanGold();

            // Record the winner
            Players winner = gameplay.determineWinner();
            if (winner != null) {
                results.recordWin(winner.getNameOfPlayer());
            }

            // Record loot collected by each player
            for (Players player : gameplay.getPlayers()) {
                results.addLoot(player.getNameOfPlayer(), player.getExpeditionLoot());
            }

            // Increment the total number of games
            results.incrementGames();
        }

        // Calculate and print simulation results
        results.calculateFinalAverages();
        results.printReport();
    }
}
