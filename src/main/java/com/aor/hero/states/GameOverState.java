package com.aor.hero.states;
import com.aor.hero.controller.Controller;
import com.aor.hero.controller.menu.GameOverController;
import com.aor.hero.model.menu.GameOver;
import com.aor.hero.viewer.Viewer;
import com.aor.hero.viewer.menu.GameOverViewer;


public class GameOverState extends State<GameOver> {
    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
