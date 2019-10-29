import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsumableTest {


    @Test
    void gainHealthOnConsumingHealthPotion() {
        Player testPlayer = new Player("Johnny");
        generateFullInventory(testPlayer);
        Bawser bawser = new Bawser();
        bawser.attack(testPlayer);
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
        bawser.attack(testPlayer);
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

    private void generateFullInventory (Player player) {
        for (int i = 0; i < 5; i++) {
            player.pickUpLoot(new HealthPotion());
            player.pickUpLoot(new Weapon());
        }
    }

}