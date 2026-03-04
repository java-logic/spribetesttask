package clients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.Config;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.ApiResponse;
import utils.RestAssuredLogger;

import java.util.stream.Collectors;

public abstract class BaseClient {
    private final ObjectMapper mapper = new ObjectMapper();

    static {
        RestAssured.baseURI = Config.getBaseUrl();
    }

    protected RequestSpecification client() {
        return RestAssured
                .given()
                .filter(new RestAssuredLogger())
                .contentType("application/json");
    }

    protected <T> ApiResponse<T> buildApiResponse(Response response, Class<T> clazz) {
        T data = null;
        try {
            data = mapper.readValue(response.asString(), clazz);
        } catch (JsonProcessingException ignored) {
        }
        return new ApiResponse<>(
                response.getStatusCode(),
                response.getStatusLine(),
                response.getHeaders().asList().stream()
                        .collect(Collectors.toMap(Header::getName, Header::getValue)),
                data,
                response
        );
    }
}