package com.company;

import java.util.List;

public class OperationResponceView {

    final public List<List<Double>> result;
    final public String errorMsg;

    public OperationResponceView() {
        this(null, null);
    }

    public OperationResponceView(List<List<Double>> result, String errorMsg) {
        this.result = result;
        this.errorMsg = errorMsg;
    }
    public OperationResponceView(List<List<Double>> result) {
        this(result, null);
    }
    public OperationResponceView(String errorMsg) {
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
