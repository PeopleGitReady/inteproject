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
        babyGoomba.moveX(-1);
        assertEquals(expectedLocation, babyGoomba.getLocation());
    }

    @Test
    void moveRight() {
        Goomba babyGoomba = new Goomba();
        Point expectedLocation = new Point(52, 51);
        babyGoomba.setLocation(51, 51);
        babyGoomba.moveX(1);
        assertEquals(expectedLocation, babyGoomba.getLocation());
    }

    @Test
    void moveUp() {
        Goomba babyGoomba = new Goomba();
        Point expectedLocation = new Point(51, 52);
        babyGoomba.setLocation(51, 51);
        babyGoomba.moveY(1);
        assertEquals(expectedLocation, babyGoomba.getLocation());
    }

    @Test
    void moveDown() {
        Goomba babyGoomba = new Goomba();
        Point expectedLocation = new Point(51, 50);
        babyGoomba.setLocation(51, 51);
        babyGoomba.moveY(-1);
        assertEquals(expectedLocation, babyGoomba.getLocation());
    }


    @Test
    void moveXOutOfBoundsRight() {
        Bawser bawser = new Bawser();
        Point expectedLocation = new Point(100, 50);
        bawser.setLocation(100, 50);
        bawser.moveX(1);
        assertEquals(expectedLocation, bawser.getLocation());
    }

    @Test
    void moveXOutOfBoundsLeft() {
        Bawser bawser = new Bawser();
        Point expectedLocation = new Point(100, 50);
        bawser.setLocation(100, 50);
        bawser.moveX(-1);
        assertEquals(expectedLocation, bawser.getLocation());
    }


    @Test
    void moveYOutOfBoundsUp() {
        Bawser bawser = new Bawser();
        Point expectedLocation = new Point(55, 99);
        bawser.setLocation(55, 99);
        bawser.setDirection(Direction.UP);
        map.add(bawser);
        map.handleMovement(bawser);
        assertEquals(expectedLocation, bawser.getLocation());
    }

    @Test
    void moveYOutOfBoundsDown() {
        Bawser bawser = new Bawser();
        Point expectedLocation = new Point(65, 0);
        bawser.setLocation(65, 0);
        bawser.moveY(-1);
        assertEquals(expectedLocation, bawser.getLocation());
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