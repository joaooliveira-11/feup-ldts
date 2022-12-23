package com.aor.hero.controller.menu;

import com.aor.hero.Game;
import com.aor.hero.controller.Controller;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.LoaderArenaBuilder;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.states.GameState;

import java.io.IOException;

public class GameWinController extends Controller<GameWin> {
    public GameWinController(GameWin gamewin) {
        super(gamewin);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedTryBetterScore())
                    game.setState(new GameState(new LoaderArenaBuilder(1).createArena(3, 0)));
            }
        }
    }
}
