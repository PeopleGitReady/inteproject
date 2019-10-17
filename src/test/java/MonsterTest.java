import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {



    // Test klass för Monster liv

    // Test klass för drops av item


    @Test
    void checkIfItemdropIsNull() {
    }



    @Test
    void healthDecreasesAfterAttack(){

        Monster bawser = new Monster("Bawser", 100, 20, 3);
        Player mario = new Player("Mario");
        assertEquals(100, bawser.getHealth());
        mario.attack(bawser);
        assertEquals(80, bawser.getHealth());
    }

    // Test klass för Monster attack

    // Monster Typ

    // Testklass för gå

    // Gå i X-led

    // Gå i Y-led

}