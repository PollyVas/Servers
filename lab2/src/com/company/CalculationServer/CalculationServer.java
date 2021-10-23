package com.company.CalculationServer;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

import java.net.InetSocketAddress;

public class CalculationServer {
    public static void main(String[] args) throws IOException {
        final HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 80), 0);
        server.createContext("/api", new MyHttpHandler());
        server.start();
    }
}
