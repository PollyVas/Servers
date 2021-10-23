package com.company;

public class OperationRequestMult {
    final public double seed1;
    final public double seed2;
    final public String matrixType1;
    final public String matrixType2;
    final public int rowsCount;
    final public int columnCount;

    public OperationRequestMult() {
        this.seed1 = 0.0;
        this.seed2 = 0.0;
        this.matrixType1 = "one";
        this.matrixType2 = "one";
        this.rowsCount = 0;
        this.columnCount = 0;
    }

    public OperationRequestMult(double seed1, double seed2, String matrixType1, String matrixType2, int rowsCount, int columnCount) {
        this.seed1 = seed1;
        this.seed2 = seed2;
        this.matrixType1 = matrixType1;
        this.matrixType2 = matrixType2;
        this.rowsCount = rowsCount;
        this.columnCount = columnCount;
    }

    @Override
    public String toString() {
        return "OperationRequest{" +
                "seed1=" + seed1 +
                ", seed2=" + seed2 +
                '}';
    }
}
