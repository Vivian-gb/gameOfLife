package br.com.viviangb.dojopuzzles.gameOfLife.controller;

import br.com.viviangb.dojopuzzles.gameOfLife.model.Board;

public class BoardBuilder {

	public Board build(int rows, int columns, boolean defaultValue) {
		Board board = new Board(rows, columns);
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				board.put(row, column, defaultValue);
			}
		}
		return board;
	}
}
