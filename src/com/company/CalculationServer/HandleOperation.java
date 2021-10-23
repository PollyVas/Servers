package com.company.CalculationServer;

import com.company.*;

import java.util.ArrayList;
import java.util.List;

public class HandleOperation {
    public static OperationResponceSum handleOperationSum(OperationRequestSum request) {
        if (request.seed1 < 0 || request.seed2 < 0 || request.columnCount < 0 || request.rowsCount < 0) {
            return new OperationResponceSum("numbers must be positive");
        }
        String str1 = TCPclient.callServer(request.seed1, request.matrixType1, request.columnCount * request.rowsCount);
        String str2 = TCPclient.callServer(request.seed2, request.matrixType2, request.columnCount * request.rowsCount);
        List<List<Double>> matr1 = Decoder.fromStringToArr(str1, request.rowsCount, request.columnCount);
        List<List<Double>> matr2 = Decoder.fromStringToArr(str2, request.rowsCount, request.columnCount);
        List<List<Double>> result = new ArrayList<>();
        List<Double> row;
        List<Double> row1;
        List<Double> row2;
        for (int i = 0; i < request.rowsCount; i++)
        {
            row = new ArrayList<Double>();
            row1 = matr1.get(i);
            row2 = matr2.get(i);
            for (int j = 0; j < request.columnCount; j++)
            {
                row.add(row1.get(j) + row2.get(j));
            }
            result.add(row);
        }
        return new OperationResponceSum(result);
    }
    public static OperationResponceMult handleOperationMult(OperationRequestMult request)
    {
        if (request.seed1 < 0 || request.seed2 < 0 || request.columnCount < 0 || request.rowsCount < 0) {
            return new OperationResponceMult("numbers must be positive");
        }
        String str1 = TCPclient.callServer(request.seed1, request.matrixType1, request.columnCount * request.rowsCount);
        String str2 = TCPclient.callServer(request.seed2, request.matrixType2, request.columnCount * request.rowsCount);
        List<List<Double>> matr1 = Decoder.fromStringToArr(str1, request.rowsCount, request.columnCount);
        List<List<Double>> matr2 = Decoder.fromStringToArr(str2, request.columnCount, request.rowsCount);
        List<List<Double>> result = new ArrayList<>();
        List<Double> row;
        List<Double> row1;
        List<Double> row2;
        double sum = 0;
        for (int i = 0; i < request.rowsCount; i++)
        {
            row = new ArrayList<Double>();
            row1 = matr1.get(i);
            for (int j = 0; j < request.rowsCount; j++)
            {
                sum = 0;
                for(int k = 0; k < request.columnCount; k++)
                {
                    row2 = matr2.get(k);
                    sum += row1.get(k)*row2.get(j);
                }
                row.add(sum);
            }
            result.add(row);
        }
        return new OperationResponceMult(result);
    }
    public static OperationResponceView handleOperationView(OperationRequestView request)
    {
        if (request.seed < 0 || request.columnCount < 0 || request.rowsCount < 0) {
            return new OperationResponceView("numbers must be positive");
        }
        String str = TCPclient.callServer(request.seed, request.matrixType, request.columnCount * request.rowsCount);

        return new OperationResponceView(Decoder.fromStringToArr(str, request.rowsCount, request.columnCount));
    }

}
