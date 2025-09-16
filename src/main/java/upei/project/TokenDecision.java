package upei.project;

import java.util.Objects;

/**
 * Represents a decision token in the game.
 * This token allows players to make decisions, such as whether to continue or exit an expedition.
 */
public class TokenDecision extends AdventureToken {

    /**
     * Constructs a TokenDecision object with the specified title.
     *
     * @param title The decision type, such as "Continue" or "Exit."
     */
    public TokenDecision(String title) {
        super(title);
    }

    /**
     * Activates the token's effect. The specific behavior depends on the token's title.
     * Currently, no explicit actions are implemented for the "Continue" decision.
     */
    @Override
    public void activate() {
        if (Objects.equals(this.getTitle(), "Continue")) {
            // No explicit behavior for "Continue" currently implemented.
        }
    }

    /**
     * Returns a string representation of the TokenDecision.
     *
     * @return A string describing the token, including its title.
     */
    @Override
    public String toString() {
        return "DecisionToken: " + this.getTitle();
    }

    /**
     * Compares this TokenDecision with another object for equality.
     *
     * @param obj The object to compare.
     * @return True if the objects are of the same class and have the same title, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TokenDecision that = (TokenDecision) obj;
        return Objects.equals(this.getTitle(), that.getTitle());
    }

    /**
     * Generates a hash code for the TokenDecision based on its title.
     *
     * @return The hash code for the token.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
