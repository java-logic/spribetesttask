package dto.request;

public class DeletePlayerRequest {
    private String editor;
    private Integer playerId;

    public String getEditor() { return editor; }
    public void setEditor(String editor) { this.editor = editor; }

    public Integer getPlayerId() { return playerId; }
    public void setPlayerId(Integer playerId) { this.playerId = playerId; }
}