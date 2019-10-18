import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void gainXPOnSlayingMob () {
        Player player = new Player("Grogg");
        assertEquals(0, player.getXp());
        Goomba gombi = new Goomba();
        player.attack(gombi, player);
        assertEquals(5, player.getXp());
    }

    @Test
    void levelUpOnGainingRequiredXP () {

    }

    @Test
    void maxHealthIncreasesOnLevelUp () {

    }


    @Test
    void healthDecreasesAfterAttack(){
        Bawser bawser = new Bawser();
        Player mario = new Player("Mario");
        assertEquals(100, mario.getHealth());
        bawser.attack(mario, bawser);
        assertEquals(80, mario.getHealth());
    }

    @Test
    void nameNull(){
        assertThrows(NullPointerException.class, () -> {
            Player testCh = new Player(null);
        });
    }

    @Test
    void gainHealthOnConsumingHealthPotion() {
        //assuming a health potion always increases current hp by 20
        Player testPlayer = new Player("Johnny");
        generateFullInventory(testPlayer);
        Bawser bawser = new Bawser();
        bawser.attack(testPlayer, bawser);
        assertEquals(80, testPlayer.getHealth());
        testPlayer.useHealthPotion();
        assertEquals(100, testPlayer.getHealth());
    }

    @Test
    void useHealthPotionEvenIfItDoesntExistInInventory(){
        Player testPlayer = new Player("Here's Johnny");
        Weapon weapon1 = new Weapon();
        Weapon weapon2 = new Weapon();

        testPlayer.pickUpLoot(weapon1);
        testPlayer.pickUpLoot(weapon2);
        Bawser bawser = new Bawser();
        bawser.attack(testPlayer, bawser);

        testPlayer.useHealthPotion();

        assertEquals(80, testPlayer.getHealth());

    }

    @Test
    void healthPotionDoesNotExceedMaxHealth () {
        Player player = new Player("Hodor");
        generateFullInventory(player);
        player.setHealth(85);
        assertEquals(85, player.getHealth());
        player.useHealthPotion();
        assertEquals(100, player.getHealth());

    }

    @Test
    void healthPotionDoesNotAffectMaxHealth () {
        // assuming a health potion always increases current hp by 20
        Player testPlayer = new Player("Johnny");
        generateFullInventory(testPlayer);
        assertEquals(100, testPlayer.getMaxHealth());
        testPlayer.useHealthPotion();
        assertEquals(100, testPlayer.getMaxHealth());
    }

    @Test
    void useHealthPotionOnlyUsesOnePotion () {
        Player testPlayer = new Player("Johnny");
        HealthPotion healthPotion1 = new HealthPotion();
        HealthPotion healthPotion2 = new HealthPotion();
        testPlayer.pickUpLoot(healthPotion1);
        testPlayer.pickUpLoot(healthPotion2);
        assertEquals(2, testPlayer.getInventory().size());
        testPlayer.useHealthPotion();
        assertEquals(1, testPlayer.getInventory().size());
    }

    @Test
    void fullInventorySizeStaysSameOnLoot() {
        // Player tries to pick up a new item with an already full inventory, size of inventory should stay unchanged.
        Player testPlayer = new Player("Mike");
        generateFullInventory(testPlayer);
        Weapon droppedWeapon = new Weapon();
        testPlayer.pickUpLoot(droppedWeapon);
        assertEquals(10, testPlayer.getInventory().size());
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

    @Test
    void monsterDiesAfterAttack() {
        Bawser bawser = new Bawser();
        Player mario = new Player("Mario");
        mario.setHealth(20);
        assertFalse(mario.getIsDead());
        bawser.attack(mario, bawser);
        assertTrue(mario.getIsDead());
    }

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

    @Test
    void playerMoveX() {
        Player p = new Player("Playah");
        assertEquals(0, p.getPoint().getX());
        p.moveX();
        assertEquals(1, p.getPoint().getX());
    }


    @Test
    void playerMoveY() {
        Player p = new Player("Playah");
        assertEquals(0, p.getPoint().getX());
        p.moveY();
        assertEquals(1, p.getPoint().getY());
    }


    @Test
    void playerEquipsNonWeaponItem(){

    }

    @Test
    void playerEquipsWeaponAndChangesStats(){
        //The aim of this test is to check if a wepon has been picked
        //and it chages the damange stats of the Player carrying it

        Player p = new Player("Here's Jonny");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33);


        boolean testIsTrue = p.pickUpWeapon(valyrian_steel);
        assertTrue(testIsTrue,"This shows player has accepted weapon");

        assertEquals(53,p.getDamage());
    }

    @Test
    void playerDropsWeapon(){
        //the aim of this test is to check the dmg change in player
        //And that the Arraylist that holds the weapon is empty!

        Player p = new Player("Here's Jonny");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33);

        p.pickUpWeapon(valyrian_steel);

        boolean testIsTrue = p.pickUpWeapon(valyrian_steel);
        assertTrue(testIsTrue);

        //Now it  will checp after player drops a weapon



    }




}