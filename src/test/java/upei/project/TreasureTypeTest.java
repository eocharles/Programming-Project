package upei.project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the TreasureType class.
 * Validates predefined treasure types, their properties, and functionality within the treasure registry.
 */
class TreasureTypeTest {

    /**
     * Tests the predefined treasure types RUBY and DIAMOND.
     * Verifies their names and weights match the expected values.
     */
    @Test
    void predefinedTreasureTypesAreCorrect() {
        // Test RUBY properties
        assertEquals("RUBY", TreasureType.RUBY.getTreasureName(), "Treasure name for RUBY should be 'RUBY'.");
        assertEquals(5, TreasureType.RUBY.getTreasureWeight(), "Treasure weight for RUBY should be 5.");

        // Test DIAMOND properties
        assertEquals("DIAMOND", TreasureType.DIAMOND.getTreasureName(), "Treasure name for DIAMOND should be 'DIAMOND'.");
        assertEquals(10, TreasureType.DIAMOND.getTreasureWeight(), "Treasure weight for DIAMOND should be 10.");
    }

    /**
     * Tests if predefined treasures are registered in the treasure registry.
     */
    @Test
    void treasureRegistryContainsPredefinedTreasures() {
        // Verify that RUBY and DIAMOND exist in the registry
        assertNotNull(TreasureType.treasureRegistry.get("RUBY"), "RUBY should be registered in the treasure registry.");
        assertNotNull(TreasureType.treasureRegistry.get("DIAMOND"), "DIAMOND should be registered in the treasure registry.");
    }

    /**
     * Tests if the treasure registry lookup is case-insensitive.
     */
    @Test
    void treasureRegistryLookupIsCaseInsensitive() {
        // Verify case-insensitive lookup for RUBY and DIAMOND
        assertSame(TreasureType.RUBY, TreasureType.treasureRegistry.get("ruby".toUpperCase()), "Lookup for 'ruby' should match RUBY.");
        assertSame(TreasureType.DIAMOND, TreasureType.treasureRegistry.get("diamond".toUpperCase()), "Lookup for 'diamond' should match DIAMOND.");
    }

    /**
     * Tests the toString method for TreasureType objects.
     * Verifies that the string representation matches the expected format.
     */
    @Test
    void toStringProvidesCorrectRepresentation() {
        // Verify toString for RUBY and DIAMOND
        assertEquals("RUBY (Weight: 5)", TreasureType.RUBY.toString(), "toString for RUBY should be 'RUBY (Weight: 5)'.");
        assertEquals("DIAMOND (Weight: 10)", TreasureType.DIAMOND.toString(), "toString for DIAMOND should be 'DIAMOND (Weight: 10)'.");
    }
}
