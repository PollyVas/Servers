package com.company;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NetworkUtils {
    public static Map<String, String> queryToMap(String query) {
        if (query == null) {
            return Collections.emptyMap();
        }
        final Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            } else {
                result.put(entry[0], "");
            }
        }
        return result;
    }
    public static String readInputStreamAsString(InputStream inputStream, Charset charset) throws IOException {
        byte[] buffer = new byte[1024];
        return readInputStream(inputStream, buffer).toString(charset);
    }
    public static byte[] readInputStreamAsBytes(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        return readInputStream(inputStream, buffer).toByteArray();
    }
    public static ByteArrayOutputStream readInputStream(InputStream inputStream, byte[] buffer) throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return baos;
    }
}
