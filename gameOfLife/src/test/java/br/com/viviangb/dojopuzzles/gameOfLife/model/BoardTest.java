package br.com.viviangb.dojopuzzles.gameOfLife.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {
	
	private static int ROWS = 3;
	private static int COLUMNS = 3;

	@Test
	public void testSize() {
		Board board = new Board(ROWS, COLUMNS);
		assertEquals("Rows did not match", ROWS, board.getRows());
		assertEquals("Columns did not match", COLUMNS, board.getColumns());
		assertEquals("Error at board creation, array did not match", false, board.isAlive(ROWS-1, COLUMNS-1));
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testArrayLimit() {
		Board board = new Board(ROWS, COLUMNS);
		assertEquals("Error at board creation, array did not match", false, board.isAlive(ROWS-1, COLUMNS-1));
		board.isAlive(ROWS, COLUMNS);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testMethodPut() {
		int x = 0;
		int y = 0;
		boolean expectedValue = true;
		Board board = new Board(ROWS, COLUMNS);
		board.put(x, y, expectedValue);
		assertEquals("Error at method put(int, int, boolean), value did not match", expectedValue, board.isAlive(x, y));
		board.put(ROWS, COLUMNS, false);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testMethodGetCountAlive() {
		int x = 0;
		int y = 0;
		int expected = 2;
		Board board = new Board(ROWS, COLUMNS);
		board.put(1, 0, true);
		board.put(0, 1, true);
		assertEquals("Error at method getCountAlive, count did not match", 
				expected, board.getCountAlive(x, y));
		board.put(x, y, true);
		assertEquals("Error at method getCountAlive, count did not match", 
				expected, board.getCountAlive(x, y));
		board.getCountAlive(-1, -1);
	}
}
