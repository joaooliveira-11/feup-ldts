package com.aor.hero.controller.menu;
import com.aor.hero.Game;
import com.aor.hero.controller.Controller;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.LoaderArenaBuilder;
import com.aor.hero.model.menu.Instructions;
import com.aor.hero.model.menu.Menu;
import com.aor.hero.states.GameState;
import com.aor.hero.states.MenuState;

import java.io.IOException;

public class InstructionsController extends Controller<Instructions>{
    public InstructionsController(Instructions instructions) {
        super(instructions);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SELECT:
                if (getModel().isSelectedReturn()) game.setState(new MenuState(new Menu()));
        }
    }
}
