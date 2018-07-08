/*
 * Copyright 2018 Laszlo Balazs-Csiki and Contributors
 *
 * This file is part of Pixelitor. Pixelitor is free software: you
 * can redistribute it and/or modify it under the terms of the GNU
 * General Public License, version 3 as published by the Free
 * Software Foundation.
 *
 * Pixelitor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Pixelitor. If not, see <http://www.gnu.org/licenses/>.
 */

package pixelitor.history;

import pixelitor.Composition;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

/**
 * A PixelitorEdit that represents the changes made to the layer order.
 */
public class LayerOrderChangeEdit extends PixelitorEdit {
    private final int oldLayerIndex;
    private final int newLayerIndex;

    public LayerOrderChangeEdit(Composition comp, int oldLayerIndex, int newLayerIndex) {
        super("Layer Order Change", comp);

        this.oldLayerIndex = oldLayerIndex;
        this.newLayerIndex = newLayerIndex;
    }

    @Override
    public void undo() throws CannotUndoException {
        super.undo();

        comp.changeLayerOrder(newLayerIndex, oldLayerIndex, false);
    }

    @Override
    public void redo() throws CannotRedoException {
        super.redo();

        comp.changeLayerOrder(oldLayerIndex, newLayerIndex, false);
    }
}