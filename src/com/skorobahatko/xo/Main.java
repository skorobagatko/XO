package com.skorobahatko.xo;

import com.skorobahatko.xo.model.Field;
import com.skorobahatko.xo.model.Figure;
import com.skorobahatko.xo.model.Game;
import com.skorobahatko.xo.model.Player;
import com.skorobahatko.xo.view.ConsoleView;

public class Main {

	public static void main(String[] args) {
		final Player player1 = new Player("John", Figure.X);
		final Player player2 = new Player("Bob", Figure.O);
		
		final Player[] players = {player1, player2};
		
		final Field<Figure> field = new Field<>(3);
		
		final Game<Figure> game = new Game<>("XO", field, players);
		
		final ConsoleView consoleView = new ConsoleView();
		
		consoleView.show(game);
		while (consoleView.move(game)) {
			consoleView.show(game);
		}
	}
	
}
