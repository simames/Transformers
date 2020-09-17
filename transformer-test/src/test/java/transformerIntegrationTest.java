import com.aequilibrium.transformer.api.impl.api.model.CreateTransformerRequest;
import com.aequilibrium.transformer.api.impl.api.model.CreateTransformerResponse;
import com.aequilibrium.transformer.api.impl.api.model.Desceptican;
import com.aequilibrium.transformer.test.config.TransformerRestTemplateFactory;
import com.aequilibrium.transformer.test.sp.TransformerSP;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {TransformerRestTemplateFactory.class,TransformerSP.class})
@ComponentScan("com.aequilibrium.transformer.*")
public class transformerIntegrationTest
{

    @Autowired
    private TransformerSP transformerAPI;


    @Test
    public void createTransformer(){
        Desceptican desceptican = new Desceptican();
        CreateTransformerResponse transformer = transformerAPI.createTransformer(new CreateTransformerRequest(desceptican));
        assertNotNull(transformer.getTransformer().getId());
    }


}
