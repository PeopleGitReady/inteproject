import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

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
    void moveRight() {
        Goomba babyGoomb = new Goomba();
        babyGoomb.moveRight();
        assertEquals(2, babyGoomb.getX());
    }

    @Test
    void moveUp() {
        Goomba babyGoomb = new Goomba();
        babyGoomb.moveUp();
        assertEquals(2, babyGoomb.getY());
    }

    @Test
    void moveYOutOfBounds () {

    }

    @Test
    void checkCalculateXpIsCorrect () {
        Goomba gombiboye = new Goomba();
        assertEquals(10, gombiboye.calculateXp());
    }

}