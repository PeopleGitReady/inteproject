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
    void moveLeft() {
        Goomba babyGoomba = new Goomba();
        Point expectedLocation = new Point(50, 50);
        babyGoomba.setLocation(51, 51);
        babyGoomba.moveLeft();
        assertEquals(expectedLocation, babyGoomba.getLocation());
    }

    @Test
    void moveRight() {
        Goomba babyGoomba = new Goomba();
        Point expectedLocation = new Point(52, 51);
        babyGoomba.setLocation(51, 51);
        babyGoomba.moveRight();
        assertEquals(expectedLocation, babyGoomba.getLocation());
    }

    @Test
    void moveUp() {
        Goomba babyGoomba = new Goomba();
        Point expectedLocation = new Point(51, 52);
        babyGoomba.setLocation(51, 51);
        babyGoomba.moveUp();
        assertEquals(expectedLocation, babyGoomba.getLocation());
    }

    @Test
    void moveDown() {
        Goomba babyGoomba = new Goomba();
        Point expectedLocation = new Point(51, 50);
        babyGoomba.setLocation(51, 51);
        babyGoomba.moveDown();
        assertEquals(expectedLocation, babyGoomba.getLocation());
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