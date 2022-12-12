package com.aor.hero.gui;

import com.aor.hero.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPacman(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawCoin(Position position);

    void drawSupCoin(Position position);

    void drawGate(Position position);

    void drawGate(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
