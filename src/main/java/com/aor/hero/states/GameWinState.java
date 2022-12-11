package com.aor.hero.states;
import com.aor.hero.controller.Controller;
import com.aor.hero.controller.menu.GameWinController;
import com.aor.hero.model.menu.GameWin;
import com.aor.hero.viewer.Viewer;
import com.aor.hero.viewer.menu.GameWinViewer;


public class GameWinState extends State<GameWin>{
    public GameWinState(GameWin model) {
        super(model);
    }

    @Override
    protected Viewer<GameWin> getViewer() {
        return new GameWinViewer(getModel());
    }

    @Override
    protected Controller<GameWin> getController() {
        return new GameWinController(getModel());
    }
}
