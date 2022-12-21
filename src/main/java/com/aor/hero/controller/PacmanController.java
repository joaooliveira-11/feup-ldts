package com.aor.hero.controller;

import com.aor.hero.model.Position;

public interface PacmanController {
    void movePacmanLeft();
    void movePacmanRight();
    void movePacmanDown();
    void movePacmanUp();
    void movePacman(Position position);
}
