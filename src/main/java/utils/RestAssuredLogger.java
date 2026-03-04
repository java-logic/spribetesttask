package utils;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;

import java.util.Optional;

import static utils.LoggerUtil.getLogger;

public class RestAssuredLogger implements Filter {
    private static final Logger LOGGER = getLogger(RestAssuredLogger.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        LOGGER.info("===== REQUEST =====");
        LOGGER.info("{} {}", requestSpec.getMethod(), requestSpec.getURI());
        LOGGER.info("Headers: {}", requestSpec.getHeaders());
        if (requestSpec.getBody() != null) {
            LOGGER.info("Body: {}", Optional.ofNullable(requestSpec.getBody()));
        }

        Response response = ctx.next(requestSpec, responseSpec);

        LOGGER.info("===== RESPONSE =====");
        LOGGER.info("Status: {}", response.getStatusCode());
        LOGGER.info("Body: {}", response.getBody().asPrettyString());

        return response;
    }
}