import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {

    @Test
    void equipWeaponChangesDamage(){
        Player p = new Player("Here's Jonny");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33,WeaponType.COMMON);
        p.pickUpLoot(valyrian_steel);
        p.equipWeapon(valyrian_steel);
        assertEquals(53,p.getDamage());
    }

    @Test
    void unequipWeaponChangesDamage(){
        Player p = new Player("Here's Jonny");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33,WeaponType.COMMON);
        p.pickUpLoot(valyrian_steel);
        p.equipWeapon(valyrian_steel);
        p.unequipWeapon();
        assertEquals(20, p.getDamage());
    }

    @Test
    void cannotUnequipWeaponWithFullInventory () {
        Player hoboChomo = new Player("Chomo");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33,WeaponType.COMMON);
        hoboChomo.pickUpLoot(valyrian_steel);
        hoboChomo.equipWeapon(valyrian_steel);
        generateFullInventory(hoboChomo);
        hoboChomo.unequipWeapon();
        assertTrue(hoboChomo.getWeaponSlot().contains(valyrian_steel));
    }

    @Test
    void changeWeaponFromPreviousWeapon(){
        Player p = new Player("Here's Jonny");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33,WeaponType.COMMON);
        p.pickUpLoot(valyrian_steel);
        p.equipWeapon(valyrian_steel);
        Weapon justASwerd = new Weapon("KewlSword",55,WeaponType.RARE);
        p.pickUpLoot(justASwerd);
        p.equipWeapon(justASwerd);
        assertEquals(77,p.getDamage());
    }

    @Test
    void checkDamageIsCorrectWhenPlayerAttacks(){
        Player p = new Player("Here's Jonny");
        Weapon valyrian_steel = new Weapon("Valyrian Steel",33,WeaponType.COMMON);
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