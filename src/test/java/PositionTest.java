import org.example.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PositionTest {

    @Test
    void Position_setXTest(){
        Position position = new Position(0,0);
        position.setX(2);
        Assertions.assertEquals(2,position.getX());
        Assertions.assertNotEquals(4,position.getX());
    }
    @Test
    void Position_setYTest(){
        Position position = new Position(0,0);
        position.setY(2);
        Assertions.assertEquals(2,position.getY());
        Assertions.assertNotEquals(4,position.getY());
    }

}
