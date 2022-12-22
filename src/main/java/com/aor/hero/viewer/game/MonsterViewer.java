package com.aor.hero.viewer.game;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        if(monster.isRunning()) gui.drawMonsterRunning(monster.getPosition());
        else gui.drawMonsterNormal(monster.getPosition());
    }
}
