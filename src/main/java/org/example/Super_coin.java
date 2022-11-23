package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Super_coin extends Element{
    public Super_coin(int x, int y) {
        super(x, y);
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.ANSI.YELLOW_BRIGHT);
        graphics.setForegroundColor(TextColor.ANSI.YELLOW_BRIGHT);
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "O");
    }
}
