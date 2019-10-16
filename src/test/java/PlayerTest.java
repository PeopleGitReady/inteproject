import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player testPlayer = new Player("Mike");
    Monster testMonster = new Monster("Luigi",100, 25, 10);

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
        //assertFalse(testCh.healthRangeCorrect(testCh.getHealth()));
    }

    @Test
    void testHealthNumberRangeNegative(){
        Player testCh = new Player("SavageB");
        //assertTrue(testCh.healthRangeCorrect(testCh.getHealth()));
    }
    @Test
    void testHealthNumberRangeAboveRange(){
        Player testCh = new Player("SavageB");
        //assertTrue(testCh.healthRangeCorrect(testCh.getHealth()));

    }

    @Test
    void testHealthAfterAttack(){

        //metoden kommer ändra
        //we assume that monster does 25 dmg per attack
        testMonster.attack(testPlayer);
        testMonster.attack(testPlayer);
        testMonster.attack(testPlayer);
        testMonster.attack(testPlayer);
        testMonster.attack(testPlayer);

        assertEquals(0, testPlayer.getHealth());
    }


    @Test
    void checkIfPlayerHealthBelowZero() {

    }

    @Test
    void fullInventorySizeStaysSameOnFullLoot() {
        // Inventory size should remain unchanged if player tries to pick up an item when inventory is full.
        //pickUpLoot boolean?
        //will the pickUpLoot only have a weapon dataType, could it be other Items such as potions?
        Weapon weapon = new Weapon();
        testPlayer.pickUpLoot(weapon);
        assertEquals(9, testPlayer.getInventory().size());
    }

    @Test
    void fullInventoryDoesNotContainNewLoot() {
        // Player attempts to pick up a new item with an already full inventory, inventory should not contain this item.
        Weapon weapon = new Weapon();
        testPlayer.pickUpLoot(weapon);
        assertFalse(testPlayer.getInventory().contains(weapon));
    }


}