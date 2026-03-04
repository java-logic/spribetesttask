package dto.request;

public class GetPlayerRequest {
    private Integer playerId;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer playerId;

        public Builder playerId(Integer playerId) {
            this.playerId = playerId;
            return this;
        }

        public GetPlayerRequest build() {
            GetPlayerRequest request = new GetPlayerRequest();
            request.setPlayerId(this.playerId);
            return request;
        }
    }
}