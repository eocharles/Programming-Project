package upei.project;

import java.util.ArrayList;

/**
 * Represents the main game logic for Incan Gold.
 * This class manages players, the deck, tokens played, and game progression.
 */
public class Game {
    /**
     * The deck of expedition tokens used in the game.
     */
    protected ExpeditionDeck deck;
    private ArrayList<Actionable> playedTokens; // List of tokens played during the current expedition.
    private Players[] players; // Array of players participating in the game.
    private int currentDay; // Current day of the game.
    private final int maxDays = 5; // Maximum number of days in the game.
    private int availableTreasures = 1000; // Total gems available in the game.

    /**
     * Initializes the game with the provided players.
     *
     * @param players The players participating in the game.
     */
    public Game(Players... players) {
        this.deck = new ExpeditionDeck();
        this.playedTokens = new ArrayList<>();
        deck.shuffleDeck();
        this.players = players;
    }

    /**
     * Retrieves the array of players in the game.
     *
     * @return An array of players.
     */
    public Players[] getPlayers() {
        return players;
    }

    /**
     * Retrieves the list of tokens played during the current expedition.
     *
     * @return An ArrayList of Actionable tokens.
     */
    public ArrayList<Actionable> getPlayedTokens() {
        return playedTokens;
    }

    /**
     * Retrieves the current day of the game.
     *
     * @return The current day as an integer.
     */
    public int getCurrentDay() {
        return currentDay;
    }

    /**
     * Sets the current day of the game.
     *
     * @param currentDay The day to set.
     */
    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    /**
     * Retrieves the maximum number of days in the game.
     *
     * @return The maximum number of days.
     */
    public int getMaxDays() {
        return maxDays;
    }

    /**
     * Retrieves the total available treasures in the game.
     *
     * @return The total number of treasures available.
     */
    public int getAvailableTreasures() {
        return availableTreasures;
    }

    /**
     * Sets the total available treasures in the game.
     *
     * @param availableTreasures The number of treasures to set.
     */
    public void setAvailableTreasures(int availableTreasures) {
        this.availableTreasures = availableTreasures;
    }

    /**
     * Adjusts the available treasures based on the type of treasure collected.
     *
     * @param gem The type of treasure collected (e.g., RUBY or DIAMOND).
     */
    public void setTreasureType(TreasureType gem) {
        if (gem == TreasureType.DIAMOND) {
            this.availableTreasures -= TreasureType.DIAMOND.getTreasureWeight();
        }
        if (gem == TreasureType.RUBY) {
            this.availableTreasures -= TreasureType.RUBY.getTreasureWeight();
        }
    }

    /**
     * Draws a token from the deck and adds it to the list of played tokens.
     * Prints a message if the deck is empty.
     */
    public void drawAndPlayToken() {
        Actionable token = deck.drawToken();
        if (token != null) {
            playedTokens.add(token);
        } else {
            System.out.println("Skipping drawing a token as the deck is empty.");
        }
    }

    /**
     * Plays the main game logic for the specified number of days.
     */
    public void playIncanGold() {
        System.out.println("Starting the game...");

        for (currentDay = 1; currentDay <= maxDays; currentDay++) {
            GameMessages.printDayStart(currentDay, maxDays);

            this.setCurrentDay(currentDay);
            newDay();

            while (canContinueExpedition()) {
                drawAndPlayToken();
                processPlayerActions();
            }
        }
    }

    /**
     * Determines if the expedition can continue based on the state of the deck,
     * available treasures, and player presence in the temple.
     *
     * @return True if the expedition can continue, false otherwise.
     */
    private boolean canContinueExpedition() {
        return !deck.getExpeditionTokens().isEmpty() && availableTreasures > 0 && anyPlayerInTemple();
    }

    /**
     * Processes actions for each player during the expedition.
     */
    private void processPlayerActions() {
        for (Players player : players) {
            if (playerCanContinue(player)) {
                checkForTrapRepeats(player);
                drawAndPlayToken();
                processTreasureAcquisition(player);
                processRelicAcquisition(player);
                handleTrapToken(player);
                executePlayerStrategy(player);
            }
        }
    }

    /**
     * Checks if a player can continue in the temple based on their state.
     *
     * @param player The player to check.
     * @return True if the player can continue, false otherwise.
     */
    private boolean playerCanContinue(Players player) {
        return !player.getHasExited() && player.getPresentInTemple() && this.availableTreasures > 0;
    }

    /**
     * Handles the effects of a trap token for the given player.
     *
     * @param player The player encountering the trap.
     */
    private void handleTrapToken(Players player) {
        if (this.getPlayedTokens().getLast() instanceof TrapToken) {
            GameMessages.printTrapPlayed(this.getPlayedTokens().getLast().toString());
        }
    }

    /**
     * Executes the strategy of a player if it is defined.
     *
     * @param player The player whose strategy will be executed.
     */
    private void executePlayerStrategy(Players player) {
        if (player.getTheStrategy() != null) {
            player.getTheStrategy().decide(player);
        }
    }

    /**
     * Prepares the game for a new day by resetting the deck, clearing played tokens,
     * and resetting player states.
     */
    public void newDay() {
        this.deck = new ExpeditionDeck();
        deck.shuffleDeck();
        this.playedTokens.clear();
        for (Players player : players) {
            if (player.getPresentInTemple()) {
                player.leavingTheTemple();
            }
            player.enteringTheTemple();
            player.setHasExited(false);
            player.setExpeditionLoot(0);
            player.setTotalRubies(0);
            player.setTotalDiamond(0);
        }
    }

    /**
     * Processes treasure acquisition for a player based on the current token.
     *
     * @param player The player acquiring the treasure.
     */
    public void processTreasureAcquisition(Players player) {
        Actionable treasure = playedTokens.getLast();
        if (!playedTokens.isEmpty() && treasure instanceof TreasureToken) {
            if (((TreasureToken) treasure).getTreasureCategory() == TreasureType.DIAMOND) {
                treasure.performAction(player);
                this.setTreasureType(TreasureType.DIAMOND);
                System.out.println(player.getNameOfPlayer() + " got " + ((TreasureToken) treasure).getTreasureCount() + " Diamonds");
            } else if (((TreasureToken) treasure).getTreasureCategory() == TreasureType.RUBY) {
                treasure.performAction(player);
                this.setTreasureType(TreasureType.RUBY);
                System.out.println(player.getNameOfPlayer() + " got " + ((TreasureToken) treasure).getTreasureCount() + " Rubies");
            }
        }
    }

    /**
     * Processes relic acquisition for a player based on the current token.
     *
     * @param player The player acquiring the relic.
     */
    public void processRelicAcquisition(Players player) {
        Actionable relicCard = playedTokens.getLast();
        if (!playedTokens.isEmpty() && relicCard instanceof RelicToken) {
            relicCard.performAction(player);
        }
    }

    /**
     * Checks if any player is still in the temple.
     *
     * @return True if at least one player is in the temple, false otherwise.
     */
    private boolean anyPlayerInTemple() {
        for (Players player : players) {
            if (player.getPresentInTemple()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for two identical traps being played consecutively and applies
     * effects to the player.
     *
     * @param player The player encountering the traps.
     * @return True if two identical traps are found, false otherwise.
     */
    protected boolean checkForTrapRepeats(Players player) {
        if (!playedTokens.isEmpty() && playedTokens.size() > 1) {
            int lastCard = playedTokens.size() - 1;
            if (playedTokens.get(lastCard - 1) == playedTokens.get(lastCard)) {
                playedTokens.get(lastCard).performAction(player);
                return true;
            }
        }
        return false;
    }

    /**
     * Determines the winner of the game based on the total treasures collected.
     * Prints the winner and player scores.
     *
     * @return The winning player.
     */
    public Players determineWinner() {
        if (this.players == null || this.getPlayers().length == 0) {
            return null;
        }
        Players winner = this.getPlayers()[0];
        for (int i = 0; i < this.getPlayers().length; i++) {
            if (this.getPlayers()[i].getTotalTreasures() > winner.getTotalTreasures()) {
                winner = this.getPlayers()[i];
            }
        }
        GameMessages.printWinner(winner.getNameOfPlayer(), winner.getTotalTreasures());
        GameMessages.printPlayerScores(players);

        return winner;
    }
}
