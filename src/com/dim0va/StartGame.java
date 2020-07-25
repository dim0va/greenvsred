package com.dim0va;

import java.util.Scanner;

public class StartGame {
    private int columns;
    private int rows;
    private int targetCol;
    private int targetRow;
    private int numberOfGenerations;
    private String [] initialGrid;
    private int [][] grid;
    private int [][] nextGrid;
    private Scanner scanner = new Scanner(System.in);

    public void init () {

        System.out.print("Enter the number of columns in the grid (<= height): ");
        columns = scanner.nextInt();

        System.out.print("Enter the number of rows in the grid: ");
        rows = scanner.nextInt();

        System.out.println(String.format("Enter %s elements (%s-digits long) of the grid: ", rows, columns));

        //Initialize the arrays
        initialGrid = new String [rows];
        grid = new int [rows][columns];
        nextGrid = new int [rows][columns];

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

        ValidateInput validator = new ValidateInput(columns, rows, targetCol, targetRow);

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
        Rule redCellRule = new RedCellRule(targetRow, targetCol);
        Rule greenCellRule = new GreenCellRule(targetRow, targetCol);

        int generationsPassed = 0;
        int timesBeenGreen = 0;
        Change change;

        if(grid[targetRow][targetCol]==1) {
            timesBeenGreen = 1;
        }

        System.out.println("Initial: ");
        for (int [] element : grid ) {
            for ( int element2 : element) {
                System.out.print(element2);
            }
            System.out.println();
        }
        System.out.println();

        while (generationsPassed < numberOfGenerations) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {

                    if(grid[row][col] == 1) {
                        change = greenCellRule.applyRules(row, col, grid);
                    } else {
                        change = redCellRule.applyRules(row, col, grid);
                    }

                    nextGrid[row][col] = change.getElement();
                    timesBeenGreen += change.getTimesBeenGreen();
                }
            }

            for (int [] element : nextGrid) {
                for ( int element2 : element) {
                    System.out.print(element2);
                }
                System.out.println();
            }
            System.out.println();

            generationsPassed++;
            grid = nextGrid.clone();
        }


        System.out.println(String.format("The cell with coordinates (%s : %s) was green %s times (including its initial value)",
                targetRow, targetCol, timesBeenGreen));
    }
}
