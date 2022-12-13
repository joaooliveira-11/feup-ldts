package com.aor.hero.controller.CatchingMonsters;

import com.aor.hero.Game;
import com.aor.hero.controller.Controller;
import com.aor.hero.controller.CatchingMonsters.GameController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.CatchingMonstersArena.CatchingMonstersArena;
import com.aor.hero.model.game.CatchingMonstersArena.CatchingMonstersArenaBuilder;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.arena.LoaderArenaBuilder;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.model.menu.Menu;
import com.aor.hero.states.*;
import com.aor.hero.viewer.CatchingMonsters.CatchingMonstersViewer;

import java.io.IOException;
public class CatchingMonstersController extends GameController {
    private final PacmanEatingController pacmanController;
    private final MonstersRunningController monsterController;

    public CatchingMonstersController(CatchingMonstersArena arena) {

        super(arena);
        this.pacmanController = new PacmanEatingController(arena);
        this.monsterController = new MonstersRunningController(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        long time_left =System.currentTimeMillis();
        int savevidas = getModel().getPacman().getVidas();
        int savepontos = getModel().getPacman().getPontos();
        if (action == GUI.ACTION.QUIT || getModel().getPacman().getVidas() == 0)
            game.setState(new GameOverState(new GameOver()));
        else if(getModel().getPacman().getPontos() > 2500 && getModel().getSuperCoins().size() == 0 && getModel().getCoins().size() == 0 && getModel().getPacman().getVidas() >= 1) {
            game.setState(new GameWinState(new GameWin()));
        }
        else if(getModel().getCoins().size()==0 && getModel().getSuperCoins().size()==0){
            game.setState(new GameState(new LoaderArenaBuilder(1).createArena(savevidas,savepontos)));
        }
        else if(getModel().getPacman().didTimeEnd()){
            game.setState(new GameState(new LoaderArenaBuilder(1).createArena(savevidas,savepontos,getModel().getPacman(),getModel().getMonsters(),getModel().getMonstersRunning(),getModel().getWalls(),getModel().getCoins(),getModel().getSuperCoins(),getModel().getGates())));
            getModel().getPacman().setPowerTime(0);
        }
        else if(getModel().getPacman().getPowerTime()<0){
            game.setState(new GameState(new LoaderArenaBuilder(1).createArena(savevidas,savepontos,getModel().getWalls(),getModel().getCoins(),getModel().getSuperCoins(),getModel().getGates())));
        }
        else if(getModel().getPacman().getPowerTime()>=time_left){
            getModel().setMonstersRunning(getModel().switchToMonstersRunning(getModel().getMonsters()));
            getModel().getPacman().setPowerTime(System.currentTimeMillis());
        }
        else {
            pacmanController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}