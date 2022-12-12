package com.aor.hero.controller;
import com.aor.hero.Game;
import com.aor.hero.controller.menu.MenuController;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuControllerTest {
    MenuController menucontroller;
    Menu menu;
    Game game;

    @BeforeEach
    void setUp() {
        game =  Mockito.mock(Game.class);
        menu = new Menu();
        menucontroller = new MenuController(menu);
    }

    @Test
    void GameOverSelectedInstructions() throws IOException {
        menucontroller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertNotNull(menucontroller.getModel());
        menucontroller.step(game, GUI.ACTION.SELECT,0);
        menu.nextEntry();
        Assertions.assertNotNull(menu);
        menu.isSelectedInstructions();
        Assertions.assertEquals(menu,menucontroller.getModel());
    }

    @Test
    void GameOverSelectedStartGame() throws IOException {
        menucontroller.step(game, GUI.ACTION.SELECT,0);
        Assertions.assertNotNull(menucontroller.getModel());
        menu.isSelectedStart();
        Assertions.assertEquals(menu,menucontroller.getModel());
        menucontroller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertNotNull(menucontroller.getModel());
        menucontroller.step(game, GUI.ACTION.SELECT,0);
        menu.nextEntry();
        Assertions.assertNotNull(menu);
        menu.isSelectedInstructions();
        Assertions.assertEquals(menu,menucontroller.getModel());
    }

    @Test
    void GameOverSelectedExit() throws IOException {
        menucontroller.step(game, GUI.ACTION.SELECT,0);
        Assertions.assertNotNull(menucontroller.getModel());
        menu.isSelectedStart();
        Assertions.assertEquals(menu,menucontroller.getModel());
        menucontroller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertNotNull(menucontroller.getModel());
        menucontroller.step(game, GUI.ACTION.SELECT,0);
        menu.nextEntry();
        Assertions.assertNotNull(menu);
        menu.isSelectedInstructions();
        Assertions.assertEquals(menu,menucontroller.getModel());
        menucontroller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertNotNull(menucontroller.getModel());
        menucontroller.step(game, GUI.ACTION.SELECT,0);
        Assertions.assertNotNull(menucontroller.getModel());
        menu.nextEntry();
        Assertions.assertNotNull(menu);
        menu.isSelectedExit();
        Assertions.assertEquals(menu,menucontroller.getModel());
    }
    @Test
    void MenuUpOption() throws IOException {
        menucontroller.step(game, GUI.ACTION.UP, 0);
        Assertions.assertNotNull(menucontroller.getModel());
        menu.previousEntry();
        Assertions.assertNotNull(menu);
        Assertions.assertEquals(menu, menucontroller.getModel());
    }
    @Test
    void MenuDownOption() throws IOException {
        menucontroller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertNotNull(menucontroller.getModel());
        menu.nextEntry();
        Assertions.assertNotNull(menu);
        Assertions.assertEquals(menu, menucontroller.getModel());
    }
}
