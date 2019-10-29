import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {


    @Test
    void armorAffectsHealthDecrease() {
        Player playah = new Player("MOSH");
        Armor armor = new Armor("armor", 13, Armor.CHEST,ArmorTypeRarity.COMMON);
        playah.pickUpLoot(armor);
        playah.equipArmor(armor);
        Goomba goomba = new Goomba();
        goomba.attack(playah, goomba);
        assertEquals(93, playah.getHealth());
    }


    @Test
    void unequipArmorChangesArmor(){
       /* Player playah = new Player("MOSH");
        Armor armor = new Armor("armor", 13, Armor.CHEST,ArmorTypeRarity.EPIC);
        playah.pickUpLoot(armor);
        playah.equipArmor(armor);
        playah.unequipArmor();
        assertEquals(0, playah.getArmor());*/
    }


    @Test
    void armorStatChangesWhenNewArmorIsEquipped(){
        Player playah = new Player("MOSH");
        Armor armor = new Armor("armor", 13, Armor.CHEST,ArmorTypeRarity.COMMON);
        playah.pickUpLoot(armor);
        playah.equipArmor(armor);
        Armor armorEpic = new Armor("armor", 13, Armor.CHEST,ArmorTypeRarity.EPIC);
        playah.pickUpLoot(armorEpic);
        playah.equipArmor(armorEpic);
        //assertEquals(17,playah.getArmor());

    }

    @Test
    void equipArmorAndShowArmorStatIncrease(){

    }


    @Test
    void checkDuplicatesForOneTypeOfArmor(){
       /* Player playah = new Player("MOSH");
        Armor armor = new Armor("armor", 13, Armor.CHEST,ArmorType.COMMON);
        playah.pickUpLoot(armor);
        playah.equipArmor(armor);

        Armor armorEpic = new Armor("armor", 13, Armor.CHEST,ArmorType.EPIC);
        playah.pickUpLoot(armorEpic);
        playah.equipArmor(armorEpic);

        assertTrue(playah.containsNoDuplicates());*/
    }

    @Test
    void checkThatLegsSlotDoesContainLegArmor(){
        Player playah = new Player("MOSH");



    }

    @Test
    void checkThatChestSlotDoesContainChestArmor(){

    }

    @Test
    void checkThatHeadSlotDoesContainHeadArmor(){

    }

    @Test
    void checkThatHandSlotDoesContainHandArmor(){

    }


    @Test
    void checkThatFeetSlotDoesContainfeetArmor(){

    }




}