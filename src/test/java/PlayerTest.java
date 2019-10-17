import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player testPlayer = new Player("Mike");
    Monster testMonster = new Monster("Luigi",100, 25, 10);

    @Test
    void nameContainsNumber() {
        Player testCh = new Player("22.3");
        assertTrue(testCh.getName().matches(".*\\d.*"));
    }

    @Test
    void nameNull(){
        assertThrows(NullPointerException.class, () -> {
            Player testCh = new Player(null);
        });
    }

    @Test
    void nameEmpty(){
        Player testCh = new Player("     ");
        assertTrue(testCh.getName().trim().isEmpty());
    }

    @Test
    void nameString(){
        Player testCh = new Player("SavageB");
        assertEquals("SavageB",testCh.getName());
    }

    @Test
    void healthDecreasesAfterAttack(){
        Monster bawser = new Monster("Bawser", 100, 20, 3);
        Player mario = new Player("Mario");
        assertEquals(100, mario.getHealth());
        bawser.attack(mario);
        assertEquals(80, mario.getHealth());
    }

    @Test
    void fullInventorySizeStaysSameOnLoot() {
        // Player tries to pick up a new item with an already full inventory, size of inventory should stay unchanged.
        // need to add a full inventory to testPlayer for test to be valid
        Weapon weapon = new Weapon();
        testPlayer.pickUpLoot(weapon);
        assertEquals(9, testPlayer.getInventory().size());
    }

    @Test
    void fullInventoryDoesNotContainNewLoot() {
        // Player tries to pick up a new item with an already full inventory, inventory should not contain this item.
        // need to add a full inventory to testPlayer for test to be valid
        Weapon weapon = new Weapon();
        testPlayer.pickUpLoot(weapon);
        assertFalse(testPlayer.getInventory().contains(weapon));
    }


}