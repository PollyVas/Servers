package com.company.Client;


import com.company.OperationRequestMult;
import com.company.OperationRequestSum;
import com.company.OperationRequestView;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Query {
    public static String getView() throws IOException {
        URL url = null;
        Map<String, String> parameters = new HashMap<>();
        parameters.put("operation", "view");
        try {
            url = new URL("http://localhost/api?" + ParameterStringBuilder.getParamsString(parameters));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;

        try {
            http.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        http.setDoOutput(true);

        int status = http.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        http.disconnect();
        String str = Integer.toString(status) + content;
        return str;
    }
    public static String postView(OperationRequestView postView) throws IOException {
        URL url = null;
        Map<String, String> parameters = new HashMap<>();
        parameters.put("operation", "view");
        try {
            url = new URL("http://localhost/api?" + ParameterStringBuilder.getParamsString(parameters));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;

        try {
            http.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        http.setDoOutput(true);

        Gson gson = new Gson();
        byte[] out = gson.toJson(postView).getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        try {
            http.connect();
        }catch(java.net.ConnectException e)
        {
            e.printStackTrace();
        }
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }catch(java.net.ConnectException e)
        {
            e.printStackTrace();
        }
        int status = 0;
        try {
             status = http.getResponseCode();
        }catch(java.net.ConnectException e)
        {
            e.printStackTrace();
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        http.disconnect();
        String str = Integer.toString(status) + content;
        return str;
    }
    public static String postSum(OperationRequestSum postSum) throws IOException {
        URL url = null;
        Map<String, String> parameters = new HashMap<>();
        parameters.put("operation", "sum");
        try {
            url = new URL("http://localhost/api?" + ParameterStringBuilder.getParamsString(parameters));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;

        try {
            http.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        http.setDoOutput(true);

        Gson gson = new Gson();
        byte[] out = gson.toJson(postSum).getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        try{
            http.connect();
        }catch (java.net.ConnectException e)
        {
            e.printStackTrace();
        }
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }catch (java.net.ConnectException e)
        {
            e.printStackTrace();
        }

        int status = http.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        http.disconnect();
        String str = Integer.toString(status) + content;
        return str;
    }
    public static String postMult(OperationRequestMult postMult) throws IOException {
        URL url = null;
        Map<String, String> parameters = new HashMap<>();
        parameters.put("operation", "mult");
        try {
            url = new URL("http://localhost/api?" + ParameterStringBuilder.getParamsString(parameters));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection con = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)con;

        try {
            http.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        http.setDoOutput(true);

        Gson gson = new Gson();
        byte[] out = gson.toJson(postMult).getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        http.setFixedLengthStreamingMode(length);
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        try {
            http.connect();
        }catch (java.net.ConnectException e)
        {
            e.printStackTrace();
        }
        try(OutputStream os = http.getOutputStream()) {
            os.write(out);
        }
        int status = http.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        http.disconnect();
        String str = Integer.toString(status) + content;
        return str;
    }
}
