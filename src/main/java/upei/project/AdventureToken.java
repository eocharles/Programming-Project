package upei.project;

/**
 * Represents an abstract base class for adventure tokens.
 * An adventure token can have a title and perform specific actions depending on its type.
 */
public abstract class AdventureToken {

    private String title; // The title or name of the adventure token.

    /**
     * Constructs an AdventureToken with a specified title.
     *
     * @param title The title or name of the adventure token.
     */
    AdventureToken(String title) {
        this.title = title;
    }

    /**
     * Activates the specific action of the adventure token.
     * This method is abstract and should be implemented by subclasses.
     */
    public abstract void activate();

    /**
     * Retrieves the title of the adventure token.
     *
     * @return The title of the adventure token.
     */
    public String getTitle() {
        return title;
    }
}
