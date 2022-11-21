import org.example.Pacman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tester {
    @Test
    void move(){
        Pacman pacman = new Pacman(0,0);
        pacman.setPosition(pacman.moveUp());
        pacman.setPosition(pacman.moveUp());
        pacman.setPosition(pacman.moveLeft());
        assertEquals(-1,pacman.getPosition().getX());
        assertEquals(-2,pacman.getPosition().getY());
        pacman.setPosition(pacman.moveRight());
        pacman.setPosition(pacman.moveLeft());
        pacman.setPosition(pacman.moveRight());
        pacman.setPosition(pacman.moveDown());
        pacman.setPosition(pacman.moveDown());
        assertEquals(0,pacman.getPosition().getX());
        assertEquals(0,pacman.getPosition().getY());
    }
}
