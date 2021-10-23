package com.company.Client;

import com.company.OperationRequestMult;
import com.company.OperationRequestSum;
import com.company.OperationRequestView;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class Client {

    public static void main(String[] args) throws IOException {

        boolean cont = true;
        int operation;
        Scanner in = new Scanner(System.in);
        while(cont)
        {
            System.out.println("Choose operation:\n 1.View \n 2.Sum \n 3.Mult");
            operation = in.nextInt();
            switch (operation) {
                case 1:
                    double seed = 0;
                    System.out.println("Input matrix type: ");
                    String matrixTypeView = "";
                    int inChar;
                    try {
                        inChar = System.in.read();
                        while (System.in.available() > 0) {
                            matrixTypeView += (char) inChar;
                            inChar = System.in.read();
                        }
                    } catch (IOException e) {
                        System.out.println("Ошибка");
                    }

                    if (!matrixTypeView.equals("one") && !matrixTypeView.equals("asc")) {

                        System.out.println("Input seed: ");
                         seed = in.nextDouble();
                    }
                    System.out.println("Input rows count: ");
                    int rows = in.nextInt();
                    System.out.println("Input columns count: ");
                    int columns = in.nextInt();

                    OperationRequestView requestView = new OperationRequestView(seed, matrixTypeView, rows, columns);
                    String resultView = "";
                    try {
                        resultView = Query.postView(requestView);
                    }catch(java.net.ConnectException e)
                    {
                        e.printStackTrace();
                    }catch (java.io.IOException e)
                    {
                        e.printStackTrace();
                    }

                    String statusView = "";
                    try {
                        statusView = resultView.substring(0, 3);
                    }catch(java.lang.StringIndexOutOfBoundsException e)
                    {
                        e.printStackTrace();
                    }
                    try {
                        resultView = resultView.substring(3, resultView.length());
                    }catch(java.lang.StringIndexOutOfBoundsException e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println("Status: " + statusView);
                    System.out.println("Matrix: " + resultView);

                    break;
                case 2:
                    double seed1 = 0;
                    double seed2 = 0;
                    System.out.println("Input matrix1 type: ");
                    String matrixTypeSum1 = "";
                    int inCharSum1;
                    try {
                        inCharSum1 = System.in.read();
                        while (System.in.available() > 0) {
                            matrixTypeSum1 += (char) inCharSum1;
                            inCharSum1 = System.in.read();
                        }
                    } catch (IOException e) {
                        System.out.println("Ошибка");
                    }
                    if (!matrixTypeSum1.equals("one") && !matrixTypeSum1.equals("asc")) {
                        System.out.println("Input seed1: ");
                        seed1 = in.nextDouble();
                    }
                    System.out.println("Input matrix2 type: ");
                    String matrixTypeSum2 = "";
                    int inCharSum2;
                    try {
                        inCharSum2 = System.in.read();
                        while (System.in.available() > 0) {
                            matrixTypeSum2 += (char) inCharSum2;
                            inCharSum2 = System.in.read();
                        }
                    } catch (IOException e) {
                        System.out.println("Ошибка");
                    }
                    if (!matrixTypeSum2.equals("one") && !matrixTypeSum2.equals("asc")) {
                        System.out.println("Input seed2: ");
                        seed2 = in.nextDouble();
                    }
                    System.out.println("Input rows count: ");
                    int rowSum = in.nextInt();
                    System.out.println("Input columns count: ");
                    int columnSum = in.nextInt();

                    OperationRequestSum requestSum = new OperationRequestSum(seed1, seed2, matrixTypeSum1, matrixTypeSum2,  rowSum, columnSum);
                    String resultSum = "";
                    try {
                        resultSum = Query.postSum(requestSum);
                    }catch (java.net.ConnectException e)
                    {
                        e.printStackTrace();
                    }catch (java.io.IOException e)
                    {
                        e.printStackTrace();
                    }
                    String statusSum = "";
                    try {
                        statusSum = resultSum.substring(0, 3);
                    }catch (java.lang.StringIndexOutOfBoundsException e)
                    {
                        e.printStackTrace();
                    }
                    try {
                        resultSum = resultSum.substring(3, resultSum.length());
                    }catch (java.lang.StringIndexOutOfBoundsException e)
                    {
                        e.printStackTrace();
                    }

                    System.out.println("Status: " + statusSum);
                    System.out.println("Matrix: " + resultSum);

                    break;
                case 3:
                    double seedMult1 = 0;
                    double seedMult2 = 0;
                    System.out.println("Input matrix1 type: ");
                    String matrixTypeMult1 = "";
                    int inCharMult1;
                    try {
                        inCharMult1 = System.in.read();
                        while (System.in.available() > 0) {
                            matrixTypeMult1 += (char) inCharMult1;
                            inCharMult1 = System.in.read();
                        }
                    } catch (IOException e) {
                        System.out.println("Ошибка");
                    }
                    if (!matrixTypeMult1.equals("one") && !matrixTypeMult1.equals("asc")) {
                        System.out.println("Input seed1: ");
                        seed1 = in.nextDouble();
                    }

                    System.out.println("Input matrix2 type: ");
                    String matrixTypeMult2 = "";
                    int inCharMult2;
                    try {
                        inCharMult2 = System.in.read();
                        while (System.in.available() > 0) {
                            matrixTypeMult2 += (char) inCharMult2;
                            inCharMult2 = System.in.read();
                        }
                    } catch (IOException e) {
                        System.out.println("Ошибка");
                    }
                    if (!matrixTypeMult2.equals("one") && !matrixTypeMult2.equals("asc")) {
                        System.out.println("Input seed2: ");
                        seed2 = in.nextDouble();
                    }

                    System.out.println("Input rows count: ");
                    int rowMult = in.nextInt();
                    System.out.println("Input columns count: ");
                    int columnMult = in.nextInt();

                    OperationRequestMult requestMult = new OperationRequestMult(seedMult1, seedMult2, matrixTypeMult1, matrixTypeMult2, rowMult, columnMult);
                    String resultMult = "";
                    try {
                     resultMult = Query.postMult(requestMult);
                    }catch (java.net.ConnectException e)
                    {
                        e.printStackTrace();
                    }catch (java.io.IOException e)
                    {
                        e.printStackTrace();
                    }
                    String statusMult = "";
                    try {
                        statusMult = resultMult.substring(0, 3);
                    }catch (java.lang.StringIndexOutOfBoundsException e)
                    {
                        e.printStackTrace();
                    }

                    try {
                        resultMult = resultMult.substring(3, resultMult.length());
                    }catch (java.lang.StringIndexOutOfBoundsException e)
                    {
                        e.printStackTrace();
                    }

                    System.out.println("Status: " + statusMult);
                    System.out.println("Matrix: " + resultMult);

                    break;
                case 4:
                    System.out.println(Query.getView());
                    break;
                default:
                    break;
            }
            System.out.println("Do you want to continue? \n 1.Yes \n 2.No \n ");
            operation = in.nextInt();
            if(operation != 1)
            {
                cont = false;
            }
        }
        in.close();
    }
}
