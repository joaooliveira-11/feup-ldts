package com.aor.hero.states;

import com.aor.hero.controller.CatchingMonsters.CatchingMonstersController;
import com.aor.hero.controller.Controller;
import com.aor.hero.model.game.CatchingMonstersArena.CatchingMonstersArena;
import com.aor.hero.viewer.CatchingMonsters.CatchingMonstersViewer;
import com.aor.hero.viewer.Viewer;

public class CatchingMonstersState extends State<CatchingMonstersArena> {

    public CatchingMonstersState(CatchingMonstersArena model) {
        super(model);
    }

    @Override
    protected Viewer<CatchingMonstersArena> getViewer() {
        return new CatchingMonstersViewer(getModel());
    }

    @Override
    protected Controller<CatchingMonstersArena> getController() {
        return new CatchingMonstersController(getModel());
    }
}
