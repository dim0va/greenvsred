package com.dim0va;

import java.util.Scanner;

public class StartGame {
    int width;
    int height;
    int numberOfGenerations;
    int [] grid = new int[1000];
    int targetCol;
    int targetRow;
    Scanner scanner = new Scanner(System.in);

    public void init () {

        System.out.print("Enter grid's width (<= height): ");
        width = scanner.nextInt();

        System.out.print("Enter grid's height: ");
        height = scanner.nextInt();

        System.out.println(String.format("Enter %s elements (%s-digits long) of the grid: ", height, width));

        for(int i = 0; i < height; i++ ) {
            grid[i] = scanner.nextInt();
        }

        System.out.println("Enter coordinates of a cell in the grid: ");
        System.out.print("x: ");
        targetRow = scanner.nextInt();

        System.out.print("y: ");
        targetCol = scanner.nextInt();

        System.out.print("Enter number of generations: ");
        numberOfGenerations = scanner.nextInt();

        ValidateInputNumbers validator = new ValidateInputNumbers(width, height);
        if(!validator.areNumbersValid(grid)) {
            System.err.println("Numbers you have entered are not valid! Try again!");
        }

        startGame();
    }

    private void startGame() {
        int countGenerations = 0;
        while (countGenerations<=numberOfGenerations) {
            

        }
    }
}
