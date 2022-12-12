package com.aor.hero.State;

import com.aor.hero.model.menu.Instructions;
import com.aor.hero.states.InstructionsState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstructionsStateTest {
    InstructionsState instructionsstate;
    Instructions instructions_to_set;

    @Test
    void InstructionsState_beforeSetstate(){
        Assertions.assertNull(instructionsstate);
    }

    @Test
    void InstructionsrState_afterSetstate(){
        instructionsstate = new InstructionsState(instructions_to_set);
        Assertions.assertNotNull(instructionsstate);
        Assertions.assertEquals(instructions_to_set, instructionsstate.getModel());
    }
}
