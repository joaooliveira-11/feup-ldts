package com.aor.hero.controller;
import com.aor.hero.Game;
import com.aor.hero.controller.menu.GameWinController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.menu.GameWin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameWinControllerTest {
    GameWinController gamewincontroller;
    GameWin gamewin;
    Game game;

    @BeforeEach
    void setUp() {
        game =  Mockito.mock(Game.class);
        gamewin = new GameWin();
        gamewincontroller = new GameWinController(gamewin);
    }

    @Test
    void GameWinDownOption() throws IOException {
        gamewincontroller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertNotNull(gamewincontroller.getModel());
        gamewin.nextEntry();
        gamewincontroller.step(game, GUI.ACTION.SELECT,0);
        Assertions.assertNotEquals(true, gamewin.isSelectedExit());
        Assertions.assertNotEquals(null,gamewin.isSelectedExit());
        Assertions.assertFalse(gamewin.isSelectedExit());
        Assertions.assertTrue(gamewin.isSelectedTryBetterScore());
        Assertions.assertNotEquals(null,gamewin.isSelectedTryBetterScore());
        Assertions.assertNotNull(gamewin);
        Assertions.assertEquals(gamewin, gamewincontroller.getModel());
    }

    @Test
    void GameWinUpOption() throws IOException {
        gamewincontroller.step(game, GUI.ACTION.UP, 0);
        Assertions.assertNotNull(gamewincontroller.getModel());
        gamewin.previousEntry();
        Assertions.assertNotNull(gamewin);
        Assertions.assertNotEquals(true, gamewin.isSelectedExit());
        Assertions.assertNotEquals(null,gamewin.isSelectedExit());
        Assertions.assertFalse(gamewin.isSelectedExit());
        Assertions.assertTrue(gamewin.isSelectedTryBetterScore());
        Assertions.assertNotEquals(false, gamewin.isSelectedTryBetterScore());
        Assertions.assertNotEquals(null,gamewin.isSelectedTryBetterScore());
        Assertions.assertEquals(gamewin, gamewincontroller.getModel());
    }

    @Test
    void GameOverSelectedTryAgain() throws IOException {
        gamewincontroller.step(game, GUI.ACTION.SELECT,0);
        Assertions.assertNotNull(gamewincontroller.getModel());
        Assertions.assertTrue(gamewin.isSelectedTryBetterScore());
        Assertions.assertNotEquals(false,gamewin.isSelectedTryBetterScore());
        Assertions.assertNotEquals(null,gamewin.isSelectedTryBetterScore());
        Assertions.assertEquals(gamewin, gamewincontroller.getModel());
        gamewincontroller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertNotNull(gamewincontroller.getModel());
        gamewincontroller.step(game, GUI.ACTION.SELECT,0);
        Assertions.assertNotNull(gamewincontroller.getModel());
        gamewin.nextEntry();
        Assertions.assertNotNull(gamewin);
        Assertions.assertEquals(gamewin,gamewincontroller.getModel());
    }
    @Test
    void GameOverSelectedExit() throws IOException {
        gamewincontroller.step(game, GUI.ACTION.DOWN, 0);
        gamewin.nextEntry();
        Assertions.assertNotNull(gamewincontroller.getModel());
        gamewincontroller.step(game, GUI.ACTION.SELECT,0);
        gamewin.nextEntry();
        Assertions.assertNotNull(gamewincontroller.getModel());
        Assertions.assertNotNull(gamewin);
        Assertions.assertTrue(gamewin.isSelectedExit());
        Assertions.assertNotEquals(null,gamewin.isSelectedExit());
        Assertions.assertEquals(gamewin,gamewincontroller.getModel());
    }

}
