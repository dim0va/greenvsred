package com.dim0va;

public class Change {
    private int countChanges;
    private int element;

    public Change(int countChanges, int element) {
        this.countChanges = countChanges;
        this.element = element;
    }

    public Change() {
    }

    public int getCountChanges() {
        return countChanges;
    }

    public int getElement() {
        return element;
    }
}
