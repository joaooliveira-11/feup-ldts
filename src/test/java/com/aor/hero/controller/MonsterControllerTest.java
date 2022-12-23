package com.aor.hero.controller;

import com.aor.hero.Game;
import com.aor.hero.controller.game.MonsterController;
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
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MonsterControllerTest {
    private MonsterController controller;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        Pacman pacman = new Pacman(5, 5);
        arena.setPacman(pacman);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arena.setGates(Arrays.asList());

        controller = new MonsterController(arena);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveMonsters() throws IOException {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));

        controller.step(game, GUI.ACTION.NONE, 1000);

        assertNotEquals(new Position(5, 5), monster.getPosition());
    }

    @Test
    void moveMonstersClosed() throws IOException {
        Monster monster = new Monster(5, 5);
        List<Gate> gates = new ArrayList<>();
        arena.setMonsters(Arrays.asList(monster));
        arena.setGates(gates);
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4),
                new Wall(5,7),
                new Wall(6,6),
                new Wall(4,6)
        ));

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 501+i*501);
        assertEquals(new Position(5, 5), monster.getPosition());
        for (int i=0;i<11;i++)
            controller.step(game,GUI.ACTION.NONE,501+i*501);
        assertEquals(new Position(5,6),monster.getPosition());
    }

    @Test
    void moveMonstersGap() throws IOException {
        Monster monster = new Monster(5, 5);
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4)
        ));

        long time = 0;

        while (monster.getPosition().equals(new Position(5, 5))) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }

        assertEquals(new Position(5, 6), monster.getPosition());
    }
    @Test
    void moveMonstersGate() throws IOException {
        Position position = new Position(5,5);
        Monster monster = new Monster(position.getX(), position.getY());
        arena.setMonsters(Arrays.asList(monster));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4)
        ));
        arena.setGates(Arrays.asList(
                new Gate(8, 8),
                new Gate(5, 6)
        ));

        controller.step(game, GUI.ACTION.NONE, 1000);
        Position expected=new Position(8,8);
        Assertions.assertEquals((expected.getX()-monster.getPosition().getX())+(expected.getY()-monster.getPosition().getY()),1);
        Assertions.assertEquals(expected.getX()-monster.getPosition().getX(),1);
    }
}