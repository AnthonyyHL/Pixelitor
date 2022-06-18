/*
 * Copyright 2022 Laszlo Balazs-Csiki and Contributors
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

package pixelitor.filters.impl;

import com.jhlabs.image.TransformFilter;

import java.awt.geom.Point2D;

/**
 * Abstract superclass for transform filters with a center
 */
public abstract class CenteredTransformFilter extends TransformFilter {
    // actual center coordinates in pixels
    protected double cx;
    protected double cy;

    protected CenteredTransformFilter(String filterName) {
        super(filterName);
    }

    public void setCenter(Point2D c) {
        // needs absolute values, because some filters use these
        // values in other setters, before the filtering begins
        cx = c.getX();
        cy = c.getY();
    }
}
