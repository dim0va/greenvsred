package com.dim0va;

public abstract class Rule {
    int countSurroundingGreenNeighbours(int x, int y, int [][] grid) {
        final int MIN_X = 0;
        final int MAX_X = grid.length; //calculates how many rows are in the grid
        final int MIN_Y = 0;
        final int MAX_Y = grid[0].length; //calculates how many columns are in the grid

        int startPosX = (x - 1 < MIN_X) ? x : x - 1;
        int startPosY = (y - 1 < MIN_Y) ? y : y - 1;
        int endPosX = (x + 1 > MAX_X) ? x : x + 1;
        int endPosY = (y + 1 > MAX_Y) ? y : y + 1;

        int greenNeighbours = 0;

        // grid[rowNum][colNum] would be the existing neighbours
        for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {
            for (int colNum = startPosY; colNum <= endPosY; colNum++) {
                if(rowNum == x && colNum == y) {
                    continue;
                }

                //checks if the neighbour's value is 1
                if (grid[rowNum][colNum] == 1) {
                    greenNeighbours++;
                }
            }
        }
        return greenNeighbours;
    }

    abstract Change applyRule(int row, int col);
}
