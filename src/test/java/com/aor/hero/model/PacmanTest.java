package com.aor.hero.model;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Pacman;
import com.aor.hero.viewer.game.HeroViewer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PacmanTest {
    private Pacman pacman;

    @BeforeEach
    void setUp() {
        pacman = new Pacman(10, 10);
    }

    @Test
    void Pacman_getVidas(){
        Assertions.assertNotNull(pacman.getVidas());
    }

    @Test
    void Pacman_getPontos(){
        Assertions.assertNotNull(pacman.getPontos());
    }

    @Test
    void Pacman_aumentarpontoscoin(){
        pacman.aumentarpontoscoin();
        Assertions.assertEquals(10,pacman.getPontos());
        Assertions.assertNotEquals(20,pacman.getPontos());
    }

    @Test
    void Pacman_aumentarpontossupercoin(){
        pacman.aumentarpontossupercoin();
        Assertions.assertEquals(50,pacman.getPontos());
        Assertions.assertNotEquals(100,pacman.getPontos());
    }

    @Test
    void Pacman_diminuirvidas(){
        pacman.diminuirVidas();
        Assertions.assertEquals(2,pacman.getVidas());
        Assertions.assertNotEquals(3,pacman.getVidas());
    }

}
