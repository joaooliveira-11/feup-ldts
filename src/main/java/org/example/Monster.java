package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;


public class Monster extends Element {
    private Position position;

    public Monster(int x, int y) {
        super(x, y);
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
    public Position getPosition() {
        return position;
    }

    public Position move() {
        Random r = new Random();
        Position ans;
        switch (r.nextInt(4 - 1) + 1) {
            case 1:
                ans= new Position(position.getX(), position.getY() - 1);
            case 2:
                ans= new Position(position.getX(), position.getY() + 1);
            case 3:
                ans= new Position(position.getX()+1, position.getY());
            case 4:
                ans= new Position(position.getX()-1, position.getY());
            default:
                ans=null;
        }
        return ans;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.ANSI.GREEN);
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "#");
    }
}
