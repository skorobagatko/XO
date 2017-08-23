package com.skorobahatko.xo.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.skorobahatko.xo.model.exceptions.AlreadyOccupiedException;
import com.skorobahatko.xo.model.exceptions.InvalidPointException;

public class FieldTest {

	@Test
	public void testGetSize() throws Exception {
		int expectedValue = 3;
		final Field<Figure> field = new Field<>();
		int actualValue = field.getSize();
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testSetFigure() throws Exception {
		final Field<Figure> field = new Field<>();
		final Point inputPoint = new Point(0, 0);
		final Figure inputFigure = Figure.X;
		field.setFigure(inputPoint, inputFigure);
		final Figure actualFigure = field.getFigure(inputPoint);
		assertEquals(inputFigure, actualFigure);
	}
		
	@Test
	public void testGetFigureWhenFigureIsNotSet() throws Exception {
		final Field<Figure> field = new Field<>();
		final Point inputPoint = new Point(0, 0);
		final Figure actualFigure = field.getFigure(inputPoint);
		assertNull(actualFigure);
	}
	
	@Test
	public void testGetFigureWhenXIsLessThanZero() throws Exception {
		final Field<Figure> field = new Field<>();
		final Point inputPoint = new Point(-1, 0);
		
		try {
			field.getFigure(inputPoint);
			fail();
		} catch (InvalidPointException e) {
			// NOP
		}
	}
	
	@Test
	public void testGetFigureWhenYIsLessThanZero() throws Exception {
		final Field<Figure> field = new Field<>();
		final Point inputPoint = new Point(0, -1);
		
		try {
			field.getFigure(inputPoint);
			fail();
		} catch (InvalidPointException e) {
			// NOP
		}
	}
	
	@Test
	public void testGetFigureWhenYIsMoreThanSize() throws Exception {
		final Field<Figure> field = new Field<>();
		final Point inputPoint = new Point(0, field.getSize() + 1);
		try {
			field.getFigure(inputPoint);
			fail();
		} catch (InvalidPointException e) {
			// NOP
		}
	}
	
	@Test
	public void testGetFigureWhenXIsMoreThanSize() throws Exception {
		final Field<Figure> field = new Field<>();
		final Point inputPoint = new Point(field.getSize() + 1, 0);
		try {
			field.getFigure(inputPoint);
			fail();
		} catch (InvalidPointException e) {
			// NOP
		}
	}
	
	@Test
	public void testGetFigureWhenBothCoordinatesLessThenZero() throws Exception {
		final Field<Figure> field = new Field<>();
		final Point inputPoint = new Point(-1, -1);
		try {
			field.getFigure(inputPoint);
			fail();
		} catch (InvalidPointException e) {
			// NOP
		}
	}
	
	@Test
	public void testGetFigureWhenBothCoordinatesMoreThenSize() throws Exception {
		final Field<Figure> field = new Field<>();
		final Point inputPoint = new Point(field.getSize() + 1, field.getSize() + 1);
		try {
			field.getFigure(inputPoint);
			fail();
		} catch (InvalidPointException e) {
			// NOP
		}
	}
}
