package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.arena.LoaderArenaBuilder;
import com.aor.hero.model.menu.Menu;
import com.aor.hero.states.GameState;
import com.aor.hero.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final PacmanController pacmanController;
    private final MonsterController monsterController;

    public ArenaController(Arena arena) {
        super(arena);

        this.pacmanController = new PacmanController(arena);
        this.monsterController = new MonsterController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getPacman().getVidas() == 0) {
            Menu menu = new Menu();
            menu.setMenuToGameOverMenu();
            game.setState(new MenuState(menu));
        }
        else if(getModel().getSuperCoins().size() == 0 && getModel().getCoins().size() == 0 && getModel().getPacman().getVidas() >= 1){
            int savepontos  = getModel().getPacman().getPontos();
            int savevidas  =  getModel().getPacman().getVidas();
            game.setState(new GameState(new LoaderArenaBuilder(2).createArena(savevidas, savepontos)));
        }
        else {
            pacmanController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}