package com.aor.hero.controller.CatchingMonsters;

import com.aor.hero.Game;
import com.aor.hero.controller.Controller;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.CatchingMonstersArena.CatchingMonstersArena;

import java.io.IOException;

abstract class GameController extends Controller<CatchingMonstersArena> {

    public GameController(CatchingMonstersArena model) {
        super(model);
    }

}
