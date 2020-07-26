package com.dim0va;

public class GreenCellRule extends Rule {
    private int targetRow;
    private int targetCol;

    public GreenCellRule(int targetRow, int targetCol) {
        this.targetRow = targetRow;
        this.targetCol = targetCol;
    }

    @Override
    public NewElement applyRules(int row, int col, int[][] grid) {
        int [][] nextGrid = new int [grid.length][grid[0].length];
        int timesBeenGreen = 0;

        int greenNeighbours = countSurroundingGreenNeighbours(row, col, grid);
        System.out.println(String.format("(%s : %s) - %s", row, col, greenNeighbours));

        if (greenNeighbours == 2 || greenNeighbours == 3 || greenNeighbours == 6) {
            nextGrid[row][col] = 1;

            if (row == targetRow && col == targetCol) {
                timesBeenGreen++;
            }
        } else {
            nextGrid[row][col] = 0;
        }

        return new NewElement(timesBeenGreen, nextGrid[row][col]);
    }
}

