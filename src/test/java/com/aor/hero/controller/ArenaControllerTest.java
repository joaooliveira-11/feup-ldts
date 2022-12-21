package com.aor.hero.controller;

import com.aor.hero.Game;
import com.aor.hero.controller.game.ArenaController;
import com.aor.hero.controller.game.GameController;
import com.aor.hero.controller.menu.GameOverController;
import com.aor.hero.controller.menu.GameWinController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Coin;
import com.aor.hero.model.game.elements.Pacman;
import com.aor.hero.model.game.elements.SupCoin;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.states.GameOverState;
import com.aor.hero.states.GameState;
import com.aor.hero.states.GameWinState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class ArenaControllerTest {

    private ArenaController arenacontroller;

    private GameController gamecontroller;

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
    }
    @Test
    void Arena_LoseGame() throws IOException {
        Assertions.assertNotNull(gameState.getModel());
        arenacontroller.step(game, GUI.ACTION.QUIT,0);
        game.setState(new GameOverState(new GameOver()));
        Assertions.assertNotNull(gameover);
    }
    /*
    @Test
    void Arena_WinGame() throws IOException {
        Position position1 = new Position(1,2);
        Position position2 = new Position(2,3);
        Position position3 = new Position(3,4);
        Position position4 = new Position(7,7);
        Position position5 = new Position(8,8);
        Position position6 = new Position(9,9);
        Assertions.assertNotNull(gameState.getModel());
        arena.getCoins().remove(arena.getCoin(position1));
        arena.getCoins().remove(arena.getCoin(position2));
        arena.getCoins().remove(arena.getCoin(position3));
        arena.getSuperCoins().remove(arena.getSuperCoin(position4));
        arena.getSuperCoins().remove(arena.getSuperCoin(position5));
        arena.getSuperCoins().remove(arena.getSuperCoin(position6));
        arena.getPacman().setPontos(2500);
        game.setState(new GameWinState(new GameWin()));
        Assertions.assertNotNull(gamewin);
    }
     */

}
