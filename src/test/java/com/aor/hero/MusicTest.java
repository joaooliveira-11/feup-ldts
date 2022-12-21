package com.aor.hero;
import com.aor.hero.model.game.elements.Pacman;
import com.aor.hero.viewer.Music;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MusicTest {
    private Music music;

    @BeforeEach
    void setUp() {
        music = new Music();
    }
    @Test
    void Music_loadcoinmusic(){
        NullPointerException e = null;
        Assertions.assertNotNull(music.loadCoinmusic());
        Assertions.assertNotEquals(e,music.loadCoinmusic());
        /////////
    }


}
