package com.dim0va;

import java.util.Scanner;

public class StartGame {
    int columns;
    int rows;
    int numberOfGenerations;
    String [] initialGrid;
    int [][] grid;
    int [][] mockGrid;
    int targetCol;
    int targetRow;
    Scanner scanner = new Scanner(System.in);

    public void init () {

        System.out.print("Enter the number of columns in the grid (<= height): ");
        columns = scanner.nextInt();

        System.out.print("Enter the number of rows in the grid: ");
        rows = scanner.nextInt();

        System.out.println(String.format("Enter %s elements (%s-digits long) of the grid: ", rows, columns));

        //Initialize the arrays
        initialGrid = new String [rows];
        grid = new int [rows][columns];
        mockGrid = new int [rows][columns];

        for(int i = 0; i < rows; i++ ) {
            initialGrid[i] = scanner.next();
        }

        System.out.println("Enter coordinates of a cell in the grid: ");
        System.out.print("x: ");
        targetRow = scanner.nextInt();

        System.out.print("y: ");
        targetCol = scanner.nextInt();

        System.out.print("Enter a number of generations: ");
        numberOfGenerations = scanner.nextInt();

        ValidateInput validator = new ValidateInput(columns, rows);

        if(!validator.areElementsValid(initialGrid)) {
            System.err.println("The elements that you have entered are not valid! Try again!");
            return;
        }

        grid = transformGrid(initialGrid);

        startGame();
    }

    //transforms 1D-array (from the input) to 2D-array
    private int[][] transformGrid (String [] initialGrid) {
        int[][] transformedGrid = new int[rows][columns];

        //substringing the elements
        for (int i = 0; i < initialGrid.length; i++) {
            for(int j = 0, n = initialGrid[i].length() ; j < n ; j++) {
                int element = Character.getNumericValue(initialGrid[i].charAt(j));
                transformedGrid[i][j] = element;
            }
        }
        return transformedGrid;
    }

    private void startGame() {
        RedCellRule redCellRule = new RedCellRule(targetRow, targetCol, grid);
        GreenCellRule greenCellRule = new GreenCellRule(targetRow, targetCol, grid);

        int generationsPassed = 0;
        int countChanges = 0;
        Change change;

        while (generationsPassed < numberOfGenerations) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {

                    if(grid[row][col]==1) {
                        change = greenCellRule.applyRule(row, col);
                    } else {
                        change = redCellRule.applyRule(row, col);
                    }

                    mockGrid[row][col] = change.getElement();
                    countChanges = change.getCountChanges();
                }
            }
            generationsPassed++;
            grid = mockGrid;
        }

        System.out.println(String.format("The cell with coordinates (%s : %s) has changed to green cell %s times",
                targetRow, targetCol, countChanges));
    }
}
