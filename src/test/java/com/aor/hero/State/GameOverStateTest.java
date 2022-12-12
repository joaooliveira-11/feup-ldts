package com.aor.hero.State;

import com.aor.hero.model.menu.GameOver;
import com.aor.hero.states.GameOverState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameOverStateTest {
    GameOverState gameoverstate;
    GameOver gameover_to_set;

    @Test
    void GameOverState_beforeSetstate(){
        Assertions.assertNull(gameoverstate);
    }

    @Test
    void GameOverState_afterSetstate(){
        gameoverstate = new GameOverState(gameover_to_set);
        Assertions.assertNotNull(gameoverstate);
        Assertions.assertEquals(gameover_to_set, gameoverstate.getModel());
    }
}
