package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Gate;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.viewer.Music;
import com.aor.hero.viewer.game.MonsterViewer;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class PacmanController extends GameController {
    String direction;
    MonsterViewer monsterViewer = new MonsterViewer();

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
                if(!(getModel().getMonster(position).isRunning())){
                    getModel().getPacman().diminuirVidas();
                    music.startLoseLifeMusic();
                    getModel().getPacman().setPosition(new Position(9,12));
                    getModel().getPacman().setDirection("none");
                }
                else{
                    music.startKillMonsterMusic();
                    getModel().getMonsters().remove(getModel().getMonster(position));
                    getModel().getMonsters().add(new Monster(9,9));
                    getModel().getPacman().aumentarpontosmonstro();
                }

            }
            else if(getModel().isCoin(position)){
                getModel().getPacman().aumentarpontoscoin();
                getModel().getCoins().remove(getModel().getCoin(position));
                music.startCoinMusic();
            }
            else if(getModel().isSuperCoin(position)){
                getModel().getPacman().aumentarpontossupercoin();
                for(Monster monster:getModel().getMonsters()) monster.setRunningState(true);
                getModel().getPacman().startPowerTime();
                getModel().getSuperCoins().remove(getModel().getSuperCoin(position));
                music.startSuperCoinMusic();
            }
            else if(getModel().isGate(position)){
                for(Gate gate : getModel().getGates()){
                    if(!gate.getPosition().equals(position)){
                        Position position2 = new Position(gate.getPosition().getX(), gate.getPosition().getY());
                        getModel().getPacman().setPosition(position2);
                    }
                }
            }
        }
        else getModel().getPacman().setDirection("none");
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
