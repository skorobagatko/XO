package com.skorobahatko.xo.model;

public class Game {
	
	private final String name;
	
	private final Field field;
	
	private final Player[] players;

	public Game(final String name, final Field field, final Player[] players) {
		this.name = name;
		this.field = field;
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public Field getField() {
		return field;
	}

	public Player[] getPlayers() {
		return players;
	}
	
}
