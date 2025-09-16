package upei.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Represents the deck of expedition tokens, including treasure, trap, and relic tokens.
 * The deck is implemented as a stack, allowing tokens to be drawn from the top.
 */
public class ExpeditionDeck {

    private Stack<Actionable> expeditionTokens; // The deck holds all actionable items as a stack.

    /**
     * Constructor for the ExpeditionDeck.
     * Initializes the deck with a predefined set of TreasureTokens, TrapTokens, and RelicTokens.
     */
    public ExpeditionDeck() {
        this.expeditionTokens = new Stack<>();

        // Add Ruby TreasureTokens.
        for (int i = 1; i <= 10; i++) {
            TreasureToken rubyToken = new TreasureToken(i, TreasureType.RUBY);
            this.expeditionTokens.push(rubyToken);
        }

        // Add Diamond TreasureTokens.
        for (int i = 1; i <= 5; i++) {
            TreasureToken diamondToken = new TreasureToken(i, TreasureType.DIAMOND);
            this.expeditionTokens.push(diamondToken);
        }

        // Add TrapTokens (three instances of each trap).
        for (int i = 0; i <= 2; i++) {
            this.expeditionTokens.push(TrapToken.SNAKES);
            this.expeditionTokens.push(TrapToken.CAVE_INS);
            this.expeditionTokens.push(TrapToken.ROLLING_BOULDERS);
            this.expeditionTokens.push(TrapToken.LAVA_PITS);
            this.expeditionTokens.push(TrapToken.POISONOUS_GAS);
            this.expeditionTokens.push(TrapToken.SPIDERS);
            this.expeditionTokens.push(TrapToken.BATTERING_RAMS);
            this.expeditionTokens.push(TrapToken.FLOODS);
        }

        // Add RelicTokens.
        for (int i = 0; i <= 4; i++) {
            RelicToken relicToken = new RelicToken();
            this.expeditionTokens.push(relicToken);
        }
    }

    /**
     * Shuffles the deck by temporarily storing tokens in a list,
     * shuffling them, and then returning them to the stack.
     */
    public void shuffleDeck() {
        List<Actionable> temp = new ArrayList<>();
        while (!expeditionTokens.isEmpty()) {
            temp.add(expeditionTokens.pop());
        }
        Collections.shuffle(temp);
        for (Actionable token : temp) {
            expeditionTokens.push(token);
        }
    }

    /**
     * Retrieves the current stack of expedition tokens.
     *
     * @return A stack containing all actionable tokens in the deck.
     */
    public Stack<Actionable> getExpeditionTokens() {
        return expeditionTokens;
    }

    /**
     * Draws the topmost token from the deck. If the deck is empty, it prints a message and returns null.
     *
     * @return The topmost Actionable token from the deck, or null if the deck is empty.
     */
    public Actionable drawToken() {
        if (!expeditionTokens.isEmpty()) {
            return expeditionTokens.pop();
        } else {
            // Handle the case where there are no more tokens to draw.
            System.out.println("No more tokens in the deck!");
            return null; // Returning null
        }
    }
}
