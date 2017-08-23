package com.skorobahatko.xo.model;

import com.skorobahatko.xo.model.exceptions.InvalidPointException;

public class Field<T> {
	
	private static final int MIN_COORDINATE = 0;
	
	private final T[][] field;
		
	private final int fieldSize;
			
	public Field() {
		this(3);
	}

	public Field(final int fieldSize) {
		this.fieldSize = fieldSize;
		field = (T[][]) new Object[fieldSize][fieldSize];
	}

	public int getSize() {
		return fieldSize;
	}
	
	public T getFigure(final Point point) throws InvalidPointException {
		if (!checkPoint(point)) {
			throw new InvalidPointException();
		}
		return field[point.getY()][point.getX()];
	}
	
	public void setFigure(final Point point, final T figure) throws InvalidPointException {
		if (!checkPoint(point)) {
			throw new InvalidPointException();
		}
		field[point.getY()][point.getX()] = figure;
	}
	
	private boolean checkPoint(final Point point) {
		return checkCoordinate(point.getX(), field.length) && 
				checkCoordinate(point.getY(), field.length);
	}
	
	private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
		return (coordinate >= MIN_COORDINATE && coordinate < maxCoordinate);
	}

}
