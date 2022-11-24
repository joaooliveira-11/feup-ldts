package org.example;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;


public class Monster extends Element {

    public Monster(int x, int y) {
        super(x, y);
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
    @Override
    public Position getPosition() {
        return position;
    }

    public Position move() {
        Random r = new Random();
        int x=r.nextInt(4 - 1) + 1;
        switch (x) {
            case 1:
                position= new Position(position.getX(), position.getY() - 1);
                break;
            case 2:
                position= new Position(position.getX(), position.getY() + 1);
                break;
            case 3:
                position= new Position(position.getX()+1, position.getY());
                break;
            case 4:
                position= new Position(position.getX()-1, position.getY());
                break;
            default:
                position=null;
                break;
        }
        return position;
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.ANSI.GREEN);
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "&");
    }
}
