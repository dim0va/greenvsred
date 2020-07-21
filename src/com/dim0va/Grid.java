package com.dim0va;

public class Grid {
    private int height;
    private int width;
    private int [][] content;

  /*  public void generationZero ()
    {
        boolean isInputCorrect ;
        int enteredNumber;

        //User should enter only zeroes and ones. The interval is [0,2)
        CorrectNumberChecker checker = new CorrectNumberChecker(0,2);

        int gridHeight = grid.getHeight();
        int gridWidth = grid.getWidth();
        char [][] gridArray = grid.getGridContent();
        for(int i=0;i<gridHeight;i++)
        {
            for (int j=0;j<gridWidth;j++)
            {
                do {
                    System.out.println("grid[" + i + "][" + j + "] = ");
                    try {
                        enteredNumber = (char) scan.nextInt();
                        isInputCorrect = checker.check(enteredNumber);
                        if(!isInputCorrect)
                            System.out.println("The entered number is out of the specified range! Please try again!");
                        else
                        {
                            if(enteredNumber == 1)
                                gridArray[i][j] = '1';
                            else
                                gridArray[i][j] = '0';
                        }
                        //Reading enter key press from buffer
                        scan.nextLine();

                    } catch (NoSuchElementException e) {
                        //Reading enter key press from buffer
                        scan.nextLine();
                        System.out.println("Invalid input! Please try again!");
                        isInputCorrect = false;
                    }
                }while (!isInputCorrect);
            }
        }
    }*/
}
