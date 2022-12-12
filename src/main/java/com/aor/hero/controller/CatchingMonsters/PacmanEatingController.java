package com.aor.hero.controller.CatchingMonsters;

import com.aor.hero.Game;
import com.aor.hero.controller.PacmanController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.CatchingMonstersArena.CatchingMonstersArena;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.viewer.Music;

import java.io.IOException;

public class PacmanEatingController extends GameController implements PacmanController {

    Music music=new Music();

    String direction;
    PacmanEatingController(CatchingMonstersArena arena){
        super(arena);
    }

    @Override
    public void movePacmanLeft() {movePacman(getModel().getPacman().getPosition().getLeft());}

    @Override
    public void movePacmanRight() {movePacman(getModel().getPacman().getPosition().getRight());}

    @Override
    public void movePacmanDown() {movePacman(getModel().getPacman().getPosition().getDown());}

    @Override
    public void movePacmanUp() {movePacman(getModel().getPacman().getPosition().getUp());}

    @Override
    public void movePacman(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPacman().setPosition(position);
            if (getModel().isMonsterRunning(position)){
                getModel().getMonstersRunning().remove(getModel().getMonsterRunning(position));
                music.startKillMonsterMusic();
                getModel().getMonsters().add(new Monster(9,9));
            }
            if (getModel().isMonster(position)){
                getModel().getPacman().diminuirVidas();
            }
            else if(getModel().isCoin(position)){
                getModel().getPacman().aumentarpontoscoin();
                getModel().getCoins().remove(getModel().getCoin(position));
            }
            else if(getModel().isSuperCoin(position)){
                getModel().getPacman().aumentarpontossupercoin();
                getModel().getPacman().setPowerTime(getModel().getPacman().getPowerTime()+System.currentTimeMillis());
                getModel().getSuperCoins().remove(getModel().getSuperCoin(position));
            }
        }
    }
    public void setdirection(String direction1) {
        this.direction = direction1;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) setdirection("up");
        if (action == GUI.ACTION.RIGHT) setdirection("right");
        if (action == GUI.ACTION.DOWN) setdirection("down");
        if (action == GUI.ACTION.LEFT) setdirection("left");
        if(direction == "up") movePacmanUp();
        if(direction == "down") movePacmanDown();
        if(direction == "right") movePacmanRight();
        if(direction == "left") movePacmanLeft();
    }
}