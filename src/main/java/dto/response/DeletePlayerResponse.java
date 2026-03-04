package dto.response;

import java.util.Map;

public class DeletePlayerResponse {

    private Map<String, Object> body;  // пустий об'єкт у JSON може бути Map
    private String statusCode;
    private int statusCodeValue;

    // --- Геттери та сеттери ---
    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCodeValue() {
        return statusCodeValue;
    }

    public void setStatusCodeValue(int statusCodeValue) {
        this.statusCodeValue = statusCodeValue;
    }
}