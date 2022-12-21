package com.aor.hero.viewer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Music {
    private Clip coinmusic;
    private Clip supercoinmusic;
    private Clip loselifemusic;
    private Clip killmonstermusic;

    private Clip startgamemusic;
    private Clip gameMusic;
    private AudioInputStream in;

    public Music() {
        this.coinmusic = loadCoinmusic();
        this.supercoinmusic = loadSuperCoinmusic();
        this.loselifemusic = loadloselifemusic();
        this.killmonstermusic = loadKillMonster();
        this.startgamemusic = loadStartGameMusic();
    }

    public Clip loadCoinmusic() throws NullPointerException{
        try {
            AudioInputStream in2;
            in2 = AudioSystem.getAudioInputStream(new File("src/main/resources/Musics/coinmusic.wav"));
            coinmusic = AudioSystem.getClip();
            coinmusic.open(in2);
            FloatControl gainControl = (FloatControl)coinmusic.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return coinmusic;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Clip loadSuperCoinmusic() throws NullPointerException{
        try {
            AudioInputStream in2;
            in2 = AudioSystem.getAudioInputStream(new File("src/main/resources/Musics/supercoinmusic.wav"));
            supercoinmusic = AudioSystem.getClip();
            supercoinmusic.open(in2);
            FloatControl gainControl = (FloatControl)supercoinmusic.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return supercoinmusic;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Clip loadloselifemusic() throws NullPointerException{
        try {
            AudioInputStream in2;
            in2 = AudioSystem.getAudioInputStream(new File("src/main/resources/Musics/loselifemusic.wav"));
            loselifemusic = AudioSystem.getClip();
            loselifemusic.open(in2);
            FloatControl gainControl = (FloatControl)loselifemusic.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return loselifemusic;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Clip loadKillMonster  () throws NullPointerException{
        try {
            AudioInputStream in2;
            in2 = AudioSystem.getAudioInputStream(new File("src/main/resources/Musics/killghostmusic.wav"));
            killmonstermusic = AudioSystem.getClip();
            killmonstermusic.open(in2);
            FloatControl gainControl = (FloatControl)killmonstermusic.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return killmonstermusic;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Clip loadStartGameMusic  () throws NullPointerException{
        try {
            AudioInputStream in2;
            in2 = AudioSystem.getAudioInputStream(new File("src/main/resources/Musics/startmusic.wav"));
            startgamemusic = AudioSystem.getClip();
            startgamemusic.open(in2);
            FloatControl gainControl = (FloatControl)startgamemusic.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            return startgamemusic;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void startCoinMusic() {
        coinmusic.setMicrosecondPosition(0);
        coinmusic.start();
        coinmusic.loop(0);
    }

    public void startSuperCoinMusic() {
        supercoinmusic.setMicrosecondPosition(0);
        supercoinmusic.start();
        supercoinmusic.loop(0);
    }

    public void startLoseLifeMusic() {
        loselifemusic.setMicrosecondPosition(0);
        loselifemusic.start();
        loselifemusic.loop(0);
    }

    public void startKillMonsterMusic() {
        killmonstermusic.setMicrosecondPosition(0);
        killmonstermusic.start();
        killmonstermusic.loop(0);
    }
    public void startGameMusic(){
        startgamemusic.setMicrosecondPosition(0);
        startgamemusic.start();
        startgamemusic.loop(0);
    }
}

