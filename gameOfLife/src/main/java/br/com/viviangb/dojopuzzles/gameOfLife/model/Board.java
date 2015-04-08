package br.com.viviangb.dojopuzzles.gameOfLife.model;

public class Board {

	private int rows;
	private int columns;
	private boolean[][] board;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		this.board = new boolean[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public void put(int x,int y, boolean value) {
		this.board[x][y] = value;
	}
	
	public int getCountAlive(int x, int y) {
		int countAlive = (board[x][y]) ? -1 : 0;
		int row = (x == 0) ? 0 : x - 1;
		int rowLimit = (x + 2 > rows) ? rows : (x + 2);
		int columnStartsIn = (y == 0) ? 0 : y - 1;
		int columnLimit = (y + 2 > columns) ? columns : (y + 2);
		for(; row < rowLimit; row++) {
			for (int column = columnStartsIn; column < columnLimit; column++) {
				if (board[row][column]) {
					countAlive++;
				}
			}
		}
		return countAlive;
	}
	
	public boolean isAlive(int x, int y) {
		return board[x][y];
	}
}
