package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Coin;

public class PacmanController extends GameController {
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
                }
                else{
                    getModel().getMonsters().remove(getModel().getMonster(position));
                    //falta voltar a adicionar
                }

            }
            else if(getModel().isCoin(position)){
                getModel().getPacman().aumentarpontoscoin();
                getModel().getCoins().remove(getModel().getCoin(position));
            }
            else if(getModel().isSuperCoin(position)){
                getModel().getPacman().aumentarpontossupercoin();
                getModel().getPacman().winpower();
                getModel().getPacman().startPowerTime();
                getModel().getSuperCoins().remove(getModel().getSuperCoin(position));
            }
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePacmanUp();
        if (action == GUI.ACTION.RIGHT) movePacmanRight();
        if (action == GUI.ACTION.DOWN) movePacmanDown();
        if (action == GUI.ACTION.LEFT) movePacmanLeft();
    }
}
