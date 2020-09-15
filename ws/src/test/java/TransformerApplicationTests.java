import com.jayway.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;


@SpringBootTest(classes = com.aequilibrium.transformer.TransformerApplication.class)
@TestPropertySource(value={"classpath:application.properties"})
public class TransformerApplicationTests {

    @Value("${server.port}")
    static int port;

    @Test
    public void getDataTest() {
        get("/api/tdd/responseData").then().assertThat().body("data", equalTo("responseData"));
    }

    @BeforeAll
    public static void setBaseUri(){
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }


}



