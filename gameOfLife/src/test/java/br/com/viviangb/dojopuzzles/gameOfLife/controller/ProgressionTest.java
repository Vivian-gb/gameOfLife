package br.com.viviangb.dojopuzzles.gameOfLife.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.viviangb.dojopuzzles.gameOfLife.model.Board;

public class ProgressionTest {
	
	private Board board;
	private NextBoardBuilder nextBuilder;
	
	@Before
	public void init() {
		BoardBuilder builder = new BoardBuilder();
		this.board = builder.build(4, 5, false);
		this.nextBuilder = new NextBoardBuilder();
		this.board.put(1, 2, true);
		this.board.put(1, 3, true);
		this.board.put(2, 1, true);
		this.board.put(2, 2, true);
		this.board.put(2, 3, true);
	}

	@Test
	public void testProgression() {
		boolean[][] expected1 = new boolean[][]{
			{ false, false, false, false, false },
			{ false, false, true, true, false },
			{ false, true,  true, true, false },
			{ false, false, false, false, false}};
		boolean[][] expected2 = new boolean[][]{
			{false, false, false, false, false},
			{false, true,  false, true,  false},
			{false, true,  false, true,  false},
			{false, false, true,  false, false}};
		boolean[][] expected3 = new boolean[][]{
			{false, false, false, false, false},
			{false, false, false, false, false},
			{false, true,  false, true,  false},
			{false, false, true,  false, false}};
		boolean[][] expected4 = new boolean[][]{
			{false, false, false, false, false},
			{false, false, false, false, false},
			{false, false, true,  false, false},
			{false, false, true,  false, false}};
		check(board, expected1);
		board = nextBuilder.build(board);
		check(board, expected2);
		board = nextBuilder.build(board);
		check(board, expected3);
		board = nextBuilder.build(board);
		check(board, expected4);		
	}
	
	private void check(Board board, boolean[][] expected) {
		for (int row = 0; row < board.getRows(); row++) {
			for (int column = 0; column < board.getColumns(); column++) {
				assertEquals("Value did not match", expected[row][column], board.isAlive(row, column));
			}
		}
	}
}
