import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsumableTest {



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