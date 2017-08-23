package com.skorobahatko.xo.model;

public class Game<T> {
	
	private final String name;
	
	private final Field<T> field;
	
	private final Player[] players;

	public Game(final String name, final Field<T> field, final Player[] players) {
		this.name = name;
		this.field = field;
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public Field<T> getField() {
		return field;
	}

	public Player[] getPlayers() {
		return players;
	}
	
}
