import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    // Test klass för drops av item

    @Test
    void checkIfItemdropIsNull() {
    }

    @Test
    void healthDecreasesAfterAttack(){
        Bawser bawser = new Bawser();
        Player mario = new Player("Mario");
        assertEquals(100, bawser.getHealth());
        mario.attack(bawser);
        assertEquals(80, bawser.getHealth());
    }

    @Test
    void monsterDiesAfterAttack() {
        Goomba goomba = new Goomba();
        Player mario = new Player("Mario");
        assertFalse(goomba.getIsDead());
        mario.attack(goomba);
        assertTrue(goomba.getIsDead());
    }

    @Test
    void monsterAttacksPlayer() {
        Goomba goomba = new Goomba();
        Player mario = new Player("Mario");
        assertEquals(100, mario.getHealth());
        goomba.attack(mario);
        assertEquals(95, mario.getHealth());
    }


    // Monster Typ

    @Test
    void monsterMoveX() {
        Goomba babyGoomb = new Goomba();
        babyGoomb.moveX();
        assertEquals(2, babyGoomb.getPoint().getX());
    }

    @Test
    void monsterMoveY() {
        Goomba babyGoomb = new Goomba();
        babyGoomb.moveY();
        assertEquals(2, babyGoomb.getPoint().getY());
    }

}