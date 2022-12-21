package com.aor.hero.controller;

import com.aor.hero.controller.game.PacmanController;
import com.aor.hero.controller.game.PacmanController;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Pacman;
import com.aor.hero.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PacmanControllerTest {
    private PacmanController controller;
    private Pacman pacman;
    private Arena arena;

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
    void moveHeroRightEmpty() {
        controller.movePacmanRight();
        assertEquals(new Position(6, 5), pacman.getPosition());
    }

    @Test
    void moveHeroRightNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.movePacmanRight();
        assertEquals(new Position(5, 5), pacman.getPosition());
    }
}