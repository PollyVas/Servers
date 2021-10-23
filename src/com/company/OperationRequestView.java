package com.company;

public class OperationRequestView {

    final public double seed;
    final public String matrixType;
    final public int rowsCount;
    final public int columnCount;

    public OperationRequestView()
    {
        this.seed = 0.0;
        this.matrixType = "one";
        this.columnCount = 0;
        this.rowsCount = 0;
    }
    public OperationRequestView(double seed, String matrixType, int rowsCount, int columnCount)
    {
        this.seed = seed;
        this.matrixType = matrixType;
        this.rowsCount = rowsCount;
        this.columnCount = columnCount;
    }
    @Override
    public String toString()
    {
        return "OperationRequest{" +
                "seed1=" + seed +
                '}';
    }
}
