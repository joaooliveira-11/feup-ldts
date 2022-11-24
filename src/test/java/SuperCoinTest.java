import org.example.Position;
import org.example.Super_coin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SuperCoinTest {
    @Test
    void SuperCoin_GetPosition(){
        Super_coin supercoin = new Super_coin(0,0);
        Assertions.assertNotNull(supercoin.getPosition());
    }
    @Test
    void SuperCoin_SetPosition(){
        Position position = new Position(3,3);
        Super_coin supercoin = new Super_coin(0,0);
        supercoin.setPosition(position);
        Assertions.assertEquals(position,supercoin.getPosition());
        Assertions.assertNotEquals(new Position(4,4),supercoin.getPosition());
    }
}
