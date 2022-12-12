package com.aor.hero.viewer;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.menu.Menu;
import com.aor.hero.viewer.menu.MenuViewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MenuViewerTest {
    private MenuViewer menuViewer= new MenuViewer(new Menu());
    private GUI gui = Mockito.mock(GUI.class);

    @Test
    void drawElements() {
        menuViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(5, 5), "Menu", "#FFFFFF");
    }
}
