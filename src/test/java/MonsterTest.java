import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.Element;
import org.example.Monster;
import org.example.Pacman;
import org.example.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest{
    Monster monster = new Monster(10,10);
    TextGraphics tg;
    TextColor tc;

    @BeforeEach
    public void setUp(){
        tc = TextColor.ANSI.GREEN;
        tg = Mockito.mock(TextGraphics.class);
    }
    @Test
    void moveTest(){
        Monster test= new Monster(10,10);
        monster.setPosition(monster.move());
        assertEquals(1,Math.abs(monster.getPosition().getY()-test.getPosition().getY())+(monster.getPosition().getX()-test.getPosition().getX()));
        monster.setPosition(monster.move());
        assertTrue(((Math.abs(monster.getPosition().getY()-test.getPosition().getY())+(monster.getPosition().getX()-test.getPosition().getX()))<=2)
                && ((Math.abs(monster.getPosition().getY()-test.getPosition().getY())+(monster.getPosition().getX()-test.getPosition().getX()))>=0));
    }
    @Test
    void Monster_GetPosition(){
        Assertions.assertNotNull(monster.getPosition());
    }
    @Test
    void Monster_SetPosition(){
        Position position = new Position(3,3);
        monster.setPosition(position);
        Assertions.assertEquals(position,monster.getPosition());
    }
}
