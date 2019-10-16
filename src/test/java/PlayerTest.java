import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player testPlayer = new Player("Mike");


    @Test
    void testIfNameContainsNumber() {
        Player testCh = new Player("22.3");
        assertTrue(testCh.getName().matches(".*\\d.*"));
    }

    @Test
    void testNameNull(){
        Player testCh = new Player(null);
        assertNotNull(testCh.getName());
    }

    @Test
    void testNameEmpty(){
        //nameEmpty method should have a boolean return type
        Player testCh = new Player("     ");
        assertFalse(testCh.getName().trim().isEmpty());
    }

    @Test
    void testNameString(){
        Player testCh = new Player("SavageB");
        assertEquals("SavageB",testCh.getName());
    }


    @Test
    void testHealthNumberRangeNull(){
        //healthRangeCorrect should return a boolean.
        int x = Integer.parseInt(null);
        Player testCh = new Player("SavageB");
        assertFalse(testCh.healthRangeCorrect(testCh.getHealth()));
    }

    @Test
    void testHealthNumberRangeNegative(){
        Player testCh = new Player("SavageB");
        assertTrue(testCh.healthRangeCorrect(testCh.getHealth()));
    }
    @Test
    void testHealthNumberRangeAboveRange(){
        Player testCh = new Player("SavageB");
        assertTrue(testCh.healthRangeCorrect(testCh.getHealth()));

    }

    @Test
    void fullInventorySizeStaysSameOnFullLoot() {
        // Inventory size should remain unchanged if player tries to pick up an item when inventory is full.
        Weapon weapon = new Weapon();
        testPlayer.pickUpLoot(weapon);
        assertTrue(testPlayer.getInventory.size(), 9);
    }

    @Test
    void fullInventoryDoesNotContainNewLoot() {
        // Player attempts to pick up a new item with an already full inventory, inventory should not contain this item.
        Weapon weapon = new Weapon();
        testPlayer.pickUpLoot(weapon);
        assertFalse(testPlayer.getInventory.contains(weapon));
    }


}