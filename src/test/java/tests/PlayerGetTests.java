package tests;

import clients.PlayerClient;
import constant.Role;
import dto.request.DeletePlayerRequestDto;
import dto.request.GetPlayerRequest;
import io.qameta.allure.Issue;
import models.ApiResponse;
import dto.response.CreatePlayerResponse;
import dto.response.GetPlayerResponse;
import dto.response.GetAllPlayersResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static service.PlayerService.playerService;

public class PlayerGetTests {

    private final PlayerClient client = new PlayerClient();

    @Test
    public void getPlayerByIdPositiveTest() {
        CreatePlayerResponse createPlayerResponse = playerService().createRandomUser();
        GetPlayerRequest getPlayerRequest = GetPlayerRequest.builder().playerId(createPlayerResponse.getId()).build();

        ApiResponse<GetPlayerResponse> resp = client.getPlayer(getPlayerRequest);

        Assert.assertEquals(resp.getStatusCode(), 200);
    }

    @Test
    public void getAllPlayersTest(){
        ApiResponse<GetAllPlayersResponse> resp = client.getAllPlayers();

        Assert.assertEquals(resp.getStatusCode(), 200);
        Assert.assertFalse(resp.getData().getPlayers().isEmpty());
    }

    @Test
    @Issue("defect")
    public void getPlayerNegativeTest() {
        CreatePlayerResponse createPlayerResponse = playerService().createRandomUser();

        DeletePlayerRequestDto deletePlayerRequestDto = DeletePlayerRequestDto.builder()
                .playerId(createPlayerResponse.getId()).build();

        client.deletePlayer(deletePlayerRequestDto, Role.SUPERVISOR);

        GetPlayerRequest getPlayerRequest = GetPlayerRequest.builder().playerId(createPlayerResponse.getId()).build();

        ApiResponse<GetPlayerResponse> resp = client.getPlayer(getPlayerRequest);

        Assert.assertEquals(resp.getStatusCode(), 404);
    }
}