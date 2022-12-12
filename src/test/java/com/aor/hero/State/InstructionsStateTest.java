package com.aor.hero.State;

import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.Instructions;
import com.aor.hero.states.GameOverState;
import com.aor.hero.states.InstructionsState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstructionsStateTest {
    InstructionsState instructionsstate;
    Instructions instructions_to_set;

    @Test
    void GameOverState_beforeSetstate(){
        Assertions.assertNull(instructionsstate);
    }

    @Test
    void GameOverState_afterSetstate(){
        instructionsstate = new InstructionsState(instructions_to_set);
        Assertions.assertNotNull(instructionsstate);
        Assertions.assertEquals(instructions_to_set, instructionsstate.getModel());
    }
}
