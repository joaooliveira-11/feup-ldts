package com.aor.hero.controller;
import com.aor.hero.Game;;
import com.aor.hero.controller.menu.InstructionsController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.menu.Instructions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class  InstructionsControllerTest {
    InstructionsController instructionsrcontroller;
    Instructions instructions;
    Game game;

    @BeforeEach
    void setUp() {
        game =  Mockito.mock(Game.class);
        instructions = new Instructions();
        instructionsrcontroller = new InstructionsController(instructions);
    }

    @Test
    void InstructionsSelectedReturn() throws IOException {
        Assertions.assertNotEquals(instructions, instructionsrcontroller);
        instructionsrcontroller.step(game, GUI.ACTION.SELECT,0);
        Assertions.assertNotEquals(instructions.isSelectedReturn(), false);
        Assertions.assertNotNull(instructionsrcontroller.getModel());
        Assertions.assertEquals(true,instructions.isSelectedReturn());
        Assertions.assertNotEquals(false,instructions.isSelectedReturn());
        Assertions.assertEquals(instructions,instructionsrcontroller.getModel());
    }
}