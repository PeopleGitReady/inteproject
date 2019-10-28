import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Map map = new Map(0, 0, 100, 100);

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
        Goomba goomblord = new Goomba();
        player.setXp(95);
        goomblord.setHealth(5);
        player.attack(goomblord, player);
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
        map.moveCharacter(player);
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
    void fullInventorySizeStaysSameOnLoot() {
        Player testPlayer = new Player("Mike");
        generateFullInventory(testPlayer);
        Weapon droppedWeapon = new Weapon();
        testPlayer.pickUpLoot(droppedWeapon);
        assertEquals(10, testPlayer.getInventory().size());
    }

    @Test
    void fullInventoryDoesNotContainNewLoot() {
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
    void attackIfInRangeX() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 100);
        Bawser bobo = new Bawser();
        bobo.setLocation(51, 100);
        mo.attack(bobo, mo);
        assertEquals(80, bobo.getHealth());
    }

    @Test
    void attackIfInRangeY() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 50);
        Bawser bobo = new Bawser();
        bobo.setLocation(50, 51);
        mo.attack(bobo, mo);
        assertEquals(80, bobo.getHealth());
    }

    @Test
    void attackOutOfRangeX() {
        Player mobo = new Player("Mo");
        mobo.setLocation(50, 100);
        Bawser baws = new Bawser();
        baws.setLocation(55, 100);
        mobo.attack(baws, mobo);
        assertEquals(100, baws.getHealth());
    }

    @Test
    void attackOutOfRangeY() {
        Player mobo = new Player("Mo");
        mobo.setLocation(50, 50);
        Bawser baws = new Bawser();
        baws.setLocation(50, 52);
        mobo.attack(baws, mobo);
        assertEquals(100, baws.getHealth());
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