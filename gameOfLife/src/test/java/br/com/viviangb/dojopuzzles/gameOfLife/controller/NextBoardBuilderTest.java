package br.com.viviangb.dojopuzzles.gameOfLife.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.viviangb.dojopuzzles.gameOfLife.model.Board;

public class NextBoardBuilderTest {
	
	private static int ROWS = 3;
	private static int COLUMNS = 3;
	
	/**
	 * Any live cell with fewer than two live neighbours dies, as if caused by 
	 * underpopulation.
	 * */
	@Test
	public void testRuleOneUpLeft() {
		testRuleOne(0, 0);		
	}
	
	@Test
	public void testRuleOneUpRight() {
		testRuleOne(0, COLUMNS - 1);		
	}
	
	@Test
	public void testRuleOneDownLeft() {
		testRuleOne(ROWS - 1, 0);
	}
	
	@Test
	public void testRuleOneDownRight() {
		testRuleOne(ROWS - 1, COLUMNS - 1);
	}
	
	@Test
	public void testRuleOneMiddle() {
		testRuleOne(1, 1);
	}
	
	private void testRuleOne(int x, int y) {
		boolean valueExpected = false;
		BoardBuilder builder = new BoardBuilder();
		NextBoardBuilder nextBuilder = new NextBoardBuilder();
		Board board = builder.build(ROWS, COLUMNS, false);
		board.put(x, y, true);
		Board nextBoard = nextBuilder.build(board);
		assertEquals("Error at rule one: Value did not match", valueExpected, nextBoard.isAlive(x, y));
	}
	
	/**
	 * Any live cell with more than three live neighbours dies, as if by 
	 * overcrowding.
	 * */
	@Test
	public void testRuleTwo() {
		int x = 1;
		int y = 1;
		boolean valueExpected = false;
		BoardBuilder builder = new BoardBuilder();
		Board board = builder.build(ROWS, COLUMNS, false);
		NextBoardBuilder nextBuilder = new NextBoardBuilder();
		board.put(0, 0, true);
		board.put(0, 1, true);
		board.put(1, 0, true);
		board.put(x, y, true);
		board.put(1, 2, true);
		Board nextBoard = nextBuilder.build(board);
		assertEquals("Error at rule two: Value did not match", valueExpected, nextBoard.isAlive(x, y));
	}

	/**
	 * Any live cell with two or three live neighbours lives on to the next generation.
	 * */
	@Test
	public void testRuleThreeWithTwoLiveNeighbours() {
		int x = 2;
		int y = 2;
		boolean valueExpected = true;
		BoardBuilder builder = new BoardBuilder();
		Board board = builder.build(ROWS, COLUMNS, false);
		NextBoardBuilder nextBuilder = new NextBoardBuilder();
		board.put(1, 2, true);
		board.put(2, 1, true);
		board.put(x, y, true);
		Board nextBoard = nextBuilder.build(board);
		assertEquals("Error at rule three: Value did not match", valueExpected, nextBoard.isAlive(x, y));
	}
	
	/**
	 * Any live cell with two or three live neighbours lives on to the next generation.
	 * */
	@Test
	public void testRuleThreeWithThreeLiveNeighbours() {
		int x = 0;
		int y = 0;
		boolean valueExpected = true;
		BoardBuilder builder = new BoardBuilder();
		Board board = builder.build(ROWS, COLUMNS, false);
		NextBoardBuilder nextBuilder = new NextBoardBuilder();
		board.put(1, 1, true);
		board.put(0, 1, true);
		board.put(1, 0, true);
		board.put(x, y, true);
		Board nextBoard = nextBuilder.build(board);
		assertEquals("Error at rule three: Value did not match", valueExpected, nextBoard.isAlive(x, y));
	}

	/**
	 * Any dead cell with exactly three live neighbours becomes a live cell.
	 * */
	@Test
	public void testRuleFour() {
		int x = 2;
		int y = 1;
		boolean valueExpected = true;
		BoardBuilder builder = new BoardBuilder();
		Board board = builder.build(ROWS, COLUMNS, false);
		NextBoardBuilder nextBuilder = new NextBoardBuilder();
		board.put(1, 0, true);
		board.put(1, 1, true);
		board.put(1, 2, true);
		Board nextBoard = nextBuilder.build(board);
		assertEquals("Error at rule four: Value did not match", valueExpected, nextBoard.isAlive(x, y));
	}
}
