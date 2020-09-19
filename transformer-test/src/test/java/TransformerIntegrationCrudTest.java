import com.aequilibrium.transformer.api.model.*;
import com.aequilibrium.transformer.common.TransformerError;
import com.aequilibrium.transformer.common.TransformerErrorStatic;
import com.aequilibrium.transformer.test.config.TransformerRestTemplateFactory;
import com.aequilibrium.transformer.test.sp.TransformerSP;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {TransformerRestTemplateFactory.class,TransformerSP.class})
@ComponentScan("com.aequilibrium.transformer.*")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransformerIntegrationCrudTest
{

    @Autowired
    private TransformerSP transformerAPI;

    private Transformer transformer;

    @BeforeAll
    public void createMockTransformer(){
        this.transformer = new Descepticon(1,2,3,4,5,6,7,8);
    }

    @Test
    public void createTransformer(){
        CreateTransformerResponse response = transformerAPI.createTransformer(new CreateTransformerRequest(transformer));
        assertNotNull(response.getTransformer().getId());
    }

    @Test
    public void updateTransformer(){
        CreateTransformerResponse createTransformerResponse = transformerAPI.createTransformer(new CreateTransformerRequest(transformer));
        Transformer responseTransformer = createTransformerResponse.getTransformer();
        responseTransformer.setStrength(10);
        UpdateTransformerResponse response = transformerAPI.updateTransformer(new UpdateTransformerRequest(responseTransformer));
        assertEquals(10,response.getTransformer().getStrength());
    }

    @Test
    public void ListTransformer(){
        ListTransformerResponse response = transformerAPI.listTransformers();
        assertNotNull(response.getTransformers());

    }

    @Test
    public void deleteTransformer(){
        CreateTransformerResponse createTransformerResponse = transformerAPI.createTransformer(new CreateTransformerRequest(transformer));
        DeleteTransformerResponse response = transformerAPI.deleteTransformer(new DeleteTransformerRequest(createTransformerResponse.getTransformer()));
        assertEquals("deleted",response.getResult());
    }

    @Test
    public void deleteTransformerGetError(){
        transformer.setId(5654L);
        try{
            DeleteTransformerResponse response = transformerAPI.deleteTransformer(new DeleteTransformerRequest(transformer));
        }catch (TransformerError e){
            assertEquals(e.getCode(), TransformerErrorStatic.ERROR_TRANSFORMER_PERSISTENCE_TRANSFORMER_DOES_NOT_EXIST);
        }
    }


}
