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

        if(targetCol>cols || targetRow>rows) {
            return false;
        }

        for (String element : content) {
            if(element.length() != cols) {
                return false;
            }

            for (char c : element.toCharArray()) {
                int digit = Character.getNumericValue(c);
                if(!(digit==0 || digit == 1)) {
                    return false;
                }
            }
        }
       return true;
    }

    private boolean isWidthAndHeightValid (int width, int height) {
        return width > 0 && width <= height && height < 1000;
    }
}
