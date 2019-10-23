import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    Map map = new Map(0, 0, 100, 100);

    // Test klass för drops av item
/*
    @Test
    void checkIfItemIsDropped() {
        Goomba groovyGoomba = new Goomba();
        assertTrue(groovyGoomba.getIsDead());
        // Kolla platsen Goomba dog på
        // Droppa item där
    }

 */

    @Test
    void healthDecreasesAfterAttack(){
        Bawser bawser = new Bawser();
        Player mario = new Player("Mario");
        mario.attack(bawser, mario);
        assertEquals(80, bawser.getHealth());
    }

    @Test
    void monsterDiesAfterAttack() {
        Goomba goomba = new Goomba();
        Player mario = new Player("Mario");
        mario.attack(goomba, mario);
        assertTrue(goomba.getIsDead());
    }

    @Test
    void monsterAttacksPlayer() {
        Goomba goomba = new Goomba();
        Player mario = new Player("Mario");
        goomba.attack(mario, goomba);
        assertEquals(95, mario.getHealth());
    }
    @Test
    void checkCalculateXpIsCorrect () {
        Goomba gombiboye = new Goomba();
        assertEquals(10, gombiboye.calculateXp());
    }

    @Test
    void attackIfInRangeX() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 100);

        Bawser baws = new Bawser();
        baws.setLocation(51, 100);

        mo.attack(mo, baws);
        assertEquals(80, mo.getHealth());
    }

    @Test
    void attackIfInRangeY() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 100);

        Bawser baws = new Bawser();
        baws.setLocation(50, 99);

        mo.attack(mo, baws);
        assertEquals(80, mo.getHealth());
    }

    @Test
    void attackOutOfRangeX() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 100);

        Bawser baws = new Bawser();
        baws.setLocation(55, 100);

        mo.attack(baws, mo);
        assertEquals(80, mo.getHealth());
    }

    @Test
    void attackOutOfRangeY() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 50);

        Bawser baws = new Bawser();
        baws.setLocation(55, 52);

        mo.attack(baws, mo);
        assertEquals(100, mo.getHealth());
    }
}