package com.aor.hero.viewer;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.*;
import com.aor.hero.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class ArenaViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setWalls(Arrays.asList(new Wall(1, 2), new Wall(2, 3), new Wall(3, 4)));
        arena.setMonsters(Arrays.asList(new Monster(4, 5), new Monster(5, 6)));
        arena.setPacman(new Pacman(5, 8));

        arena.setCoins(Arrays.asList(new Coin(7,8), new Coin(9, 8), new Coin(10, 8)));
        arena.setSuperCoins(Arrays.asList(new SupCoin(7,9), new SupCoin(8, 9), new SupCoin(9, 9)));
    }


    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void drawMonsters() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(4, 5));
        Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(5, 6));
        Mockito.verify(gui, Mockito.times(2)).drawMonster(Mockito.any(Position.class));
    }

    @Test
    void drawHero() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPacman(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawPacman(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

    @Test
    void drawCoins() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(7, 8));
        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(9, 8));
        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(10, 8));
        Mockito.verify(gui, Mockito.times(3)).drawCoin(Mockito.any(Position.class));
    }

    @Test
    void drawSuperCoins() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawSupCoin(new Position(7, 9));
        Mockito.verify(gui, Mockito.times(1)).drawSupCoin(new Position(8, 9));
        Mockito.verify(gui, Mockito.times(1)).drawSupCoin(new Position(9, 9 ));
        Mockito.verify(gui, Mockito.times(3)).drawSupCoin(Mockito.any(Position.class));
    }
}