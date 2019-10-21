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



    // Monster Typ
    @Test
    void moveX() {
        Goomba babyGoomb = new Goomba();
        babyGoomb.moveX();
        assertEquals(2, babyGoomb.getPoint().getX());
    }

    @Test
    void moveY() {
        Goomba babyGoomb = new Goomba();
        babyGoomb.moveY();
        assertEquals(2, babyGoomb.getPoint().getY());
    }

    @Test
    void checkCalculateXpIsCorrect () {
        Goomba gombiboye = new Goomba();
        assertEquals(10, gombiboye.calculateXp());
    }

}