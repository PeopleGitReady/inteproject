import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    // Test klass för drops av item

    @Test
    void checkIfItemdropIsNull() {
    }

    /*
    // Kollar så att Monstrets hp minskar efter en attack
    @Test
    void healthDecreasesAfterAttack(){
        Goomba bawser = new Monster("Bawser", 100, 20, 3);
        Player mario = new Player("Mario");
        assertEquals(100, bawser.getHealth());
        mario.attack(bawser);
        assertEquals(80, bawser.getHealth());
    }
     */

    // Kollar ifall monstet dör
    @Test
    void monsterDiesAfterAttack() {
        Goomba goomba = new Goomba();
        Player mario = new Player("Mario");
        assertFalse(goomba.getIsDead());
        mario.attack(goomba);
        assertTrue(goomba.getIsDead());
    }

    // Test klass för när Monster attackerar Player
    @Test
    void monsterAttacksPlayer() {
        Goomba goomba = new Goomba();
        Player mario = new Player("Mario");
        assertEquals(100, mario.getHealth());
        goomba.attack(mario);
        assertEquals(95, mario.getHealth());
    }


    // Monster Typ

    // Testklass för gå

    // Gå i X-led

    // Gå i Y-led

}