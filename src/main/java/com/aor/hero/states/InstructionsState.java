package com.aor.hero.states;
import com.aor.hero.controller.Controller;
import com.aor.hero.controller.menu.InstructionsController;
import com.aor.hero.model.menu.Instructions;
import com.aor.hero.viewer.Viewer;
import com.aor.hero.viewer.menu.InstructionsViewer;

public class InstructionsState extends State<Instructions>{
    public InstructionsState(Instructions model) {
        super(model);
    }

    @Override
    protected Viewer<Instructions> getViewer() {
        return new InstructionsViewer(getModel());
    }

    @Override
    protected Controller<Instructions> getController() {
        return new InstructionsController(getModel());
    }
}
