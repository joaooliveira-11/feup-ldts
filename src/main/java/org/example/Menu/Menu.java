package org.example.Menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public abstract class Menu {
    private TerminalScreen screen;
    private String input;
    public Menu(TerminalScreen screen){
        this.screen = screen;
    }
    private void draw() throws IOException {
        screen.clear();
        screen.refresh();
    }
    /*
    public void processKey(KeyStroke key) throws InterruptedException {
        screen.processKey(key);
    }
    */
}

