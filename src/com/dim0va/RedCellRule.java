package com.dim0va;

public class RedCellRule extends Rule {
    private int targetRow;
    private int targetCol;
    private int [][] grid;
    private int [][] mockGrid;

    public RedCellRule(int targetRow, int targetCol, int [][] grid) {
        this.targetRow = targetRow;
        this.targetCol = targetCol;
        this.grid = grid;
    }

    @Override
    public Change applyRule(int row, int col) {
        int countChanges = 0;
        mockGrid = new int [grid.length][grid[0].length];

        int greenNeighbours = countSurroundingGreenNeighbours(row, col, grid);

        if (greenNeighbours == 3 || greenNeighbours == 6) {
            mockGrid[row][col] = 1;

            if (row == targetRow && col == targetCol) {
                countChanges++;
            }
        }

        return new Change(countChanges, mockGrid[row][col]);
    }
}
