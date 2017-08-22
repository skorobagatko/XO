package com.skorobahatko.xo.controllers;

import com.skorobahatko.xo.model.Field;
import com.skorobahatko.xo.model.Figure;
import com.skorobahatko.xo.model.Point;
import com.skorobahatko.xo.model.exceptions.InvalidPointException;

public class CurrentMoveController {
	
	public Figure currentMove(final Field field) {
		int figureCounter = countFiguresInTheField(field);
				
		// Check if field is full (no empty cells)
		final int fieldSize = field.getSize();
		final int maxElements = fieldSize * fieldSize;
		if (figureCounter == maxElements) return null;
		
		return (figureCounter % 2 == 0) ? Figure.X : Figure.O;
	}
	
	private int countFiguresInTheField(final Field field) {
		int figureCounter = 0; 
		
		final int fieldSize = field.getSize();
		for (int x = 0; x < fieldSize; x++) {
			for (int y = 0; y < fieldSize; y++) {
				try {
					Figure currentFigure = field.getFigure(new Point(x, y));
					if (currentFigure != null) figureCounter++;
				} catch (InvalidPointException e) {
					e.printStackTrace();
				}
			}
		}
		
		return figureCounter;
	}

}
