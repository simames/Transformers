import com.aequilibrium.transformer.api.model.*;
import com.aequilibrium.transformer.common.TransformerEnumType;
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
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        this.transformer = new Descepticon("D",2,3,4,5,6,7,8,1);
    }

    @Test
    public void test_createTransformer(){
        CreateTransformerResponse response = transformerAPI.createTransformer(new CreateTransformerRequest(transformer));
        assertNotNull(response.getTransformer().getId());
    }

    @Test
    public void test_createTransformerWithDescepticonType(){
        CreateTransformerResponse response = transformerAPI.createTransformer(new CreateTransformerRequest(transformer));
        assertEquals(TransformerEnumType.DESEPTICAN.getCode(),response.getTransformer().getType());
    }
    @Test
    public void test_createTransformerWithAutobotType(){
        Transformer autoBot = new Autobot("A",2,3,4,5,6,7,8,1);
        CreateTransformerResponse response = transformerAPI.createTransformer(new CreateTransformerRequest(autoBot));
        assertEquals(TransformerEnumType.AUTOBOT.getCode(),response.getTransformer().getType());
    }
    @Test
    public void test_createTransformerWithAllInputs(){
        Transformer autoBot = new Autobot("A",2,3,4,5,6,7,8,1);
        CreateTransformerResponse response = transformerAPI.createTransformer(new CreateTransformerRequest(autoBot));
        checkingTransEqualInputs(response.getTransformer(),autoBot);
    }
    @Test()
    public void Test_validation_createTransformer(){
        Transformer validationTransformer = new Transformer("D",22,0,145,0,0,0,0,25,"DES");
        assertThrows(Exception.class,()->transformerAPI.createTransformer( new CreateTransformerRequest(validationTransformer)));
    }

    private void checkingTransEqualInputs(Transformer transformer, Transformer autoBot) {
        assertEquals(autoBot.getType(),transformer.getType());
        assertEquals(autoBot.getName(),transformer.getName());
        assertEquals(autoBot.getStrength(),transformer.getStrength());
        assertEquals(autoBot.getCourage(),transformer.getCourage());
        assertEquals(autoBot.getEndurance(),transformer.getEndurance());
        assertEquals(autoBot.getFirepower(),transformer.getFirepower());
        assertEquals(autoBot.getIntelligence(),transformer.getIntelligence());
        assertEquals(autoBot.getRank(),transformer.getRank());
        assertEquals(autoBot.getSkill(),transformer.getSkill());
        assertEquals(autoBot.getSpeed(),transformer.getSpeed());
    }

    @Test
    public void test_updateTransformer(){
        CreateTransformerResponse createTransformerResponse = transformerAPI.createTransformer(new CreateTransformerRequest(transformer));
        Transformer responseTransformer = createTransformerResponse.getTransformer();
        responseTransformer.setStrength(10);
        UpdateTransformerResponse response = transformerAPI.updateTransformer(new UpdateTransformerRequest(responseTransformer));
        assertEquals(10,response.getTransformer().getStrength());
    }
    @Test()
    public void Test_validation_updateTransformer(){
        Transformer validationTransformer = new Transformer("D",22,0,145,0,0,0,0,25,"DES");
        assertThrows(Exception.class,()->transformerAPI.updateTransformer( new UpdateTransformerRequest(validationTransformer)));
    }

    @Test
    public void test_ListTransformer(){
        ListTransformerResponse response = transformerAPI.listTransformers();
        List<Transformer> transformers = response.getTransformers();
        assertNotNull(response.getTransformers());
        for (Transformer transformer :
                transformers) {
            checkingTransNotNull(transformer);
        }
    }

    private void checkingTransNotNull(Transformer transformer) {
        assertNotNull(transformer.getId());
        assertNotNull(transformer.getName());
        assertNotNull(transformer.getStrength());
        assertNotNull(transformer.getCourage());
        assertNotNull(transformer.getEndurance());
        assertNotNull(transformer.getFirepower());
        assertNotNull(transformer.getIntelligence());
        assertNotNull(transformer.getRank());
        assertNotNull(transformer.getSkill());
        assertNotNull(transformer.getSpeed());
    }


    @Test
    public void test_deleteTransformer(){
        CreateTransformerResponse createTransformerResponse = transformerAPI.createTransformer(new CreateTransformerRequest(transformer));
        DeleteTransformerResponse response = transformerAPI.deleteTransformer(new DeleteTransformerRequest(createTransformerResponse.getTransformer()));
        assertEquals("deleted",response.getResult());
    }

    @Test()
    public void Test_validation_deleteTransformer(){
        Transformer validationTransformer = new Transformer("D",22,0,145,0,0,0,0,25,"DES");
        assertThrows(Exception.class,()->transformerAPI.deleteTransformer( new DeleteTransformerRequest(validationTransformer)));
    }

    @Test
    public void test_deleteTransformerGetError(){
        transformer.setId(5654L);
        try{
            DeleteTransformerResponse response = transformerAPI.deleteTransformer(new DeleteTransformerRequest(transformer));
        }catch (TransformerError e){
            assertEquals(e.getCode(), TransformerErrorStatic.ERROR_TRANSFORMER_PERSISTENCE_TRANSFORMER_DOES_NOT_EXIST);
        }
    }


    @Test
    public void Test_validationType(){
        try{
            transformer.setType(null);
        }catch (TransformerError e){
            assertEquals(e.getCode(), TransformerErrorStatic.ERROR_TRANSFORMER_GENERAL_TYPE_NOT_VALID);
        }
    }


}
