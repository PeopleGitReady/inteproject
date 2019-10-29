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
        p.attack(bawser);
        assertEquals(47,bawser.getHealth());
    }

    private void generateFullInventory (Player player) {
        for (int i = 0; i < 5; i++) {
            player.pickUpLoot(new HealthPotion());
            player.pickUpLoot(new Weapon());
        }
    }
}