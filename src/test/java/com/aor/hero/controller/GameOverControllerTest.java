package com.aor.hero.controller;

import com.aor.hero.Game;
import com.aor.hero.controller.menu.GameOverController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.menu.GameOver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameOverControllerTest {
    GameOverController gameovercontroller;
    GameOver gameOver;
    Game game;

    @BeforeEach
    void setUp() {
        game =  Mockito.mock(Game.class);
        gameOver = new GameOver();
        gameovercontroller = new GameOverController(gameOver);
    }

    @Test
    void GameOverSelectedGiveup() throws IOException {
        gameovercontroller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertNotNull(gameovercontroller.getModel());
        gameovercontroller.step(game, GUI.ACTION.SELECT,0);
        Assertions.assertNotNull(gameOver);
        Assertions.assertNotEquals(null,gameOver.isSelectedGiveUp());
        Assertions.assertEquals(true, gameOver.isSelectedGiveUp());
        Assertions.assertNotEquals(false,gameOver.isSelectedGiveUp());
        Assertions.assertEquals(gameOver,gameovercontroller.getModel());
    }

    @Test
    void GameOverSelectedTryAgain() throws IOException {
        gameovercontroller.step(game, GUI.ACTION.SELECT,0);
        Assertions.assertNotNull(gameovercontroller.getModel());
        Assertions.assertEquals(true,gameOver.isSelectedTryAgain());
        Assertions.assertNotEquals(false,gameOver.isSelectedTryAgain());
        Assertions.assertNotEquals(null,gameOver.isSelectedTryAgain());
        Assertions.assertEquals(gameOver,gameovercontroller.getModel());

    }

    @Test
    void GameOverUpOption() throws IOException {
        gameovercontroller.step(game, GUI.ACTION.UP, 0);
        Assertions.assertNotNull(gameovercontroller.getModel());
        gameOver.previousEntry();
        Assertions.assertNotNull(gameOver);
        Assertions.assertEquals(gameOver, gameovercontroller.getModel());
    }
    @Test
    void GameOverDownOption() throws IOException {
        gameovercontroller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertNotNull(gameovercontroller.getModel());
        gameOver.nextEntry();
        Assertions.assertNotNull(gameOver);
        Assertions.assertEquals(gameOver, gameovercontroller.getModel());
    }
}

