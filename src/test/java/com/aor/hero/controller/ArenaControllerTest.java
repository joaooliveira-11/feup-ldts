package com.aor.hero.controller;
import com.aor.hero.Game;
import com.aor.hero.controller.game.ArenaController;
import com.aor.hero.controller.menu.GameOverController;
import com.aor.hero.controller.menu.GameWinController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.*;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.states.GameOverState;
import com.aor.hero.states.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class ArenaControllerTest {

    private ArenaController arenacontroller;


    private GameState gameState;

    private Arena arena;

    private Game game;

    private GameWin gamewin;

    private GameOver gameover;
    GameOverController gameovercontroller;

    GameWinController gamewincontroller;


    @BeforeEach
    void setUp() {
        game =  Mockito.mock(Game.class);
        arena = new Arena(24,24);
        gamewin = new GameWin();
        gameover = new GameOver();
        arenacontroller = new ArenaController(arena);
        gameovercontroller = new GameOverController(gameover);
        gamewincontroller = new GameWinController(gamewin);
        gameState = new GameState(arena);
        arena.setPacman(new Pacman(12,12));
        arena.setCoins(Arrays.asList(new Coin(1, 2), new Coin(2, 3), new Coin(3, 4)));
        arena.setSuperCoins(Arrays.asList(new SupCoin(7, 7), new SupCoin(8, 8), new SupCoin(9, 9)));
        arena.setGates(Arrays.asList(new Gate(15, 15), new Gate(16, 16)));
        arena.setMonsters(Arrays.asList(new Monster(12, 12), new Monster(13, 13), new Monster(14, 14), new Monster(15,15)));
        arena.setWalls(Arrays.asList(new Wall(19, 19), new Wall(19, 19)));
    }
    @Test
    void Arena_LoseGame() throws IOException {
        Assertions.assertNotNull(gameState.getModel());
        arenacontroller.step(game, GUI.ACTION.QUIT,0);
        game.setState(new GameOverState(new GameOver()));
        Assertions.assertNotNull(gameover);
    }

    @Test
    public void testStepGameWin() throws IOException {
        GUI.ACTION action = GUI.ACTION.UP;
        arenacontroller.getModel().getPacman().setPontos(3251);
        arenacontroller.step(game, action, 0);
        Assertions.assertNotNull(gamewin);
    }
}

