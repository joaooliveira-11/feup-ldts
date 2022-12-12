package com.aor.hero.controller;

import com.aor.hero.Game;
import com.aor.hero.controller.menu.GameOverController;
import com.aor.hero.model.menu.GameOver;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

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

}
