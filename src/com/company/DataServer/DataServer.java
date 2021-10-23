package com.company.DataServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.RandomAccess;
import java.util.StringJoiner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataServer {
    public static void main(String[] args) throws IOException {
        System.out.println("start server");
        final ExecutorService executorService = Executors.newCachedThreadPool();
        final ServerSocket serverSocket = new ServerSocket(4444);
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                executorService.submit(() -> {
                    try {
                        handleConnection(clientSocket.getInputStream(), clientSocket.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleConnection(InputStream socketInputStream, OutputStream socketOutputStream) throws IOException{

        System.out.println("[begin] handle connection");
        DataInputStream inputStream = new DataInputStream(socketInputStream);
        DataOutputStream outputStream = new DataOutputStream(socketOutputStream);
        final String matrixType = inputStream.readUTF();
        System.out.println("received Type:" + matrixType);
        final double seed = inputStream.readDouble();
        System.out.println("received seed:" + seed);
        final double count = inputStream.readDouble();
        System.out.println("received count:" + count);
        StringJoiner result = new StringJoiner(",");
        if(matrixType.equals("one"))
        {
            for(int i = 0; i < count; i++)
            {
                result.add(Double.toString(1.0));
            }
        }
        if(matrixType.equals("asc"))
        {
            for(int i = 0; i < count; i++)
            {
                result.add(Double.toString(i));
            }
        }
        else {
            Random generator = new Random((long) seed);
            for (int i = 0; i < count; i++) {
                result.add(Double.toString(generator.nextDouble() * 10));
            }
        }
        System.out.println("send result: " + result);
        outputStream.writeUTF(String.valueOf(result));
        System.out.println("[end] handle connection");
    }
}
