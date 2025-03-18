import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstTest {

    String baseUrl = "https://jsonplaceholder.typicode.com";
    static Map<String, String> requestBody = new HashMap<>();

    @Test
    @DisplayName("Validar que é possivel recuperar valores do JSON Placeholder")
    void Validate_That_Is_Possible_To_See_Data() {
        Response response = RestAssured
                .given()
                    .baseUri(baseUrl)
                .when()
                    .get("/posts/1")
                .then()
                    .statusCode(200)
                    .extract().response();
    }

    @Test
    @DisplayName("Validar que é possivel fazer um post no JSON Placeholder")
    void Validate_That_Is_Possible_To_Make_A_Post() {
        requestBody.put("Hello", "World");
        Response reponse = RestAssured
                .given()
                    .baseUri(baseUrl)
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                .when()
                    .post("/posts")
                .then()
                .statusCode(201)
                .extract().response();

        System.out.println(reponse.body().toString());

    }
}
