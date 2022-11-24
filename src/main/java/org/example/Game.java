package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import javax.imageio.ImageIO;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Game {
    private Screen screen;
    private Game_map game_map;

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(19, 22);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            ((SwingTerminalFrame) terminal).setTitle("PACKMAN");
            //((AWTTerminalFrame) terminal).setIconImage(ImageIO.read(getClass().getClassLoader().getResource("../docs/packman.png")));
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
        } catch (IOException e) {
            e.printStackTrace();
        }
        game_map = new Game_map(19, 22);
    }

    public void draw() throws IOException {
        screen.clear();
        game_map.draw(screen.newTextGraphics());
        screen.refresh();

    }

    private void read_input(KeyStroke input) {
        System.out.println(input);
    }

    public void run() {
        boolean flag = true;
        try {
            while (flag) {
                draw();
                KeyStroke input = screen.readInput();
                read_input(input);
                flag = game_map.movePacman(input);
                game_map.moveMonsters();
            }
            screen.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void map1_builder() throws FileNotFoundException {
        Map_Reader map_reader = new Map_Reader();
        map_reader.MAP1_READER();
    }
}
