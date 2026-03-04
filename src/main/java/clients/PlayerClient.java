package clients;

import constant.Role;
import dto.request.CreatePlayerRequest;
import dto.request.DeletePlayerRequestDto;
import dto.request.GetPlayerRequest;
import dto.request.UpdatePlayerRequest;
import dto.response.*;
import models.ApiResponse;
import io.restassured.response.Response;

public class PlayerClient extends BaseClient{

    public ApiResponse<CreatePlayerResponse> createPlayer(CreatePlayerRequest request) {
        Response response = client().given()
                .queryParam("age", request.getAge())
                .queryParam("gender", request.getGender())
                .queryParam("login", request.getLogin())
                .queryParam("password", request.getPassword())
                .queryParam("role", request.getRole())
                .queryParam("screenName", request.getScreenName())
                .when()
                .get("/player/create/{editor}", request.getEditor());

        return buildApiResponse(response, CreatePlayerResponse.class);
    }

    public ApiResponse<UpdatePlayerResponse> updatePlayer(UpdatePlayerRequest request, Role editor, String id) {
        Response response = client().given()
                .body(request)
                .when()
                .patch("/player/update/{editor}/{id}", editor.name(), id);

        return buildApiResponse(response, UpdatePlayerResponse.class);
    }

    public ApiResponse<GetPlayerResponse> getPlayer(GetPlayerRequest request) {
        Response response = client().given()
                .body(request)
                .when()
                .post("/player/get");

        return buildApiResponse(response, GetPlayerResponse.class);
    }

    public ApiResponse<DeletePlayerResponse> deletePlayer(DeletePlayerRequestDto request, Role editor) {
        Response response = client().given()
                .body(request)
                .when()
                .delete("/player/delete/{editor}", editor.name());

        return buildApiResponse(response, DeletePlayerResponse.class);
    }

    public ApiResponse<GetAllPlayersResponse> getAllPlayers()  {
        Response response = client().given()
                .when()
                .get("/player/get/all");

        return buildApiResponse(response, GetAllPlayersResponse.class);
    }

    public static PlayerClient playerApi() {
        return new PlayerClient();
    }
}