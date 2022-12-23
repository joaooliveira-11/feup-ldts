package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Gate;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.viewer.Music;

import java.io.IOException;

public class MonsterController extends GameController {
    private long lastMovement;

    Music music=new Music();

    public MonsterController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters()){
                while(!(moveMonster(monster, monster.getPosition().getRandomNeighbour())));
            }
            this.lastMovement = time;
        }
    }

    private boolean moveMonster(Monster monster, Position position) {
        if (getModel().isGate(position)){
            for(Gate gate : getModel().getGates()){
                if(!gate.getPosition().equals(position)){
                    if(monster.getPosition().getX()<gate.getPosition().getX()) {
                        monster.setPosition(new Position(gate.getPosition().getX()-1, gate.getPosition().getY()));
                    }
                    else
                        monster.setPosition(new Position(gate.getPosition().getX()+1, gate.getPosition().getY()));
                }
            }
            return true;
        }
        else if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            if (getModel().getPacman().getPosition().equals(position)) {
                if (!(getModel().getMonster(position).isRunning())) {
                        getModel().getPacman().diminuirVidas();
                        music.startLoseLifeMusic();
                        getModel().getPacman().setPosition(new Position(9, 12));
                        getModel().getPacman().setDirection("none");
                    } else {
                        music.startKillMonsterMusic();
                        getModel().getMonster(position).setRunningState(false);
                        getModel().getMonster(position).setPosition(new Position(9, 9));
                        getModel().getPacman().aumentarpontosmonstro();
                    }
                }
                return true;

        }
        return false;
    }
}