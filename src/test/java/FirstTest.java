import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void tesString(){
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification request = RestAssured.given();
        request.param("page", 2);
        request.header("Authorization", "Bearer jhsdhajsdhajdhakj");

        Response response = request.get("/api/users");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
