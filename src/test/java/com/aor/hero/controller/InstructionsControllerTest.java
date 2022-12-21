package com.aor.hero.controller;

import com.aor.hero.Game;
import com.aor.hero.controller.menu.GameOverController;
import com.aor.hero.controller.menu.GameWinController;
import com.aor.hero.controller.menu.InstructionsController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.model.menu.Instructions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class InstructionsControllerTest {
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
        instructionsrcontroller.step(game, GUI.ACTION.SELECT,0);
        Assertions.assertNotNull(instructionsrcontroller.getModel());
        instructions.isSelectedReturn();
        Assertions.assertEquals(instructions,instructionsrcontroller.getModel());
    }
}
