import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.example.Game;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class GameTest {
    @Test
    public void gameTest() {
        Game game = new Game();
        try {
            TerminalScreen screen = (TerminalScreen) Mockito.mock(TerminalScreen.class);
            TextGraphics graphics = (TextGraphics) Mockito.mock(TextGraphics.class);
            Mockito.when(screen.newTextGraphics()).thenReturn(graphics);
            Mockito.when(graphics.putString(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyString())).thenReturn(graphics);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
