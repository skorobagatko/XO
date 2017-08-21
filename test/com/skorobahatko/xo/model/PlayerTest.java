package com.skorobahatko.xo.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testGetName() {
		final String inputValue = "John";
		final String expectedValue = inputValue;
		final Player player = new Player(inputValue, null);
		final String actualValue = player.getName();
		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testGetFigure() {
		final Figure inputValue = Figure.X;
		final Figure expectedValue = inputValue;
		final Player player = new Player(null, inputValue);
		final Figure actualValue = player.getFigure();
		assertEquals(expectedValue, actualValue);
	}

}
