package com.company.CalculationServer;

import java.util.ArrayList;
import java.util.List;

public class Decoder {
    public static List<List<Double>> fromStringToArr(String str, int rows, int columns)
    {
        List<List<Double>> matr = new ArrayList<>();
        String[] st = str.split(",");
        List<Double> row;
        for (int i = 0; i < rows; i++)
        {
            row = new ArrayList<Double>();
            for (int j = 0; j < columns; j++)
            {
                row.add(Double.parseDouble(st[i*columns + j]));
            }
            matr.add(row);
        }
        return matr;
    }
}
