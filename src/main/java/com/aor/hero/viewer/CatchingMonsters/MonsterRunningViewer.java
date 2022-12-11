package com.aor.hero.viewer.CatchingMonsters;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.MonsterRunning;
import com.aor.hero.viewer.game.ElementViewer;

public class MonsterRunningViewer implements ElementViewer<MonsterRunning> {
    @Override
    public void draw(MonsterRunning element, GUI gui) {
        gui.drawMonsterRunning(element.getPosition());
    }
}
