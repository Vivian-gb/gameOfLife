package br.com.viviangb.dojopuzzles.gameOfLife.controller;

import br.com.viviangb.dojopuzzles.gameOfLife.model.Board;

public class NextBoardBuilder {

	public Board build(Board board) {
		Board newBoard = new Board(board.getRows(), board.getColumns());
		for (int row = 0; row < board.getRows(); row++) {
			for (int column = 0; column < board.getColumns(); column++) {
				int count = board.getCountAlive(row, column);
				if (board.isAlive(row, column)) {
//					Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
//					Any live cell with more than three live neighbours dies, as if by overcrowding.
//					Any live cell with two or three live neighbours lives on to the next generation.
					if (count < 2 || count > 3) {
						newBoard.put(row, column, false);
					} else {
						newBoard.put(row, column, true);
					}
				} else if (count == 3) {
//					Any dead cell with exactly three live neighbours becomes a live cell.
					newBoard.put(row, column, true);
				}
			}
		}
		return newBoard;
	}
}
