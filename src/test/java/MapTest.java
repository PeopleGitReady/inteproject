import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    Map map = new Map(0, 0, 100, 100);

    @Test
    void characterAddedToMap() {
        Player p = new Player("Frida");
        map.add(p);
        assertTrue(map.contains(p));
    }

    @Test
    void moveRight() {
        Player p = new Player("Playah");
        Point expectedLocation = new Point(51, 50);
        p.setLocation(50, 50);
        map.moveCharacter(p);
        assertEquals(expectedLocation, p.getLocation());
    }

    @Test
    void moveLeft() {
        Player p = new Player("Playah");
        Point expectedLocation = new Point(49, 50);
        p.setLocation(50, 50);
        p.setDirection(Direction.LEFT);
        map.moveCharacter(p);
        assertEquals(expectedLocation, p.getLocation());
    }

    @Test
    void moveUp() {
        Player p = new Player("Playah");
        Point expectedLocation = new Point(50, 51);
        p.setLocation(50, 50);
        p.setDirection(Direction.UP);
        map.moveCharacter(p);
        assertEquals(expectedLocation, p.getLocation());
    }

    @Test
    void moveDown() {
        Player p = new Player("Playah");
        Point expectedLocation = new Point(50, 49);
        p.setLocation(50, 50);
        p.setDirection(Direction.DOWN);
        map.moveCharacter(p);
        assertEquals(expectedLocation, p.getLocation());
    }

    @Test
    void moveXOutOfBoundsRight () {
        // player should not be able to move outside of the map boundary
        Player p = new Player("Playah");
        Point expectedLocation = new Point(99, 50);
        p.setLocation(99, 50);
        map.moveCharacter(p);
        assertEquals(expectedLocation, p.getLocation());
    }

    @Test
    void moveXOutOfBoundsLeft () {
        // player should not be able to move outside of the map boundary
        Player p = new Player("Playah");
        Point expectedLocation = new Point(0, 50);
        p.setLocation(0, 50);
        p.setDirection(Direction.LEFT);
        map.moveCharacter(p);
        assertEquals(expectedLocation, p.getLocation());
    }

    @Test
    void moveYOutOfBoundsUp () {
        // player should not be able to move outside of the map boundary
        Player p = new Player("Playah");
        Point expectedLocation = new Point(54, 99);
        p.setLocation(54, 99);
        p.setDirection(Direction.UP);
        map.moveCharacter(p);
        assertEquals(expectedLocation, p.getLocation());
    }

    @Test
    void moveYOutOfBoundsDown () {
        // player should not be able to move outside of the map boundary
        Player p = new Player("Playah");
        Point expectedLocation = new Point(64, 0);
        p.setLocation(64, 0);
        p.setDirection(Direction.DOWN);
        map.moveCharacter(p);
        assertEquals(expectedLocation, p.getLocation());
    }
}
