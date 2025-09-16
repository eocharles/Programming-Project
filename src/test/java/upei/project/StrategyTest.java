package upei.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for testing different player strategies in the game.
 * This class ensures that strategies behave as expected under various conditions.
 */
public class StrategyTest {
    /**
     * Default constructor for StrategyTest.
     * Sets up the test cases for player strategies.
     */
    public StrategyTest() {
        // Default constructor logic remains unchanged
    }

    /**
     * Tests the CautiousCollector strategy.
     * Verifies that the player does not leave the temple before collecting at least 20 gems.
     */
    @Test
    void testCautiousCollector() {
        Players cautiousPlayer = new Players("Cautious Player", (players) -> {
            if (players.getExpeditionLoot() >= 20) {
                players.leavingTheTemple();
            }
        });

        cautiousPlayer.setExpeditionLoot(15); // Below threshold
        cautiousPlayer.getTheStrategy().decide(cautiousPlayer);
        assertFalse(cautiousPlayer.getHasExited(),
                "CautiousCollector should not leave the temple before reaching 20 gems!");
    }

    /**
     * Tests the RecklessRiskTaker strategy.
     * Verifies that the player only leaves the temple when forced out by a trap.
     */
    @Test
    void testRecklessRiskTaker() {
        Players recklessPlayer = new Players("Reckless Player", (players) -> {
            if (players.getHasExited()) {
                players.forceExit();
            }
        });

        recklessPlayer.setHasExited(false); // Simulating no trap encountered
        recklessPlayer.getTheStrategy().decide(recklessPlayer);
        assertFalse(recklessPlayer.getHasExited(),
                "RecklessRiskTaker should not leave unless forced out by a trap!");
    }

    /**
     * Tests the AggressiveDiamondSeeker strategy.
     * Verifies that the player does not leave the temple unless they have collected at least 5 diamonds.
     */
    @Test
    void testAggressiveDiamondSeeker() {
        Players diamondSeeker = new Players("Diamond Seeker", (players) -> {
            if (players.getTotalDiamond() >= 5) {
                players.leavingTheTemple();
            }
        });

        diamondSeeker.setTotalDiamond(3); // Less than the threshold
        diamondSeeker.getTheStrategy().decide(diamondSeeker);
        assertFalse(diamondSeeker.getHasExited(),
                "AggressiveDiamondSeeker should not leave without collecting at least 5 diamonds!");
    }

    /**
     * Tests the RubyPrioritySeeker strategy.
     * Verifies that the player does not leave the temple unless they have collected at least 8 rubies.
     */
    @Test
    void testRubyPrioritySeeker() {
        Players rubySeeker = new Players("Ruby Seeker", (players) -> {
            if (players.getTotalRubies() >= 8) {
                players.leavingTheTemple();
            }
        });

        rubySeeker.setTotalRubies(5); // Less than the threshold
        rubySeeker.getTheStrategy().decide(rubySeeker);
        assertFalse(rubySeeker.getHasExited(),
                "RubyPrioritySeeker should not leave without collecting at least 8 rubies!");
    }

    /**
     * Tests the RelicHunter strategy.
     * Verifies that the player does not leave the temple unless they have secured a relic.
     */
    @Test
    void testRelicHunter() {
        Players relicHunter = new Players("Relic Hunter", (players) -> {
            if (players.getExpeditionLoot() > 0) {
                players.leavingTheTemple();
            }
        });

        relicHunter.setExpeditionLoot(0); // No relic collected
        relicHunter.getTheStrategy().decide(relicHunter);
        assertFalse(relicHunter.getHasExited(),
                "RelicHunter should not leave without securing a relic!");
    }

    /**
     * Tests the CalculatedGambler strategy.
     * Verifies that the player only leaves the temple under specific conditions.
     */
    @Test
    void testCalculatedGambler() {
        Players gambler = new Players("Calculated Gambler", (players) -> {
            int remainingTreasures = players.getTotalTreasures();
            if (remainingTreasures < 20 && players.getExpeditionLoot() > 30) {
                players.leavingTheTemple();
            }
        });

        gambler.setTotalTreasures(25); // Above threshold
        gambler.setExpeditionLoot(40); // Above threshold but treasures invalid
        gambler.getTheStrategy().decide(gambler);
        assertFalse(gambler.getHasExited(),
                "CalculatedGambler should not leave unless their conditions are met!");
    }

    /**
     * Tests the MilestoneSeeker strategy.
     * Verifies that the player only leaves the temple when expedition loot is a multiple of 10.
     */
    @Test
    void testMilestoneSeeker() {
        Players milestoneSeeker = new Players("Milestone Seeker", (players) -> {
            if (players.getExpeditionLoot() > 0 && players.getExpeditionLoot() % 10 == 0) {
                players.leavingTheTemple();
            }
        });

        milestoneSeeker.setExpeditionLoot(13); // Not a multiple of 10
        milestoneSeeker.getTheStrategy().decide(milestoneSeeker);
        assertFalse(milestoneSeeker.getHasExited(),
                "MilestoneSeeker should only leave when expedition loot is a multiple of 10!");
    }

    /**
     * Tests the TreasureHoarder strategy.
     * Verifies that the player does not leave the temple without collecting treasures worth at least 100 gems.
     */
    @Test
    void testTreasureHoarder() {
        Players hoarder = new Players("Treasure Hoarder", (players) -> {
            if (players.getExpeditionLoot() >= 100) {
                players.leavingTheTemple();
            }
        });

        hoarder.setExpeditionLoot(80); // Below threshold
        hoarder.getTheStrategy().decide(hoarder);
        assertFalse(hoarder.getHasExited(),
                "TreasureHoarder should not leave the temple without collecting treasures worth at least 100 gems!");
    }
}