package com.company;

import java.util.List;

public class OperationResponceMult {
    final public List<List<Double>> result;
    final public String errorMsg;

    public OperationResponceMult() {
        this(null, null);
    }

    public OperationResponceMult(List<List<Double>> result, String errorMsg) {
        this.result = result;
        this.errorMsg = errorMsg;
    }

    public OperationResponceMult(List<List<Double>> result) {
        this(result, null);
    }

    public OperationResponceMult(String errorMsg) {
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
