package service;

import clients.PlayerClient;
import constant.Role;
import dto.request.CreatePlayerRequest;
import dto.response.CreatePlayerResponse;

public class PlayerService {

    private final PlayerClient client;

    public PlayerService() {
        this.client = new PlayerClient();
    }

    public CreatePlayerResponse createRandomUser() {
        CreatePlayerRequest createPlayerRequest = CreatePlayerRequest
                .builder()
                .editor(Role.SUPERVISOR)
                .build();

        return client.createPlayer(createPlayerRequest).getData();
    }

    public static PlayerService playerService() {
        return new PlayerService();
    }
}