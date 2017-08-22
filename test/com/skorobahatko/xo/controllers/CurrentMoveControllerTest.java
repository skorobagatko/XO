package com.skorobahatko.xo.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Random;

import org.junit.Test;

import com.skorobahatko.xo.model.Field;
import com.skorobahatko.xo.model.Figure;
import com.skorobahatko.xo.model.Point;
import com.skorobahatko.xo.model.exceptions.InvalidPointException;

public class CurrentMoveControllerTest {

	@Test
	public void testCurrentMoveWhenNextIsO() throws InvalidPointException {
		final CurrentMoveController currentMoveController = new CurrentMoveController();
		
		final int fieldSize = 3;
		for (int i = 0; i < fieldSize; i++) {
			final Field field = new Field(fieldSize);
			field.setFigure(new Point(i, 0), Figure.X);
			field.setFigure(new Point(i, 1), Figure.O);
			field.setFigure(new Point(i, 2), Figure.X);
			assertEquals(Figure.O, currentMoveController.currentMove(field));
		}
	}
	
	@Test
	public void testCurrentMoveWhenNextIsX() throws InvalidPointException {
		final CurrentMoveController currentMoveController = new CurrentMoveController();
		
		final int fieldSize = 3;
		for (int i = 0; i < fieldSize; i++) {
			final Field field = new Field(fieldSize);
			field.setFigure(new Point(i, 0), Figure.X);
			field.setFigure(new Point(i, 1), Figure.O);
			assertEquals(Figure.X, currentMoveController.currentMove(field));
		}
	}
	
	@Test
	public void testCurrentMoveWhenFieldIsFull() throws InvalidPointException {
		final CurrentMoveController currentMoveController = new CurrentMoveController();
		
		// Fill the field
		final int fieldSize = 3;
		final Field field = new Field(fieldSize);
		for (int x = 0; x < fieldSize; x++) {
			for (int y = 0; y < fieldSize; y++) {
				final Figure figure = (y % 2 == 0) ? Figure.X : Figure.O;
				field.setFigure(new Point(x, y), figure);
			}
		}
		
		assertNull(currentMoveController.currentMove(field));			
	}

}
