package upei.project;

import upei.project.Players;

/**
 * Represents a decision-making strategy for a player in the game.
 * This interface is implemented to define the behavior of players
 * based on specific strategies during gameplay.
 */
public interface Strategy {

    /**
     * Executes a decision for a player based on the strategy.
     * The implementation determines how the player behaves during the game,
     * such as when to leave the temple or take specific actions.
     *
     * @param player The player whose decision is determined by the strategy.
     */
    void decide(Players player);
}
