package com.skorobahatko.xo.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FieldTest {

	@Test
	public void testGetSize() {
		int expectedValue = 3;
		final Field field = new Field();
		int actualValue = field.getSize();
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testSetFigure() {
		final Field field = new Field();
		final Point inputPoint = new Point(0, 0);
		final Figure inputFigure = Figure.X;
		
		field.setFigure(inputPoint, inputFigure);
		final Figure actualFigure = field.getFigure(inputPoint);
		
		assertEquals(inputFigure, actualFigure);
	}

}
