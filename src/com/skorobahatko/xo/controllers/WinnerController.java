package com.skorobahatko.xo.controllers;

import com.skorobahatko.xo.model.Field;
import com.skorobahatko.xo.model.Figure;
import com.skorobahatko.xo.model.Point;
import com.skorobahatko.xo.model.exceptions.InvalidPointException;
import com.sun.org.apache.regexp.internal.recompile;

import sun.net.www.content.text.plain;

public class WinnerController {

	public Figure getWinner(final Field field) {
		try {
			for (int i = 0; i < 3; i++) {
				Point point = new Point(i, 0);
				if (check(field, point, p -> new Point(p.getX(), p.getY() + 1))) {
					return field.getFigure(point);
				}
			}
			
			for (int i = 0; i < 3; i++) {
				Point point = new Point(0, i);
				if (check(field, point, p -> new Point(p.getX() + 1, p.getY()))) {
					return field.getFigure(point);
				}
			}
			
			if (check(field, new Point(0, 0), p -> new Point(p.getX() + 1, p.getY() + 1))) {
				return field.getFigure(new Point(0, 0));
			}
			
			if (check(field, new Point(0, 2), p -> new Point(p.getX() + 1, p.getY() - 1))) {
				return field.getFigure(new Point(0, 2));
			}
		} catch (InvalidPointException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private boolean check(final Field field, 
							final Point currentPoint, 
							IPointGenerator pointGenerator) {
		Figure currentFigure;
		Figure nextFigure;
		Point nextPoint = pointGenerator.next(currentPoint);
		try {
			currentFigure = field.getFigure(currentPoint);
			nextFigure = field.getFigure(nextPoint);
		} catch (InvalidPointException e) {
			return true;
		}
		
		if (currentFigure == null) return false;
		if (currentFigure != nextFigure) return false;
		
		return check(field, nextPoint, pointGenerator);
	}
	
	private interface IPointGenerator {
		Point next(final Point point);
	}
	
}
