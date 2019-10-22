import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void gainXPOnSlayingMob () {
        Player player = new Player("Grogg");
        Goomba gombi = new Goomba();
        player.attack(gombi, player);
        assertEquals(10, player.getXp());
    }


    @Test
    void levelUpOnGainingRequiredXP () {
        Player player = new Player("Babushka");
        Goomba gomblord = new Goomba();
        player.setXp(95);
        gomblord.setHealth(5);
        player.attack(gomblord, player);
        assertEquals(2, player.getLevel());
    }

    @Test
    void maxHealthIncreasesOnLevelUp () {
        Player player = new Player("Grrr");
        Goomba gomblord = new Goomba();
        player.setXp(95);
        gomblord.setHealth(5);
        player.attack(gomblord, player);
        assertEquals(150, player.getMaxHealth());
    }

    @Test
    void playerTriesToMoveWhenDead () {
        Player player = new Player("JoeSchmoe");
        Point point = new Point(0, 0);
        player.setHealth(4);
        Goomba gogo = new Goomba();
        gogo.attack(player, gogo);;
        player.moveRight();
        assertEquals(point, player.getLocation());
    }


    @Test
    void healthDecreasesAfterAttack(){
        Bawser bawser = new Bawser();
        Player mario = new Player("Mario");
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
        player.useHealthPotion();
        assertEquals(100, player.getHealth());

    }

    @Test
    void healthPotionDoesNotAffectMaxHealth () {
        // assuming a health potion always increases current hp by 20
        Player testPlayer = new Player("Johnny");
        generateFullInventory(testPlayer);
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

    @Test
    void moveRight() {
        Player p = new Player("Playah");
        p.moveRight();
        assertEquals(1, p.getX());
    }

    @Test
    void moveUp() {
        Player p = new Player("Playah");
        p.moveUp();
        assertEquals(1, p.getY());
    }

    @Test
    void moveXOutOfBounds () {
        // player should not be able to move outside of the map boundary
    }

    @Test
    void moveYOutOfBounds () {

    }

    @Test
    void equipNonWeaponItem(){

    }

    @Test
    void equipWeaponChangesDamage(){

        Player p = new Player("Here's Jonny");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33);

        p.pickUpLoot(valyrian_steel);
        p.equipWeapon(valyrian_steel);
        assertEquals(53,p.getDamage());
    }

    @Test
    void unequipWeaponChangesDamage(){

        Player p = new Player("Here's Jonny");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33);

        p.pickUpLoot(valyrian_steel);
        p.equipWeapon(valyrian_steel);
        p.unequipWeapon();


        assertEquals(20, p.getDamage());
    }

    @Test
    void changeWeaponFromPreviousWeapon(){
        Player p = new Player("Here's Jonny");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33);

        p.pickUpLoot(valyrian_steel);
        p.equipWeapon(valyrian_steel);

        Weapon justASwerd = new Weapon("KewlSword",55);
        p.pickUpLoot(justASwerd);
        p.equipWeapon(justASwerd);

        assertEquals(75,p.getDamage());

    }

    @Test
    void checkDamageIsCorrectWhenPlayerAttacks(){
        Player p = new Player("Here's Jonny");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33);

        p.pickUpLoot(valyrian_steel);
        p.equipWeapon(valyrian_steel);


        Bawser bawser = new Bawser();
        p.attack(bawser,p);
        assertEquals(47,bawser.getHealth());

    }



    private void generateFullInventory (Player player) {

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