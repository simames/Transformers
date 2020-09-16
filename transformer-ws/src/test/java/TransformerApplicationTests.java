import com.aequilibrium.transformer.TransformerApplication;
import com.jayway.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static com.jayway.restassured.RestAssured.*;


@SpringBootTest(classes = TransformerApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(value={"classpath:application.properties"})
public class TransformerApplicationTests {

    @Value("${server.port}")
    private static int port = 8080;

    @Test
    public void getDataTest() {

        given().contentType("application/json").when().post("transformer/createTransformer/{}").then().assertThat().statusCode(200);
//        get("/api/tdd/responseData").then().assertThat().body("data", equalTo("responseData"));
    }


    @BeforeAll
    public static void setBaseUri(){
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }


}



