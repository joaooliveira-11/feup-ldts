package com.aor.hero.controller;

import com.aor.hero.model.Position;
import com.aor.hero.model.game.elements.Monster;

public interface MonsterController<T>{

    public void moveMonster(T monster, Position position);
}
