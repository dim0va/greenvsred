package com.dim0va;

public class ValidateInput {
    private int width;
    private int height;

    public ValidateInput(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean areElementsValid(String [] content) {
        if(!isWidthAndHeightValid(width, height)) {
            return false;
        }

        for (String element : content) {
            if(element.length() != width) {
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
