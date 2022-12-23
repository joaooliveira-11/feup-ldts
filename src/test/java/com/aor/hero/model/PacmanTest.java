package com.aor.hero.model;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.model.game.elements.Pacman;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class PacmanTest {
    private Pacman pacman;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        pacman = new Pacman(10, 10);
        arena.setMonsters(Arrays.asList(new Monster(4, 5), new Monster(5, 6)));

    }

    @Test
    void Pacman_getVidas(){
        Assertions.assertEquals(3, pacman.getVidas());
        Assertions.assertNotEquals(true, pacman.getVidas());
        Assertions.assertNotEquals(false, pacman.getVidas());
        Assertions.assertNotEquals(-1, pacman.getVidas());
    }

    @Test
    void Pacman_getPontos(){
        Assertions.assertNotEquals(true, pacman.getPontos());
        Assertions.assertNotEquals(false, pacman.getPontos());
        Assertions.assertNotEquals(-1, pacman.getPontos());
        Assertions.assertEquals(0,pacman.getPontos());
    }

    @Test
    void Pacman_aumentarpontoscoin(){
        pacman.aumentarpontoscoin();
        Assertions.assertEquals(10,pacman.getPontos());
        Assertions.assertNotEquals(20,pacman.getPontos());
        Assertions.assertNotEquals(true, pacman.getPontos());
        Assertions.assertNotEquals(false, pacman.getPontos());
        Assertions.assertNotEquals(-1, pacman.getPontos());
    }

    @Test
    void Pacman_aumentarpontossupercoin(){
        pacman.aumentarpontossupercoin();
        Assertions.assertEquals(50,pacman.getPontos());
        Assertions.assertNotEquals(100,pacman.getPontos());
        Assertions.assertNotEquals(true, pacman.getPontos());
        Assertions.assertNotEquals(false, pacman.getPontos());
        Assertions.assertNotEquals(-1, pacman.getPontos());
    }
    @Test
    void Pacman_aumentarpontosmontro(){
        pacman.aumentarpontosmonstro();
        Assertions.assertNotEquals(0, pacman.getPontos());
        Assertions.assertEquals(100, pacman.getPontos());
    }

    @Test
    void Pacman_diminuirvidas(){
        pacman.diminuirVidas();
        Assertions.assertEquals(2,pacman.getVidas());
        Assertions.assertNotEquals(3,pacman.getVidas());
        Assertions.assertNotEquals(true, pacman.getVidas());
        Assertions.assertNotEquals(false, pacman.getVidas());
        Assertions.assertNotEquals(-1, pacman.getVidas());
    }

    @Test
    void Monster_isRunning(){
        for(Monster monster : arena.getMonsters()){
            Assertions.assertFalse(monster.isRunning());
        }
        for(Monster monster : arena.getMonsters()){
            monster.setRunningState(true);
        }
        for(Monster monster : arena.getMonsters()){
            Assertions.assertTrue(monster.isRunning());
        }
    }

    @Test
    void Monster_isRunningNormal(){
        for(Monster monster : arena.getMonsters()){
            monster.setRunningState(true);
        }
        for(Monster monster: arena.getMonsters()){
            Assertions.assertTrue(monster.isRunning());
        }
        for(Monster monster : arena.getMonsters()){
            monster.setRunningState(false);
        }
        for(Monster monster : arena.getMonsters()){
            Assertions.assertFalse(monster.isRunning());
        }
    }
    @Test
    void Pacman_getPowerTime(){
        pacman.startPowerTime();
    }

    @Test
    void Pacman_didTimeEnd(){
        pacman.startPowerTime();
        pacman.didTimeEnd();
        Assertions.assertFalse(pacman.didTimeEnd());
    }

    @Test
    void Pacman_getDirections(){
        Assertions.assertNotNull(pacman.getDirection());
        Assertions.assertEquals("none", pacman.getDirection());
        pacman.setDirection("up");
        Assertions.assertNotEquals(pacman.getDirection(), "down");
        Assertions.assertEquals("up", pacman.getDirection());
    }

}
