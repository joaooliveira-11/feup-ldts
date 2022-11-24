import org.example.Position;
import org.example.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Walltest {
    @Test
    void Wall_GetPosition(){
        Wall wall = new Wall(0,0);
        Assertions.assertNotNull(wall.getPosition());
    }
    @Test
    void Wall_SetPosition(){
        Position position = new Position(3,3);
        Wall wall = new Wall(0,0);
        wall.setPosition(position);
        Assertions.assertEquals(position,wall.getPosition());
        Assertions.assertNotEquals(new Position(4,4),wall.getPosition());
    }
}
