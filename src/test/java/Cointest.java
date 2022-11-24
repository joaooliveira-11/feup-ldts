import org.example.Coin;
import org.example.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Cointest {
    @Test
    void Coin_GetPosition(){
        Coin coin = new Coin(0,0);
        Assertions.assertNotNull(coin.getPosition());
    }
    @Test
    void Coin_SetPosition(){
        Position position = new Position(3,3);
        Coin coin = new Coin(0,0);
        coin.setPosition(position);
        Assertions.assertEquals(position,coin.getPosition());
        Assertions.assertNotEquals(new Position(4,4),coin.getPosition());
    }
}
