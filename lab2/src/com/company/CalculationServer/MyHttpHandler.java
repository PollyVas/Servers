package com.company.CalculationServer;

import com.company.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyHttpHandler implements HttpHandler{
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            StringBuilder builder = new StringBuilder();
            Map<String, String> params = NetworkUtils.queryToMap(exchange.getRequestURI().getQuery());
            int statusCode;

            switch (exchange.getRequestMethod()) {
                case "GET": {
                    switch (params.getOrDefault("operation", "")) {
                        case "view": {
                            builder.append("view");
                            statusCode = 200;
                            break;
                        }
                        default: {
                            builder.append("unknown get");
                            statusCode = 404;
                            break;
                        }
                    }
                    break;
                }
                case "POST": {
                    switch (params.getOrDefault("operation", "")) {
                        case "view":
                            final String body1 = NetworkUtils.readInputStreamAsString(
                                    exchange.getRequestBody(),
                                    StandardCharsets.UTF_8
                            );
                            try{
                                final OperationRequestView request = gson.fromJson(body1, OperationRequestView.class);

                                final OperationResponceView response = HandleOperation.handleOperationView(request);

                                builder.append(gson.toJson(response));
                                statusCode = 200;
                            }
                            catch (RuntimeException e) {
                                builder.append("bad request");
                                statusCode = 400;
                            }
                            break;

                        case "sum":
                            final String body2 = NetworkUtils.readInputStreamAsString(
                                    exchange.getRequestBody(),
                                    StandardCharsets.UTF_8
                            );
                            try {
                                final OperationRequestSum request = gson.fromJson(body2, OperationRequestSum.class);
                                final OperationResponceSum response = HandleOperation.handleOperationSum(request);
                                builder.append(gson.toJson(response));
                                statusCode = 200;
                            } catch (RuntimeException e) {
                                builder.append("bad request");
                                statusCode = 400;
                            }
                            break;
                        case "mult":
                            final String body3 = NetworkUtils.readInputStreamAsString(
                                    exchange.getRequestBody(),
                                    StandardCharsets.UTF_8
                            );
                            try {
                                final OperationRequestMult request = gson.fromJson(body3, OperationRequestMult.class);
                                final OperationResponceMult response = HandleOperation.handleOperationMult(request);
                                builder.append(gson.toJson(response));
                                statusCode = 200;
                            } catch (RuntimeException e) {
                                builder.append("bad request");
                                statusCode = 400;
                            }
                            break;
                        default:
                            builder.append("unknown post");
                            statusCode = 404;
                    }
                    break;
                }
                default: {
                    builder.append("unknown method");
                    statusCode = 404;
                }
            }
            exchange.sendResponseHeaders(statusCode, builder.length());
            exchange.getResponseBody().write(builder.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exchange.close();
        }
    }
}
