package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.controller.MonsterController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Monster;

import java.io.IOException;

public class MonsterNormalController extends GameController implements MonsterController<Monster> {
    private long lastMovement;

    public MonsterNormalController(Arena arena) {
        super(arena);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters())
                moveMonster(monster, monster.getPosition().getRandomNeighbour());
            this.lastMovement = time;
        }
    }
    @Override
    public void moveMonster(Monster monster, Position position) {
        if (getModel().isEmpty(position)) {
            monster.setPosition(position);
            if (getModel().getPacman().getPosition().equals(position))
                getModel().getPacman().diminuirVidas();
            }
        }
    }