package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Gate;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.viewer.Music;

public class PacmanNormalController extends GameController {
    Music music=new Music();
    String direction;
    public PacmanNormalController(Arena arena) {
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
        Position p = new Position(9,8);
        if (getModel().isEmpty(position) && (!(position.equals(p)))) {
            getModel().getPacman().setPosition(position);
            if (getModel().isMonster(position)) {
                getModel().getPacman().diminuirVidas();
                music.startLoseLifeMusic();
            } else if (getModel().isCoin(position)) {
                getModel().getPacman().aumentarpontoscoin();
                getModel().getCoins().remove(getModel().getCoin(position));
                music.startCoinMusic();
            } else if (getModel().isSuperCoin(position)) {
                getModel().getPacman().aumentarpontossupercoin();
                getModel().getPacman().setPowerTime(getModel().getPacman().getPowerTime() + System.currentTimeMillis());
                getModel().getSuperCoins().remove(getModel().getSuperCoin(position));
                music.startSuperCoinMusic();
            } else if (getModel().isGate(position)) {
                for (Gate gate : getModel().getGates()) {
                    if (!gate.getPosition().equals(position)) {
                        Position position2 = new Position(gate.getPosition().getX(), gate.getPosition().getY());
                        getModel().getPacman().setPosition(position2);
                    }
                }
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
