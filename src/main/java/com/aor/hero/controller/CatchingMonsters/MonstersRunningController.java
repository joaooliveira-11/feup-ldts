package com.aor.hero.controller.CatchingMonsters;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.CatchingMonstersArena.CatchingMonstersArena;
import com.aor.hero.model.game.elements.Monster;
import com.aor.hero.model.game.elements.MonsterRunning;
import com.aor.hero.viewer.Music;

import java.io.IOException;
import java.util.ConcurrentModificationException;

public class MonstersRunningController extends GameController {

    private long lastMovement;

    private Music music=new Music();

    public MonstersRunningController(CatchingMonstersArena model) {

        super(model);
        this.lastMovement=0;
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            this.lastMovement = time;
            try {
                for (MonsterRunning monster : getModel().getMonstersRunning())
                    moveMonster(monster, monster.getPosition().getRandomNeighbour());
            }
            catch (NullPointerException e){}
            catch (ConcurrentModificationException f){}
            try {
                for (Monster monster : getModel().getMonsters())
                    moveMonster(monster, monster.getPosition().getRandomNeighbour());
            }
            catch (NullPointerException e){}
            catch (ConcurrentModificationException f){}
        }
    }

    public void moveMonster(MonsterRunning monster, Position position) {
        if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            if (getModel().getPacman().getPosition().equals(position)) {
                getModel().getMonstersRunning().remove(getModel().getMonsterRunning(position));
                music.startKillMonsterMusic();
                getModel().getMonsters().add(new Monster(10,10));
            }
        }
    }
    public void moveMonster(Monster monster, Position position) {
        if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            if (getModel().getPacman().getPosition().equals(position)) {
                getModel().getPacman().diminuirVidas();
                music.startLoseLifeMusic();
                getModel().getPacman().setPowerTime(-1);
            }
        }
    }
}
