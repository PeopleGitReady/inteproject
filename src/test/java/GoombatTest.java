import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class GoombatTest {

    Map map = new Map(0, 0, 100, 100);

    @Test
    void checkIfMonsterNotResurrected() {
        Goomba goon = new Goomba();
        Player p = new Player("dawg");
        goon.setHealth(15);
        p.attack(goon, p);
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(goon.getIsDead());
    }

    @Test
    void checkIfMonsterIsResurrected() {
        Goomba goon = new Goomba();
        Player p = new Player("dawg");
        goon.setHealth(15);
        p.attack(goon, p);
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertFalse(goon.getIsDead());
    }

    @Test
    void checkIfMonsterDisengagesWhenMoreThanFivePointsAway() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 100);
        Bawser bobo = new Bawser();
        bobo.setLocation(51, 100);
        mo.attack(bobo, mo);
        map.moveCharacter(mo);
        map.moveCharacter(mo);
        map.moveCharacter(mo);
        map.moveCharacter(mo);
       // assertFalse(mo.getInCombat());
    }

    @Test
    void checkIfMonsterIsInCombat() {
        Player mo = new Player("Mo");
        mo.setLocation(50, 100);
        Bawser bobo = new Bawser();
        bobo.setLocation(51, 100);
        mo.attack(bobo, mo);
        map.moveCharacter(mo);
        map.moveCharacter(mo);
        map.moveCharacter(mo);
        //assertTrue(mo.getInCombat());
    }



}