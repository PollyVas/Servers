package com.company.CalculationServer;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

public class TCPclient {
    public static String callServer(double seed, String matrixType, int count)
    {
        try (Socket socket = new Socket("localhost", 4444)) {
            return handleConnection(socket.getInputStream(), socket.getOutputStream(), seed, matrixType, count);
        } catch (UnknownHostException e) {
            System.err.println("unknown host");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String handleConnection(InputStream socketInputStream, OutputStream socketOutputStream, double seed, String matrixType, int count) throws IOException {

        DataInputStream inputStream = new DataInputStream(socketInputStream);
        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(socketOutputStream));
        //Scanner scanner = new Scanner(System.in);
        outputStream.writeUTF(matrixType);
        outputStream.writeDouble(seed);
        outputStream.writeDouble(count);
        try {
            outputStream.flush();
        }
        catch (java.net.ConnectException e)
        {
            e.printStackTrace();
        }
        String result = inputStream.readUTF();
        return result;
    }
}
