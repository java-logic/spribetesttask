package tests;

import dto.request.DeletePlayerRequestDto;
import io.qameta.allure.Issue;
import models.ApiResponse;
import dto.response.CreatePlayerResponse;
import dto.response.DeletePlayerResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static clients.PlayerClient.playerApi;
import static constant.Role.SUPERVISOR;
import static constant.Role.USER;
import static service.PlayerService.playerService;

public class PlayerDeleteTests {


    @Test
    @Issue("potential defect, why 204 and not 200, needs to be clarified\n")
    public void deletePlayerPositiveTest() {
        CreatePlayerResponse createPlayerResponse = playerService().createRandomUser();

        DeletePlayerRequestDto deletePlayerRequestDto = DeletePlayerRequestDto.builder()
                .playerId(createPlayerResponse.getId()).build();

        ApiResponse<DeletePlayerResponse> response = playerApi().deletePlayer(deletePlayerRequestDto, SUPERVISOR);

        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    @Issue("defect")
    public void deletePlayerNegativeRole() {
        CreatePlayerResponse createPlayerResponse = playerService().createRandomUser();

        DeletePlayerRequestDto deletePlayerRequestDto = DeletePlayerRequestDto.builder()
                .playerId(createPlayerResponse.getId()).build();

        ApiResponse<DeletePlayerResponse> resp = playerApi().deletePlayer(deletePlayerRequestDto, USER);

        Assert.assertEquals(resp.getStatusCode(), 403);
    }

    @Test
    public void deletePlayerNegativeSupervisor() {
        DeletePlayerRequestDto deletePlayerRequestDto = DeletePlayerRequestDto.builder()
                .playerId(-1).build();

        ApiResponse<DeletePlayerResponse> resp = playerApi().deletePlayer(deletePlayerRequestDto, SUPERVISOR);

        Assert.assertEquals(resp.getStatusCode(), 403);
    }
}