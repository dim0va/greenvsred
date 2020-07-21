package com.dim0va;

public class ValidateInputNumbers {
    private int width;
    private int height;

    public ValidateInputNumbers(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean areNumbersValid (int [] content) {
        if(content.length != height) {
            return false;
        }

        for (int number : content) {
            int count = 0;
            while(number != 0)
            {
                if(!isBinary(number)) {
                    return false;
                }

                number /= 10;
                count++;
            }

            if(count==width) {
                return true;
            }
        }
        return false;
    }

    private boolean isBinary (int number) {
        while(number != 0) {
            if (number % 10 > 1) {
                return false;
            }
            number /= 10;
        }
        return true;
    }

}
