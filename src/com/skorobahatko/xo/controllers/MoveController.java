package com.skorobahatko.xo.controllers;

import com.skorobahatko.xo.model.Field;
import com.skorobahatko.xo.model.Figure;
import com.skorobahatko.xo.model.Point;
import com.skorobahatko.xo.model.exceptions.AlreadyOccupiedException;
import com.skorobahatko.xo.model.exceptions.InvalidPointException;

public class MoveController {
	
	public void applyFigure(final Field<Figure> field, 
							final Figure figure, 
							final Point point) throws InvalidPointException,
													  AlreadyOccupiedException {
		if (field.getFigure(point) != null) {
			throw new AlreadyOccupiedException();
		}
		field.setFigure(point, figure);
	}

}
