package com.dim0va;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of columns in the grid (<= rows): ");
        int columns = scanner.nextInt();

        System.out.print("Enter the number of rows in the grid: ");
        int rows = scanner.nextInt();

        System.out.println(String.format("Enter %s elements (%s-digits long) of the grid: ", rows, columns));

        //Declare and initialize the arrays
        String [] initialGrid = new String [rows];
        int [][] grid = new int [rows][columns];

        //for input the next lines (=rows) of strings
        for(int i = 0; i < rows; i++ ) {
            initialGrid[i] = scanner.next();
        }

        System.out.println("Enter coordinates of a cell in the grid (row:column): ");
        System.out.print("x: ");
        int targetRow = scanner.nextInt();

        System.out.print("y: ");
        int targetCol = scanner.nextInt();

        System.out.print("Enter a number of generations: ");
        int numberOfGenerations = scanner.nextInt();

        StartGame startGame = new StartGame(columns, rows, targetCol, targetRow, numberOfGenerations,
                                            initialGrid, grid);
        startGame.generationZero();
        startGame.startGame();
    }
}
