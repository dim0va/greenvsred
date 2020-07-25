package com.dim0va;

public class GreenCellRule extends Rule {
    private int targetRow;
    private int targetCol;
    private int[][] grid;

    public GreenCellRule(int targetRow, int targetCol, int[][] grid) {
        this.targetRow = targetRow;
        this.targetCol = targetCol;
        this.grid = grid;
    }

    @Override
    public Change applyRule(int row, int col) {
        int countChanges = 0;

        int greenNeighbours = countSurroundingGreenNeighbours(row, col, grid);

        if (greenNeighbours == 0 || greenNeighbours == 1 || greenNeighbours == 4
                || greenNeighbours == 5 || greenNeighbours == 7 || greenNeighbours == 8) {

            grid[row][col] = 0;

            if (row == targetRow && col == targetCol) {
                countChanges++;
            }
        }

        return new Change(countChanges, grid[row][col]);
    }
}

