package com.aor.hero.controller;

import com.aor.hero.Game;
import com.aor.hero.controller.game.PacmanController;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;

import com.aor.hero.model.game.elements.Gate;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.model.game.elements.Pacman;
import com.aor.hero.model.game.elements.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class PacmanControllerTest {
    private PacmanController controller;
    private Pacman pacman;
    private Arena arena;
    private Game game = mock(Game.class);

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        pacman = new Pacman(5, 5);
        arena.setPacman(pacman);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arena.setCoins(Arrays.asList());
        arena.setSuperCoins(Arrays.asList());
        arena.setGates(Arrays.asList());
        controller = new PacmanController(arena);
    }

    @Test
    void movePacmanRightEmpty() {
        controller.movePacmanRight();
        assertEquals(new Position(6, 5), pacman.getPosition());
    }

    @Test
    void movePacmanRightNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.movePacmanRight();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void movePacmanLeftEmpty() {
        controller.movePacmanLeft();
        assertEquals(new Position(4, 5), pacman.getPosition());
    }

    @Test
    void movePacmanLeftNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(4, 5)));
        controller.movePacmanLeft();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void movePacmanupEmpty() {
        controller.movePacmanUp();
        assertEquals(new Position(5, 4), pacman.getPosition());
    }

    @Test
    void movePacmanupNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(5, 4)));
        controller.movePacmanUp();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void movePacmandownEmpty() {
        controller.movePacmanDown();
        assertEquals(new Position(5, 6), pacman.getPosition());
    }

    @Test
    void movePacmandownNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(5, 6)));
        controller.movePacmanDown();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }

    @Test
    void movePacman_direction_right() {
        controller.step(game, GUI.ACTION.RIGHT, 0);
        Assertions.assertEquals(controller.getdirection(), "right");
        Assertions.assertNotNull(controller.getdirection());
        assertEquals(new Position(6, 5), pacman.getPosition());
    }
    @Test
    void movePacman_direction_left() {
        controller.step(game, GUI.ACTION.LEFT, 0);
        Assertions.assertEquals(controller.getdirection(), "left");
        Assertions.assertNotNull(controller.getdirection());
        assertEquals(new Position(4, 5), pacman.getPosition());
    }
    @Test
    void movePacman_direction_up() {
        controller.step(game, GUI.ACTION.UP, 0);
        Assertions.assertEquals(controller.getdirection(), "up");
        Assertions.assertNotNull(controller.getdirection());
        assertEquals(new Position(5, 4), pacman.getPosition());
    }
    @Test
    void movePacman_direction_down() {
        controller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertEquals(controller.getdirection(), "down");
        Assertions.assertNotNull(controller.getdirection());
        assertEquals(new Position(5, 6), pacman.getPosition());
    }
    @Test
    void movePacman_Monster_power0(){
        arena.setMonsters(Arrays.asList(new Monster(5,4)));
        pacman.setDirection("up");
        controller.movePacmanUp();
        Assertions.assertEquals(2,pacman.getVidas());
        Assertions.assertEquals(new Position(9,12), pacman.getPosition());
        Assertions.assertEquals("none",pacman.getDirection());
    }
    @Test
    void movePacman_Gate(){
        arena.setGates(Arrays.asList(new Gate(5,4), new Gate(7,8)));
        pacman.setDirection("up");
        controller.movePacmanUp();
        Assertions.assertEquals(new Position(7,8), pacman.getPosition());
    }
}