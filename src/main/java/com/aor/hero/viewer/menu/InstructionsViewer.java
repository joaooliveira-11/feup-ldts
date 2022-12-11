package com.aor.hero.viewer.menu;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.menu.Instructions;
import com.aor.hero.viewer.Viewer;

public class InstructionsViewer extends Viewer<Instructions> {
    public InstructionsViewer(Instructions instructions) {
        super(instructions);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 5), "InstructionsMenu", "#FFFFFF");
        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
