package com.dim0va;

interface Rule {
    int countSurroundingGreenNeighbours();
    CellPosition checkIfTargetCellIsInTheCorner();
    CellPosition checkIfTargetCellIsOnTheSides();
}
