package tests;

import clients.PlayerClient;
import constant.Role;
import dto.request.CreatePlayerRequest;
import models.ApiResponse;
import dto.response.CreatePlayerResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerCreateTests {

    private final PlayerClient client = new PlayerClient();

    @Test
    public void createPlayerPositiveTest() {
        CreatePlayerRequest createPlayerRequest = CreatePlayerRequest
                .builder()
                .editor(Role.SUPERVISOR)
                .build();

        ApiResponse<CreatePlayerResponse> createPlayerResponse = client.createPlayer(createPlayerRequest);

        Assert.assertEquals(createPlayerResponse.getStatusCode(), 200);
    }

    @Test
    public void createPlayerInvalidAge() {
        CreatePlayerRequest createPlayerRequest = CreatePlayerRequest
                .builder()
                .age(10)
                .build();

        ApiResponse<CreatePlayerResponse> createPlayerResponse = client.createPlayer(createPlayerRequest);

        Assert.assertEquals(createPlayerResponse.getStatusCode(), 400);
    }
}