import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {


    // Test klass för Monster liv

    // Test klass för drops av item
    @Test
    void checkIfItemdropIsNull() {
    }

    @Test
    void TestHealthNumberRangeNull(){
        //healthRangeCorrect should return a boolean.
        int x = Integer.parseInt(null);
        Character testCh = new Character("SavageB",44,x);
        assertFalse(testCh.healthRangeCorrect(testCh.getHealth));
    }


    @Test
    void testHealthAfterAttack(){

        //we assume that monster does 25 dmg per attack
        monster.attack(testPlayer);
        monster.attack(testPlayer);
        monster.attack(testPlayer);
        monster.attack(testPlayer);
        monster.attack(testPlayer);

        Player.calculateHealth(monster.getDmg());
        assertEquals(0,);
    }

    // Test klass för Monster attack

    // Monster Typ

    // Testklass för gå

    // Gå i X-led

    // Gå i Y-led

}