package com.aor.hero.controller;

import com.aor.hero.model.Position;

public interface PacmanController {
    public void movePacmanLeft();
    public void movePacmanRight();
    public void movePacmanDown();
    public void movePacmanUp();
    public void movePacman(Position position);
}
