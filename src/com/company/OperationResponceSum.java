package com.company;

import java.util.List;

public class OperationResponceSum {

    final public List<List<Double>> result;
    final public String errorMsg;

    public OperationResponceSum() {
        this(null, null);
    }

    public OperationResponceSum(List<List<Double>> result, String errorMsg) {
        this.result = result;
        this.errorMsg = errorMsg;
    }
    public OperationResponceSum(List<List<Double>> result) {
        this(result, null);
    }
    public OperationResponceSum(String errorMsg) {
        this(null, errorMsg);
    }

    @Override
    public String toString() {
        return "OperationResponceSum{" +
                "result=" + result +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
