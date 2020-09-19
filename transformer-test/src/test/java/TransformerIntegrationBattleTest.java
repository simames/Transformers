import com.aequilibrium.transformer.test.config.TransformerRestTemplateFactory;
import com.aequilibrium.transformer.test.sp.TransformerSP;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = {TransformerRestTemplateFactory.class, TransformerSP.class})
@ComponentScan("com.aequilibrium.transformer.*")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransformerIntegrationBattleTest {

    @Test
    public void battle(){

    }

}
