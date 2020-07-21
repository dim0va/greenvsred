package com.dim0va;

import java.util.Scanner;

public class StartGame {
    int width;
    int height;
    int numberOfGenerations;
    int [] initialGrid;
    int [][] grid;
    int targetCol;
    int targetRow;
    Scanner scanner = new Scanner(System.in);

    public void init () {

        System.out.print("Enter grid's width (<= height): ");
        width = scanner.nextInt();

        System.out.print("Enter grid's height: ");
        height = scanner.nextInt();

        System.out.println(String.format("Enter %s elements (%s-digits long) of the grid: ", height, width));

        //Initialize the arrays
        initialGrid = new int [width];
        grid = new int [width] [height];

        for(int i = 0; i < height; i++ ) {
            initialGrid[i] = scanner.nextInt();
        }

        System.out.println("Enter coordinates of a cell in the grid: ");
        System.out.print("x: ");
        targetRow = scanner.nextInt();

        System.out.print("y: ");
        targetCol = scanner.nextInt();

        System.out.print("Enter number of generations: ");
        numberOfGenerations = scanner.nextInt();

        ValidateInputNumbers validator = new ValidateInputNumbers(width, height);
        if(!validator.areNumbersValid(initialGrid)) {
            System.err.println("Numbers you have entered are not valid! Try again!");
        }

        transformGrid(initialGrid);
        startGame();
    }

    //this method transform 1D-array (from the input) to 2D-array
    private void transformGrid (int [] initialGrid) {
        for (int row = 0; row < width; row++) {
            int number = initialGrid[row];

            int divider = 1;
            for(int i=1; i<width; i++) {
                divider = divider * 10;
            }

            for(int col = 0 ; col < height; col++) {
                int digit = number/divider;
                grid[row][col] = digit;
                number %= divider;
                divider /= 10;
            }
        }
    }

    private void startGame() {
        int countGenerations = 0;
        int countChanges = 0;
        RedRule redRule = new RedRule(targetRow, targetCol, width, height);

        while (countGenerations<=numberOfGenerations) {

            if(redRule.countSurroundingGreenNeighbours()==3 || redRule.countSurroundingGreenNeighbours()==6) {
                grid[targetRow][targetCol] = 0;
                countChanges++;
            }

            if(redRule.checkIfTargetCellIsOnTheSides()) {
                //actions for side cell
            }
        }
    }
}
