import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Map map = new Map(0, 0, 100, 100);

    @Test
    void gainXPOnSlayingMob () {
        Player player = new Player("Grogg");
        Goomba gombi = new Goomba();
        player.attack(gombi);
        assertEquals(10, player.getXp());
    }

    @Test
    void levelUpOnGainingRequiredXP () {
        Player player = new Player("Babushka");
        Goomba goomblord = new Goomba();
        player.setXp(95);
        goomblord.setHealth(5);
        player.attack(goomblord);
        assertEquals(2, player.getLevel());
    }

    @Test
    void maxHealthIncreasesOnLevelUp () {
        Player player = new Player("Grrr");
        Goomba gomblord = new Goomba();
        player.setXp(95);
        gomblord.setHealth(5);
        player.attack(gomblord);
        assertEquals(150, player.getMaxHealth());
    }

    @Test
    void playerTriesToMoveWhenDead () {
        Player player = new Player("JoeSchmoe");
        Point point = new Point(0, 0);
        player.setHealth(4);
        Goomba gogo = new Goomba();
        gogo.attack(player);;
        map.moveCharacter(player);
        assertEquals(point, player.getLocation());
    }

    @Test
    void healthDecreasesAfterAttack(){
        Bawser bawser = new Bawser();
        Player mario = new Player("Mario");
        bawser.attack(mario);
        assertEquals(80, mario.getHealth());
    }

    @Test
    void checkIfNameIsNull(){
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
    void playerDiesAfterAttack() {
        Bawser bawser = new Bawser();
        Player mario = new Player("Mario");
        mario.setHealth(20);
        bawser.attack(mario);
        assertTrue(mario.getIsDead());
    }

    @Test
    void checkIfNameContainsNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Player testCh = new Player("22.3");
        });
    }

    @Test
    void checkIfNameIsEmpty(){
        assertThrows(IllegalArgumentException.class, () -> {
            Player testCh = new Player("     ");
        });
    }

    @Test
    void checkIfNameIsString(){
        Player testCh = new Player("SavageB");
        assertEquals("SavageB",testCh.getName());
    }

    @Test
    void attackIfInRangeX() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 100);
        Bawser bobo = new Bawser();
        bobo.setLocation(51, 100);
        mo.attack(bobo);
        assertEquals(80, bobo.getHealth());
    }

    @Test
    void attackIfInRangeY() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 50);
        Bawser bobo = new Bawser();
        bobo.setLocation(50, 51);
        mo.attack(bobo);
        assertEquals(80, bobo.getHealth());
    }

    @Test
    void attackOutOfRangeX() {
        Player mobo = new Player("Mo");
        mobo.setLocation(50, 100);
        Bawser baws = new Bawser();
        baws.setLocation(55, 100);
        mobo.attack(baws);
        assertEquals(100, baws.getHealth());
    }

    @Test
    void attackOutOfRangeY() {
        Player mobo = new Player("Mo");
        mobo.setLocation(50, 50);
        Bawser baws = new Bawser();
        baws.setLocation(50, 52);
        mobo.attack(baws);
        assertEquals(100, baws.getHealth());
    }

    private void generateFullInventory (Player player) {
        for (int i = 0; i < 5; i++) {
            player.pickUpLoot(new HealthPotion());
            player.pickUpLoot(new Weapon());
        }
    }
}