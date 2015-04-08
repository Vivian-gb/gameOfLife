package br.com.viviangb.dojopuzzles.gameOfLife.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.viviangb.dojopuzzles.gameOfLife.model.Board;

public class BoardBuilderTest {
	
	private static int ROWS = 4;
	private static int COLUMNS = 4;

	@Test
	public void testBuildWithDefaultValueFalse() {
		testBuildWithDefaultValue(ROWS, COLUMNS, false);
	}
	
	@Test
	public void testBuildWithDefaultValueTrue() {
		testBuildWithDefaultValue(ROWS, COLUMNS, true);
	}
	
	private void testBuildWithDefaultValue(int rows, int columns, 
			boolean defaultValue) {
		BoardBuilder builder = new BoardBuilder();
		Board board = builder.build(rows, columns, defaultValue);
		for (int row = 0; row < rows; row++) {
			for(int column = 0; column < columns; column++) {
				assertEquals("Values did not match", defaultValue, board.isAlive(row, column));
			}
		}
	}
}
