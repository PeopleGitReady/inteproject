import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    //Player testPlayer = new Player("Mike");
    //Monster testMonster = new Monster("Luigi",100, 25, 10);

    /*
    @Test
    void healthDecreasesAfterAttack(){
        Monster bawser = new Monster("Bawser", 100, 20, 3);
        Player mario = new Player("Mario");
        assertEquals(100, mario.getHealth());
        bawser.attack(mario);
        assertEquals(80, mario.getHealth());
    }
     */

    @Test
    void nameNull(){
        assertThrows(NullPointerException.class, () -> {
            Player testCh = new Player(null);
        });
    }

    /*
    @Test
    void gainHealthOnConsumingHealthPotion() {
        //assuming a health potion always increases current hp by 20
        Player testPlayer = new Player("Johnny");
        Monster bawser = new Monster("Bawser", 100, 20, 3);
        bawser.attack(testPlayer);
        assertEquals(80, testPlayer.getHealth());
        HealthPotion healthPotion = new HealthPotion();
        testPlayer.useHealthPotion();
        assertEquals(100, testPlayer.getHealth());
    }

     */

    @Test
    void healthPotionDoesNotExceedMaxHealth () {

    }

    @Test
    void healthPotionDoesNotAffectMaxHealth () {
        //assuming a health potion always increases current hp by 20
        Player testPlayer = new Player("Johnny");

    }

    @Test
    void fullInventorySizeStaysSameOnLoot() {
        // Player tries to pick up a new item with an already full inventory, size of inventory should stay unchanged.
        Player testPlayer = new Player("Mike");
        generateFullInventory(testPlayer);
        Weapon droppedWeapon = new Weapon();
        testPlayer.pickUpLoot(droppedWeapon);
        assertEquals(9, testPlayer.getInventory().size());
    }

    @Test
    void fullInventoryDoesNotContainNewLoot() {
        // Player tries to pick up a new item with an already full inventory, inventory should not contain this item.
        Player testPlayer = new Player("Mike");
        generateFullInventory(testPlayer);
        Weapon droppedWeapon = new Weapon();
        testPlayer.pickUpLoot(droppedWeapon);
        assertFalse(testPlayer.getInventory().contains(droppedWeapon));
    }

    /*
    @Test
    void monsterDiesAfterAttack() {
        Monster bawser = new Monster("Bawser", 100, 40, 3);
        Player mario = new Player("Mario");
        mario.setHealth(30);
        assertFalse(mario.getIsDead());
        bawser.attack(mario);
        assertTrue(mario.getIsDead());
    }

     */


    @Test
    void nameContainsNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player testCh = new Player("22.3");
        });
    }

    @Test
    void nameEmpty(){

        assertThrows(IllegalArgumentException.class, () -> {
            Player testCh = new Player("     ");
        });
    }

    @Test
    void nameString(){
        Player testCh = new Player("SavageB");
        assertEquals("SavageB",testCh.getName());
    }

    void generateFullInventory (Player player) {

        HealthPotion healthPotion1 = new HealthPotion();
        HealthPotion healthPotion2 = new HealthPotion();
        HealthPotion healthPotion3 = new HealthPotion();
        HealthPotion healthPotion4 = new HealthPotion();
        HealthPotion healthPotion5 = new HealthPotion();

        Weapon weapon1 = new Weapon();
        Weapon weapon2 = new Weapon();
        Weapon weapon3 = new Weapon();
        Weapon weapon4 = new Weapon();
        Weapon weapon5 = new Weapon();

        player.pickUpLoot(healthPotion1);
        player.pickUpLoot(healthPotion2);
        player.pickUpLoot(healthPotion3);
        player.pickUpLoot(healthPotion4);
        player.pickUpLoot(healthPotion5);
        player.pickUpLoot(weapon1);
        player.pickUpLoot(weapon2);
        player.pickUpLoot(weapon3);
        player.pickUpLoot(weapon4);
        player.pickUpLoot(weapon5);

    }

}