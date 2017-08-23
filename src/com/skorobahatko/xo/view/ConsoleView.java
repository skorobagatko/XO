package com.skorobahatko.xo.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skorobahatko.xo.controllers.CurrentMoveController;
import com.skorobahatko.xo.controllers.MoveController;
import com.skorobahatko.xo.controllers.WinnerController;
import com.skorobahatko.xo.model.Field;
import com.skorobahatko.xo.model.Figure;
import com.skorobahatko.xo.model.Game;
import com.skorobahatko.xo.model.Point;
import com.skorobahatko.xo.model.exceptions.AlreadyOccupiedException;
import com.skorobahatko.xo.model.exceptions.InvalidPointException;

public class ConsoleView {
	
	private final CurrentMoveController currentMoveController = new CurrentMoveController();
	
	private final WinnerController winnerController = new WinnerController();
	
	private final MoveController moveController = new MoveController();
	
	public void show(final Game game) {
		final Field<Figure> field = game.getField();
		
		System.out.println();
		for (int x = 0; x < field.getSize(); x++) {
			showLine(field, x);
			int separatorLength = field.getSize() * 4;
			if (x != field.getSize() -1) showSeparator(separatorLength);
		}
		System.out.println();
	}
	
	public boolean move(final Game game) {
		final Field<Figure> field = game.getField();
		
		final Figure currentFigure = currentMoveController.currentMove(field);
		final Figure winnerFigure = winnerController.getWinner(field);
		
		// Check if winner is exist
		if (winnerFigure != null) {
			System.out.println("The winner is " + winnerFigure);
			return false;
		}
		
		// Get winner when field is full
		if (currentFigure == null) {
			System.out.println("No winner. Game Over");
			return false;
		} 
				
		System.out.println("Please, enter point coordinates for " + currentFigure);
		final Point point = askPoint();
		try {
			moveController.applyFigure(field, currentFigure, point);
		} catch (InvalidPointException e) {
			System.out.println("Point is not valid. Must be from 1 to " + field.getSize());
		} catch (AlreadyOccupiedException e) {
			System.out.println("Point is already occupied. Try another coordinate.");
		}
		return true;
	}
	
	private Point askPoint() {
		return new Point(askCoordinate("X"), askCoordinate("Y"));
	}
	
	private int askCoordinate(final String coordinateName) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter " + coordinateName + " coordinate: ");
		try {
			int coordinate = scanner.nextInt() - 1;
			return coordinate;
		} catch (InputMismatchException e) {
			System.out.println("Coordinate must contain only digits. Try again.");
			return askCoordinate(coordinateName);
		}
	}

	private void showLine(final Field<Figure> field, final int row) {
		StringBuilder sb = new StringBuilder("|");
		for (int y = 0; y < field.getSize(); y++) {
			sb.append(" ");
			try {
				Figure figure = field.getFigure(new Point(y, row));
				sb.append((figure != null) ? figure.toString() : " ");
			} catch (InvalidPointException e) {
				throw new RuntimeException(e);
			}
			sb.append(" |");
		}
		System.out.println(sb.toString());
	}
	
	private void showSeparator(int length) {
		StringBuilder sb = new StringBuilder("-");
		for (int i = 0; i < length; i++) {
			sb.append("-");
		}
		System.out.println(sb);
	}
}
