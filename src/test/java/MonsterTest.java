import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {


    // Test klass för Monster liv

    // Test klass för drops av item
    @Test
    void checkIfItemdropIsNul() {
    }

    @Test
    void TestHealthNumberRangeNull(){
        //healthRangeCorrect should return a boolean.
        int x = Integer.parseInt(null);
        Character testCh = new Character("SavageB",44,x);
        assertFalse(testCh.healthRangeCorrect(testCh.getHealth));
    }

    // Test klass för Monster attack

    // Monster Typ

    // Testklass för gå

    // Gå i X-led

    // Gå i Y-led

}