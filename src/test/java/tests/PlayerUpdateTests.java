package tests;

import clients.PlayerClient;
import constant.Role;
import dto.request.UpdatePlayerRequest;
import io.qameta.allure.Issue;
import models.ApiResponse;
import dto.response.CreatePlayerResponse;
import dto.response.UpdatePlayerResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static service.PlayerService.playerService;

public class PlayerUpdateTests {

    private PlayerClient client = new PlayerClient();

    @Test
    public void updatePlayerPositiveTest() {
        CreatePlayerResponse createPlayerResponse = playerService().createRandomUser();

        UpdatePlayerRequest updatePlayerRequest = UpdatePlayerRequest.builder()
                .build();

        ApiResponse<UpdatePlayerResponse> resp = client.updatePlayer(updatePlayerRequest, Role.SUPERVISOR, String.valueOf(createPlayerResponse.getId()));

        Assert.assertEquals(resp.getStatusCode(), 200);
    }

    @Test
    @Issue("defect")
    public void updatePlayerNegativeInvalidAge() {
        CreatePlayerResponse createPlayerResponse = playerService().createRandomUser();

        UpdatePlayerRequest updatePlayerRequest = UpdatePlayerRequest.builder()
                .age(10)
                .build();

        ApiResponse<UpdatePlayerResponse> resp = client.updatePlayer(updatePlayerRequest, Role.SUPERVISOR, String.valueOf(createPlayerResponse.getId()));

        Assert.assertEquals(resp.getStatusCode(), 400);
    }
}