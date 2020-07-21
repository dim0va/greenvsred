package com.dim0va;

public class RedRule implements Rule {
    private int targetRow;
    private int targetCol;
    private int width;
    private int height;
    private int [][] grid;

    public RedRule(int targetRow, int targetCol, int width, int height, int [][] grid) {
        this.targetRow = targetRow;
        this.targetCol = targetCol;
        this.width = width;
        this.height = height;
        this.grid = grid;
    }

    @Override
    public int countSurroundingGreenNeighbours() {
        int count = 0;
        if(checkIfTargetCellIsInTheCorner().equals(CellPosition.BOTTOM_RIGHT)) {
            if(grid[targetRow-1][targetCol]==1) {
                count++;
            }

            if(grid[targetRow-1][targetCol-1]==1) {
                count++;
            }

            if(grid[targetRow][targetCol-1]==1) {
                count++;
            }

            return count;
        }

        if(checkIfTargetCellIsInTheCorner().equals(CellPosition.BOTTOM_LEFT)) {
            if(grid[targetRow][targetCol+1]==1) {
                count++;
            }

            if(grid[targetRow-1][targetCol]==1) {
                count++;
            }

            if(grid[targetRow-1][targetCol+1]==1) {
                count++;
            }

            return count;
        }

        if(checkIfTargetCellIsInTheCorner().equals(CellPosition.TOP_LEFT)) {
            if(grid[targetRow+1][targetCol+1]==1) {
                count++;
            }

            if(grid[targetRow][targetCol+1]==1) {
                count++;
            }

            if(grid[targetRow+1][targetCol]==1) {
                count++;
            }

            return count;
        }

        if(checkIfTargetCellIsInTheCorner().equals(CellPosition.TOP_RIGHT)) {
            if (grid[targetRow][targetCol-1] == 1) {
                count++;
            }

            if (grid[targetRow+1][targetCol-1] == 1) {
                count++;
            }

            if (grid[targetRow+1][targetCol] == 1) {
                count++;
            }

            return count;
        }
       return 0;
    }

    @Override
    public CellPosition checkIfTargetCellIsInTheCorner() {
        if(targetRow == 0 && targetCol == 0) {
            return CellPosition.TOP_LEFT;
        }

        if(targetRow == 0 && targetCol == width-1) {
            return CellPosition.TOP_RIGHT;
        }

        if(targetRow == height-1 && targetCol == 0) {
            return CellPosition.BOTTOM_LEFT;
        }

        if(targetRow == height-1 && targetCol == width-1) {
            return CellPosition.BOTTOM_RIGHT;
        }

        return null;
    }

    @Override
    public CellPosition checkIfTargetCellIsOnTheSides() {

        if(targetRow == 0 && targetCol != 0 && targetCol != width-1) {
            return CellPosition.TOP;
        }

        if(targetRow == height-1 && targetCol != 0 && targetCol != width-1) {
            return CellPosition.BOTTOM;
        }

        if(targetCol == 0 && targetRow != 0 && targetRow != height-1) {
            return CellPosition.LEFT;
        }

        if(targetCol == width-1 && targetRow != 0 && targetRow != height-1) {
            return CellPosition.RIGHT;
        }

        return null;
    }

     /* private boolean gggg(int x, int y, int width, int length) {
        if(y==0 && x!=0 && x!=length-1) {
            return true;
        }

        if(y==width-1 && x!=0 && x!=length-1) {
            return true;
        }
        return false;
    }*/


}
