package models;

import io.restassured.response.Response;

import java.util.Map;

public class ApiResponse<T> {

    private final int statusCode;
    private final String statusLine;
    private final Map<String, String> headers;
    private final T data;
    private final Response rawResponse;

    public ApiResponse(int statusCode, String statusLine, Map<String, String> headers, T data, Response rawResponse) {
        this.statusCode = statusCode;
        this.statusLine = statusLine;
        this.headers = headers;
        this.data = data;
        this.rawResponse = rawResponse;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusLine() {
        return statusLine;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public T getData() {
        return data;
    }

    public Response getRawResponse() {
        return rawResponse;
    }
}