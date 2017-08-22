package com.skorobahatko.xo.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

import com.skorobahatko.xo.model.Field;
import com.skorobahatko.xo.model.Figure;
import com.skorobahatko.xo.model.Point;
import com.skorobahatko.xo.model.exceptions.InvalidPointException;

public class WinnerControllerTest {

	@Test
	public void testGetWinnerWhenRowWinner() throws InvalidPointException {
		final WinnerController winnerController = new WinnerController();
		
		final int fieldSize = 3;
		for (int i = 0; i < fieldSize; i++) {
			final Field field = new Field(fieldSize);
			field.setFigure(new Point(i, 0), Figure.X);
			field.setFigure(new Point(i, 1), Figure.X);
			field.setFigure(new Point(i, 2), Figure.X);
			assertEquals(Figure.X, winnerController.getWinner(field));
		}
	}
	
	@Test
	public void testGetWinnerWhenNoRowWinner() throws InvalidPointException {
		final WinnerController winnerController = new WinnerController();
		
		final int fieldSize = 3;
		for (int i = 0; i < fieldSize; i++) {
			final Field field = new Field(fieldSize);
			field.setFigure(new Point(i, 0), Figure.X);
			field.setFigure(new Point(i, 1), Figure.O);
			field.setFigure(new Point(i, 2), Figure.X);
			assertNull(winnerController.getWinner(field));
		}
	}
	
	@Test
	public void testGetWinnerWhenColumnWinner() throws InvalidPointException {
		final WinnerController winnerController = new WinnerController();
		
		final int fieldSize = 3;
		for (int i = 0; i < fieldSize; i++) {
			final Field field = new Field(fieldSize);
			field.setFigure(new Point(0, i), Figure.X);
			field.setFigure(new Point(1, i), Figure.X);
			field.setFigure(new Point(2, i), Figure.X);
			assertEquals(Figure.X, winnerController.getWinner(field));
		}
	}
	
	@Test
	public void testGetWinnerWhenNoColumnWinner() throws InvalidPointException {
		final WinnerController winnerController = new WinnerController();
		
		final int fieldSize = 3;
		for (int i = 0; i < fieldSize; i++) {
			final Field field = new Field(fieldSize);
			field.setFigure(new Point(0, i), Figure.X);
			field.setFigure(new Point(1, i), Figure.O);
			field.setFigure(new Point(2, i), Figure.X);
			assertNull(winnerController.getWinner(field));
		}
	}

	@Test
	public void testGetWinnerWhenDiagonal1Winner() throws InvalidPointException {
		final Field field = new Field(3);
		field.setFigure(new Point(0, 0), Figure.X);
		field.setFigure(new Point(1, 1), Figure.X);
		field.setFigure(new Point(2, 2), Figure.X);
		
		final WinnerController winnerController = new WinnerController();
		assertEquals(Figure.X, winnerController.getWinner(field));
	}
	
	@Test
	public void testGetWinnerWhenNoDiagonal1Winner() throws InvalidPointException {
		final Field field = new Field(3);
		field.setFigure(new Point(0, 0), Figure.X);
		field.setFigure(new Point(1, 1), Figure.O);
		field.setFigure(new Point(2, 2), Figure.X);
		
		final WinnerController winnerController = new WinnerController();
		assertNull(winnerController.getWinner(field));
	}
	
	@Test
	public void testGetWinnerWhenDiagonal2Winner() throws InvalidPointException {
		final Field field = new Field(3);
		field.setFigure(new Point(0, 2), Figure.X);
		field.setFigure(new Point(1, 1), Figure.X);
		field.setFigure(new Point(2, 0), Figure.X);
		
		final WinnerController winnerController = new WinnerController();
		assertEquals(Figure.X, winnerController.getWinner(field));
	}
	
	@Test
	public void testGetWinnerWhenNoDiagonal2Winner() throws InvalidPointException {
		final Field field = new Field(3);
		field.setFigure(new Point(0, 2), Figure.X);
		field.setFigure(new Point(1, 1), Figure.O);
		field.setFigure(new Point(2, 0), Figure.X);
		
		final WinnerController winnerController = new WinnerController();
		assertNull(winnerController.getWinner(field));
	}
}
