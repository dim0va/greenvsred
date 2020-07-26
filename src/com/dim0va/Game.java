package com.dim0va;

public class Game {
    private int columns;
    private int rows;
    private int targetCol;
    private int targetRow;
    private int numberOfGenerations;
    private String [] initialGrid;
    private int [][] grid;

    public Game(int columns, int rows, int targetCol, int targetRow, int numberOfGenerations,
                String[] initialGrid, int[][] grid) {
        this.columns = columns;
        this.rows = rows;
        this.targetCol = targetCol;
        this.targetRow = targetRow;
        this.numberOfGenerations = numberOfGenerations;
        this.initialGrid = initialGrid;
        this.grid = grid;
    }

    public void createGenerationZero() {
        ValidateInput validateInput = new ValidateInput(columns, rows, targetCol, targetRow);

        if(!validateInput.areElementsValid(initialGrid)) {
            System.err.println("The elements that you have entered are not valid! Try again!");
            return;
        }

        grid = transformGrid(initialGrid);
    }

    //transforms 1D-array (from the input) to 2D-array
    private int[][] transformGrid (String [] initialGrid) {
        int[][] transformedGrid = new int[rows][columns];

        //putting each char of every string element of the initialGrid to a 2d-array (matrix)
        for (int i = 0; i < initialGrid.length; i++) {
            for(int j = 0, n = initialGrid[i].length() ; j < n ; j++) {
                int element = Character.getNumericValue(initialGrid[i].charAt(j));
                transformedGrid[i][j] = element;
            }
        }
        return transformedGrid;
    }

    public void start() {
        Rule redCellRule = new RedCellRule(targetRow, targetCol);
        Rule greenCellRule = new GreenCellRule(targetRow, targetCol);

        int generationsPassed = 0;
        int timesBeenGreen = 0;
        NewElement newElement;

        //check the target cell's initial value if it's one
        if(grid[targetRow][targetCol]==1) {
            timesBeenGreen = 1;
        }

        //while loop to keep track of passed generations
        while (generationsPassed < numberOfGenerations) {
            //buffer matrix for storing values for the next generation
            int [][] nextGrid = new int [rows][columns];

            //going through each element of the matrix
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {

                    //checking the value of the element
                    //depending on the value a different set of rules are applied
                    if(grid[row][col] == 1) {

                        //an object of type NewElement is return
                        newElement = greenCellRule.applyRules(row, col, grid);
                    } else {
                        newElement = redCellRule.applyRules(row, col, grid);
                    }

                    //storing the new value in the buffer matrix
                    nextGrid[row][col] = newElement.getElement();

                    //and increase the amount of time the target cell was green
                    if(newElement.getGreen()) {
                        timesBeenGreen ++;
                    }
                }
            }
            //mark that the generation has been passed
            generationsPassed++;

            //we give the grid the new values from the buffer matrix
            //and continue working with them in the next generation
            grid = nextGrid.clone();
        }

        System.out.println(String.format("The cell with coordinates (%s : %s) was green %s times during the generations (including Generation Zero)",
                targetRow, targetCol, timesBeenGreen));
    }
}
