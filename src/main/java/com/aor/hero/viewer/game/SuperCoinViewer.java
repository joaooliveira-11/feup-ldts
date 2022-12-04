package com.aor.hero.viewer.game;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.SupCoin;

public class SuperCoinViewer implements ElementViewer<SupCoin> {
    @Override
    public void draw(SupCoin supercoin, GUI gui) {
        gui.drawSupCoin(supercoin.getPosition());
    }
}
