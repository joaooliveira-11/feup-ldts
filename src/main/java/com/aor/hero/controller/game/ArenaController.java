package com.aor.hero.controller.game;
import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.arena.LoaderArenaBuilder;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.states.GameOverState;
import com.aor.hero.states.GameState;
import com.aor.hero.states.GameWinState;
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
            game.setState(new GameOverState(new GameOver()));
        }
        else if(getModel().getPacman().getPontos() > 2500 && getModel().getSuperCoins().size() == 0 && getModel().getCoins().size() == 0 && getModel().getPacman().getVidas() >= 1){
            game.setState(new GameWinState(new GameWin()));
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