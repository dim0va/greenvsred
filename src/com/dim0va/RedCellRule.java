package com.dim0va;

public class RedCellRule extends Rule {
    private int targetRow;
    private int targetCol;

    public RedCellRule(int targetRow, int targetCol) {
        this.targetRow = targetRow;
        this.targetCol = targetCol;
    }

    @Override
    public NewElement applyRules(int row, int col, int[][] grid){
        //declare and initialize a buffer matrix to store the new values in
        int [][] nextGrid = new int [grid.length][grid[0].length];
        boolean isGreen = false;

        //check for green neighbours
        int greenNeighbours = countSurroundingGreenNeighbours(row, col, grid);

        //if the neighbours are 3 or 6, the red cell becomes green
        if (greenNeighbours == 3 || greenNeighbours == 6) {
            nextGrid[row][col] = 1;

            //if the cell is the target cell, we increase the amount of time that it has been green
            if (row == targetRow && col == targetCol) {
                isGreen = true;
            }
        } else {
            //else stays red
            nextGrid[row][col] = 0;
        }

        return new NewElement(isGreen, nextGrid[row][col]);
    }
}
