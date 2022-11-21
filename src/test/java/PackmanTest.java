import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Element;
import org.example.Pacman;
import org.example.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackmanTest{
    Element pacman;
    TextGraphics tg;
    TextColor tc;

    @BeforeEach
    public void setUp(){
        pacman = new Pacman(10,10);
        tc = TextColor.Factory.fromString("#FFFF33");
        tg = Mockito.mock(TextGraphics.class);
    }
    @Test
    void moveTest(){
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
    @Test
    void Pacman_GetPosition(){
        Pacman pacman = new Pacman(0,0);
        Assertions.assertNotNull(pacman.getPosition());
    }
    @Test
    void Pacman_SetPosition(){
        Position position = new Position(3,3);
        Pacman pacman = new Pacman(0,0);
        pacman.setPosition(position);
        Assertions.assertEquals(position,pacman.getPosition());
        Assertions.assertNotEquals(new Position(4,4),pacman.getPosition());
    }

    @Test
    public void testEnemyDrawForegroundColor(){
        pacman.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(tc);
    }

}

