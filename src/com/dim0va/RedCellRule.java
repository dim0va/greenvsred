package com.dim0va;

public class RedCellRule extends Rule {
    private int targetRow;
    private int targetCol;

    public RedCellRule(int targetRow, int targetCol) {
        this.targetRow = targetRow;
        this.targetCol = targetCol;
    }

    @Override
    public Change applyRules(int row, int col, int[][] grid){
        int timesBeenGreen = 0;
        int [][] nextGrid = new int [grid.length][grid[0].length];

        int greenNeighbours = countSurroundingGreenNeighbours(row, col, grid);
        System.out.println(String.format("(%s : %s) - %s", row, col, greenNeighbours));

        if (greenNeighbours == 3 || greenNeighbours == 6) {
            nextGrid[row][col] = 1;

            if (row == targetRow && col == targetCol) {
                timesBeenGreen++;
            }
        } else {
            nextGrid[row][col] = 0;
        }

        return new Change(timesBeenGreen, nextGrid[row][col]);
    }
}
