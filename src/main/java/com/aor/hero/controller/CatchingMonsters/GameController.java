package com.aor.hero.controller.CatchingMonsters;

import com.aor.hero.controller.Controller;
import com.aor.hero.model.game.CatchingMonstersArena.CatchingMonstersArena;
import com.aor.hero.model.game.arena.Arena;

public abstract class GameController extends Controller<CatchingMonstersArena> {
    public GameController(CatchingMonstersArena arena) {
        super(arena);
    }
}
