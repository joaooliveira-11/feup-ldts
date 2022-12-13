package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.controller.PacmanController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.CatchingMonstersArena.CatchingMonstersArenaBuilder;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.arena.LoaderArenaBuilder;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.model.menu.Menu;
import com.aor.hero.states.*;

import java.io.IOException;

public class ArenaController extends GameController {
    private final PacmanNormalController pacmanController;
    private final MonsterNormalController monsterController;

    public ArenaController(Arena arena) {
        super(arena);

        this.pacmanController = new PacmanNormalController(arena);
        this.monsterController = new MonsterNormalController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        int savevidas = getModel().getPacman().getVidas();
        int savepontos = getModel().getPacman().getPontos();
        if (action == GUI.ACTION.QUIT || getModel().getPacman().getVidas() == 0)
            game.setState(new GameOverState(new GameOver()));
        else if(getModel().getPacman().getPontos() > 2500 && getModel().getSuperCoins().size() == 0 && getModel().getCoins().size() == 0 && getModel().getPacman().getVidas() >= 1) {
            game.setState(new GameWinState(new GameWin()));
        }
        else if(getModel().getCoins().size()==0 && getModel().getSuperCoins().size()==0){
            game.setState(new GameState(new LoaderArenaBuilder(2).createArena(savevidas,savepontos)));
        }
        else if(getModel().getPacman().getPowerTime()<0){
            game.setState(new GameState(new LoaderArenaBuilder(1).createArena(savevidas,savepontos,getModel().getWalls(),getModel().getCoins(),getModel().getSuperCoins(),getModel().getGates())));
        }
        else if(getModel().getPacman().getPowerTime()>0){
            game.setState(new CatchingMonstersState(new CatchingMonstersArenaBuilder().createCatchingMonstersArena(savevidas,savepontos,getModel().getPacman(),getModel().getMonsters(),getModel().getWalls(),getModel().getCoins(),getModel().getSuperCoins(),getModel().getGates(),getModel().getPacman().getDirection())));
        }
        else {
            pacmanController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}