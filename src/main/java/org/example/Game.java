package org.example;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Game {
    private Screen screen;
    Pacman pacman= new Pacman(35,20);

    public Game() {
        try {
            TerminalSize terminalSize = new TerminalSize(70, 100);
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
    }

    public void draw() throws IOException {
        screen.clear();
        pacman.draw(screen.newTextGraphics());
        screen.refresh();

    }

    public void run(){
        boolean flag=true;
        try {
            while (flag) {
                draw();
                switch (screen.readInput().getKeyType()) {
                    case ArrowDown -> pacman.setPosition(pacman.moveDown());
                    case ArrowLeft -> pacman.setPosition(pacman.moveLeft());
                    case ArrowRight -> pacman.setPosition(pacman.moveRight());
                    case ArrowUp -> pacman.setPosition(pacman.moveUp());
                    case Backspace -> {
                        flag = false;
                        screen.close();
                    }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
