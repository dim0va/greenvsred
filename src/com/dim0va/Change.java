package com.dim0va;

public class Change {
    private int timesBeenGreen;
    private int element;

    public Change(int timesBeenGreen, int element) {
        this.timesBeenGreen = timesBeenGreen;
        this.element = element;
    }

    public int getTimesBeenGreen() {
        return timesBeenGreen;
    }

    public int getElement() {
        return element;
    }
}
