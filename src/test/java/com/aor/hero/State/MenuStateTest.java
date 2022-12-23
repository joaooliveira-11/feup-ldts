package com.aor.hero.State;
import com.aor.hero.model.menu.Menu;
import com.aor.hero.states.MenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MenuStateTest {
    MenuState menustate;
    Menu menu_to_set;

    @Test
    void get_Controller(){
        menustate = new MenuState(menu_to_set);
        Assertions.assertNotNull(menustate);
    }

    @Test
    void MenuState_beforeSetstate(){
        Assertions.assertNull(menustate);
    }

    @Test
    void MenuState_afterSetstate(){
        menustate = new MenuState(menu_to_set);
        Assertions.assertNotNull(menustate);
        Assertions.assertEquals(menu_to_set, menustate.getModel());
    }
}
