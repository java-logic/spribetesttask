package dto.response;

import java.util.List;

public class GetAllPlayersResponse {

    private List<PlayerDto> players;

    public List<PlayerDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDto> players) {
        this.players = players;
    }
}