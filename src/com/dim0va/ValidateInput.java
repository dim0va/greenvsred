package com.dim0va;

public class ValidateInput {
    private int cols;
    private int rows;
    private int targetCol;
    private int targetRow;

    public ValidateInput(int cols, int rows, int targetCol, int targetRow) {
        this.cols = cols;
        this.rows = rows;
        this.targetCol = targetCol;
        this.targetRow = targetRow;
    }

    public boolean areElementsValid(String [] content) {
        if(!isWidthAndHeightValid(cols, rows)) {
            return false;
        }

        //checking if the target cell is in bounds
        if(targetCol>(cols-1) || targetRow>(rows-1)) {
            return false;
        }

        //going through each string element in the array
        for (String element : content) {
            //checking if each element's length = width
            if(element.length() != cols) {
                return false;
            }

            //going through each char of the string
            for (char c : element.toCharArray()) {
                int digit = Character.getNumericValue(c);

                //checking if this digit is either one or zero
                if(!(digit==0 || digit == 1)) {
                    return false;
                }
            }
        }
       return true;
    }

    //method for checking if the width and height of the matrix is in bounds
    private boolean isWidthAndHeightValid (int width, int height) {
        return width > 0 && width <= height && height < 1000;
    }
}
