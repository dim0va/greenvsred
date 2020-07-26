package com.dim0va;

public abstract class Rule {
    public int countSurroundingGreenNeighbours(int x, int y, int[][] grid) {
        //checking the size of the matrix
        final int MIN_X = 0;
        final int MAX_X = grid.length - 1; //calculates how many rows are in the grid
        final int MIN_Y = 0;
        final int MAX_Y = grid[0].length - 1; //calculates how many columns are in the grid

        //calculating the range of indexes of the neighbours of the given cell
        int startPosX = (x - 1 < MIN_X) ? x : x - 1;
        int startPosY = (y - 1 < MIN_Y) ? y : y - 1;
        int endPosX = (x + 1 > MAX_X) ? x : x + 1;
        int endPosY = (y + 1 > MAX_Y) ? y : y + 1;

        int greenNeighbours = 0;

        // grid[rowNum][colNum] would be the existing neighbours
        for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {
            for (int colNum = startPosY; colNum <= endPosY; colNum++) {

                //if-check, in order to skip counting the cell itself
                //we need only its neighbours
                if (rowNum == x && colNum == y) {
                    continue;
                }

                //checks if neighbour's value is 1
                if (grid[rowNum][colNum] == 1) {
                    greenNeighbours++;
                }
            }
        }
        return greenNeighbours;
    }

    //abstract method that is going to be implemented differently by classed RedCellRule and GreenCellRule
    public abstract NewElement applyRules(int row, int col, int[][] grid);
}