package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.viewer.Music;

public class PacmanController extends GameController {
    String direction;

    Music music = new Music();
    public PacmanController(Arena arena) {
        super(arena);
    }
    public void movePacmanLeft() {
        movePacman(getModel().getPacman().getPosition().getLeft());
    }

    public void movePacmanRight() {
        movePacman(getModel().getPacman().getPosition().getRight());
    }

    public void movePacmanUp() {
        movePacman(getModel().getPacman().getPosition().getUp());
    }

    public void movePacmanDown() {
        movePacman(getModel().getPacman().getPosition().getDown());
    }
    private void movePacman(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPacman().setPosition(position);
            if (getModel().isMonster(position)){
                if(getModel().getPacman().getPower() == 0 ||getModel().getPacman().didTimeEnd()){
                    getModel().getPacman().losepower();
                    getModel().getPacman().diminuirVidas();
                    music.startLoseLifeMusic();
                }
                else{
                    getModel().getMonsters().remove(getModel().getMonster(position));
                    music.startKillMonsterMusic();
                    //falta voltar a adicionar
                }

            }
            else if(getModel().isCoin(position)){
                getModel().getPacman().aumentarpontoscoin();
                getModel().getCoins().remove(getModel().getCoin(position));
                music.startCoinMusic();
            }
            else if(getModel().isSuperCoin(position)){
                getModel().getPacman().aumentarpontossupercoin();
                getModel().getPacman().winpower();
                getModel().getPacman().startPowerTime();
                getModel().getSuperCoins().remove(getModel().getSuperCoin(position));
                music.startSuperCoinMusic();
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
