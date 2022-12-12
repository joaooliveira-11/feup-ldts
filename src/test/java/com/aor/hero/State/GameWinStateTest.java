package com.aor.hero.State;

import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.states.GameOverState;
import com.aor.hero.states.GameWinState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameWinStateTest {
    GameWinState gamewinstate;
    GameWin gamewin_to_set;

    @Test
    void GameWinState_beforeSetstate(){
        Assertions.assertNull(gamewinstate);
    }

    @Test
    void GameWinState_afterSetstate(){
        gamewinstate = new GameWinState(gamewin_to_set);
        Assertions.assertNotNull(gamewinstate);
        Assertions.assertEquals(gamewin_to_set, gamewinstate.getModel());
    }
}
