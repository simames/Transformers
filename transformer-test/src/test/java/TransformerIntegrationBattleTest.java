import com.aequilibrium.transformer.api.model.*;
import com.aequilibrium.transformer.common.TransformerError;
import com.aequilibrium.transformer.common.TransformerErrorStatic;
import com.aequilibrium.transformer.test.config.TransformerRestTemplateFactory;
import com.aequilibrium.transformer.test.sp.TransformerSP;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {TransformerRestTemplateFactory.class, TransformerSP.class})
@ComponentScan("com.aequilibrium.transformer.*")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransformerIntegrationBattleTest {

    @Autowired
    private TransformerSP transformerAPI;

    @Test
    public void test_battle(){
        List<Long> transformersIds = new ArrayList<>();
        Transformer transformer= transformerAPI.createTransformer
                (new CreateTransformerRequest
                (new Descepticon("D",2,3,4,5,6,7,8,1))).getTransformer();
        transformersIds.add(transformer.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertNotNull(battleResponse.getBattleNumbers());
        assertNotNull(battleResponse.getWinningTeam());
        assertNotNull(battleResponse.getSurvivingMembersOfTheLosingTeam());
        assertNotNull(battleResponse.getWinner());
    }
    @Test
    public void test_battleNoValidTransformer(){
        try{
            List<Long> transformersIds = new ArrayList<>();
            transformersIds.add(123123L);
            BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        }catch (TransformerError e){
            assertEquals(e.getCode(), TransformerErrorStatic.ERROR_TRANSFORMER_BATTLE_TRANSFORMERS_DO_NOT_EXIST);
        }
    }

    @Test
    public void test_battleDescepticansVSAutobots(){
        Transformer descepticon = new Descepticon("D",2,3,4,5,6,7,8,1);
        Transformer autobot = new Autobot("A",8,8,8,8,8,8,8,8);
        Transformer savedDesceptican = transformerAPI.createTransformer(new CreateTransformerRequest(descepticon)).getTransformer();
        Transformer savedAutobot = transformerAPI.createTransformer(new CreateTransformerRequest(autobot)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedDesceptican.getId());
        transformersIds.add(savedAutobot.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(1,battleResponse.getBattleNumbers());
        assertEquals(0,battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(savedAutobot,battleResponse.getWinningTeam().get(0));
    }

    @Test
    public void test_battleDescepticansVSAutobotsList(){
        List<Long> autoBots = createAutoBots();
        List<Long> descepticons = createDescepticons();
        autoBots.addAll(descepticons);
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(autoBots));
        assertEquals(4,battleResponse.getBattleNumbers());
        assertEquals(0,battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(4,battleResponse.getWinningTeam().size());
    }

    @Test
    public void test_battleCourageAndCourageTest(){
        Transformer descepticon = new Descepticon("D",10,1,1,1,1,10,1,1);
        Transformer autobot = new Autobot("A",10,10,10,10,10,6,10,10);
        Transformer savedDesceptican = transformerAPI.createTransformer(new CreateTransformerRequest(descepticon)).getTransformer();
        Transformer savedAutobot = transformerAPI.createTransformer(new CreateTransformerRequest(autobot)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedDesceptican.getId());
        transformersIds.add(savedAutobot.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(1,battleResponse.getBattleNumbers());
        assertEquals(0,battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(savedAutobot,battleResponse.getWinningTeam().get(0));
    }
    @Test
    public void test_battleStrengthTest(){
        Transformer descepticon = new Descepticon("D",10,1,1,1,1,10,1,1);
        Transformer autobot = new Autobot("A",7,10,10,10,10,6,10,10);
        Transformer savedDesceptican = transformerAPI.createTransformer(new CreateTransformerRequest(descepticon)).getTransformer();
        Transformer savedAutobot = transformerAPI.createTransformer(new CreateTransformerRequest(autobot)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedDesceptican.getId());
        transformersIds.add(savedAutobot.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(1,battleResponse.getBattleNumbers());
        assertEquals(0,battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(savedDesceptican,battleResponse.getWinningTeam().get(0));
    }

    @Test
    public void test_battleTieTest(){
        Transformer descepticon = new Descepticon("D",2,2,2,2,2,2,2,2);
        Transformer autobot = new Autobot("A",2,2,2,2,2,2,2,2);
        Transformer savedDesceptican = transformerAPI.createTransformer(new CreateTransformerRequest(descepticon)).getTransformer();
        Transformer savedAutobot = transformerAPI.createTransformer(new CreateTransformerRequest(autobot)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedDesceptican.getId());
        transformersIds.add(savedAutobot.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(0,battleResponse.getBattleNumbers());
        assertEquals(0,battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(0,battleResponse.getWinningTeam().size());
    }

   @Test
   public void test_userStory(){
        Transformer soundwave = transformerAPI.createTransformer(
                new CreateTransformerRequest(
                        new Descepticon("Soundwave",8,9,2,6,7,5,6,10)))
                .getTransformer();
       Transformer bluestreak = transformerAPI.createTransformer(
               new CreateTransformerRequest(
                       new Autobot("Bluestreak",6,6,7,9,5,2,9,7)))
               .getTransformer();
       Transformer hubcap = transformerAPI.createTransformer(
               new CreateTransformerRequest(
                       new Autobot("Hubcap",4,4,4,4,4,4,4,4)))
               .getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(soundwave.getId());
        transformersIds.add(bluestreak.getId());
        transformersIds.add(hubcap.getId());
       BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
       assertEquals(1,battleResponse.getBattleNumbers());
       assertEquals(1,battleResponse.getWinningTeam().size());
       assertEquals(soundwave,battleResponse.getWinningTeam().get(0));
       assertEquals(1,battleResponse.getSurvivingMembersOfTheLosingTeam().size());
       assertEquals(hubcap,battleResponse.getSurvivingMembersOfTheLosingTeam().get(0));
   }

    private List<Long> createAutoBots() {
        List<Long> autoBotsIds = new ArrayList<>();
        for (int i=1;i<5;i++){
            Transformer transformer = new Autobot(String.valueOf(i),i,i,i,i,i,i,i,i);
            Transformer savedTransformer = transformerAPI.createTransformer(new CreateTransformerRequest(transformer)).getTransformer();
            autoBotsIds.add(savedTransformer.getId());
        }
        return autoBotsIds;
    }
    private List<Long> createDescepticons() {
        List<Long> autoBotsIds = new ArrayList<>();
        for (int i=5;i<10;i++){
            Transformer transformer = new Descepticon(String.valueOf(i),i,i,i,i,i,i,i,i);
            Transformer savedTransformer = transformerAPI.createTransformer(new CreateTransformerRequest(transformer)).getTransformer();
            autoBotsIds.add(savedTransformer.getId());
        }
        return autoBotsIds;
    }

}
