import com.aequilibrium.transformer.api.model.CreateTransformerRequest;
import com.aequilibrium.transformer.api.model.CreateTransformerResponse;
import com.aequilibrium.transformer.api.model.Desceptican;
import com.aequilibrium.transformer.sp.config.TransformerRestTemplateFactory;
import com.aequilibrium.transformer.sp.sp.TransformerSP;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = {TransformerRestTemplateFactory.class,TransformerSP.class})
@ComponentScan("com.aequilibrium.transformer.*")
public class transformerIntegrationTest
{

    @Autowired
    private TransformerSP transformerAPI;


    @Test
    public void createTransformer(){
        Desceptican desceptican = new Desceptican();
        desceptican.setId(1L);
        CreateTransformerResponse transformer = transformerAPI.createTransformer(new CreateTransformerRequest(desceptican));

    }


}
