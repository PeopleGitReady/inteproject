import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    Map map = new Map(0, 0, 100, 100);

    @Test
    void healthDecreasesAfterAttack(){
        Bawser bawser = new Bawser();
        bawser.setLocation(50, 50);
        Player mario = new Player("Mario");
        mario.setLocation(51, 50);
        mario.attack(bawser);
        assertEquals(80, bawser.getHealth());
    }

    @Test
    void monsterDiesAfterAttack() {
        Goomba goomba = new Goomba();
        goomba.setLocation(51, 50);
        Player mario = new Player("Mario");
        mario.setLocation(51, 51);
        mario.attack(goomba);
        assertTrue(goomba.getIsDead());
    }

    @Test
    void monsterAttacksPlayer() {
        Goomba goomba = new Goomba();
        goomba.setLocation(52, 50);
        Player mario = new Player("Mario");
        mario.setLocation(53, 51);
        goomba.attack(mario);
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
        baws.attack(mo);
        assertEquals(80, mo.getHealth());
    }

    @Test
    void attackIfInRangeY() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 100);
        Bawser baws = new Bawser();
        baws.setLocation(50, 99);
        baws.attack(mo);
        assertEquals(80, mo.getHealth());
    }

    @Test
    void attackOutOfRangeX() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 100);
        Bawser baws = new Bawser();
        baws.setLocation(55, 100);
        mo.attack(baws);
        assertEquals(100, mo.getHealth());
    }

    @Test
    void attackOutOfRangeY() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 50);
        Bawser baws = new Bawser();
        baws.setLocation(55, 52);
        mo.attack(baws);
        assertEquals(100, mo.getHealth());
    }
}