package upei.project;

import upei.project.Players;

/**
 * The {@code Actionable} interface represents an action that can be performed on a player during the game.
 * Classes implementing this interface must define the {@code performAction} method to specify
 * the behavior of the action when applied to a {@code Players} object.
 */
public interface Actionable {

    /**
     * Performs a specific action on the given player.
     * The implementation of this method will define how the action affects the player.
     *
     * @param player the {@code Players} object on which the action is performed.
     */
    void performAction(Players player);
}
