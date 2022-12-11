package com.aor.hero.controller.menu;

import com.aor.hero.Game;
import com.aor.hero.controller.Controller;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.LoaderArenaBuilder;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.Menu;
import com.aor.hero.states.GameState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameover) {
        super(gameover);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedGiveUp()) game.setState(null);
                if (getModel().isSelectedTryAgain()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena(3,0)));
        }
    }
}
