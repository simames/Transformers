import com.aequilibrium.transformer.api.model.*;
import com.aequilibrium.transformer.common.TransformerError;
import com.aequilibrium.transformer.common.TransformerErrorStatic;
import com.aequilibrium.transformer.common.TransformerWinnerNames;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {TransformerRestTemplateFactory.class, TransformerSP.class})
@ComponentScan("com.aequilibrium.transformer.*")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransformerIntegrationBattleTest {

    @Autowired
    private TransformerSP transformerAPI;

    @Test
    public void test_userStory() {
        Transformer soundwave = transformerAPI.createTransformer(
                new CreateTransformerRequest(
                        new Descepticon("Soundwave", 8, 9, 2, 6, 7, 5, 6, 10)))
                .getTransformer();
        Transformer bluestreak = transformerAPI.createTransformer(
                new CreateTransformerRequest(
                        new Autobot("Bluestreak", 6, 6, 7, 9, 5, 2, 9, 7)))
                .getTransformer();
        Transformer hubcap = transformerAPI.createTransformer(
                new CreateTransformerRequest(
                        new Autobot("Hubcap", 4, 4, 4, 4, 4, 4, 4, 4)))
                .getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(soundwave.getId());
        transformersIds.add(bluestreak.getId());
        transformersIds.add(hubcap.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(1, battleResponse.getBattleNumbers());
        assertEquals(1, battleResponse.getWinningTeam().size());
        assertEquals(soundwave, battleResponse.getWinner());
        assertEquals(1, battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(hubcap, battleResponse.getSurvivingMembersOfTheLosingTeam().get(0));
    }

    @Test
    public void test_battle_validation() {
        try {
            List<Long> transformersIds = new ArrayList<>();
            Transformer transformer = transformerAPI.createTransformer
                    (new CreateTransformerRequest
                            (new Descepticon("D", 2, 3, 4, 5, 6, 7, 8, 1))).getTransformer();
            transformersIds.add(transformer.getId());
            BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        } catch (TransformerError e) {
            assertEquals(e.getCode(), TransformerErrorStatic.ERROR_TRANSFORMER_BATTLE_TRANSFORMERS_DO_NOT_EXIST);
        }
    }

    @Test
    public void test_battleNoValidTransformer() {
        try {
            List<Long> transformersIds = new ArrayList<>();
            transformersIds.add(123123L);
            transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        } catch (TransformerError e) {
            assertEquals(e.getCode(), TransformerErrorStatic.ERROR_TRANSFORMER_BATTLE_TRANSFORMERS_DO_NOT_EXIST);
        }
    }

    @Test
    public void test_battleDescepticansVSAutobots() {
        Transformer descepticon = new Descepticon("D", 2, 3, 4, 5, 6, 7, 8, 1);
        Transformer autobot = new Autobot("A", 8, 8, 8, 8, 8, 8, 8, 8);
        Transformer savedDesceptican = transformerAPI.createTransformer(new CreateTransformerRequest(descepticon)).getTransformer();
        Transformer savedAutobot = transformerAPI.createTransformer(new CreateTransformerRequest(autobot)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedDesceptican.getId());
        transformersIds.add(savedAutobot.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(1, battleResponse.getBattleNumbers());
        assertEquals(0, battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(savedAutobot, battleResponse.getWinningTeam().get(0));
    }

    @Test
    public void test_battleDescepticansVSAutobotsList() {
        CreatedTransformers autoBots = createAutoBots();
        CreatedTransformers descepticons = createDescepticons();
        autoBots.getTransformersIds().addAll(descepticons.getTransformersIds());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(autoBots.getTransformersIds()));
        assertEquals(4, battleResponse.getBattleNumbers());
        assertEquals(0, battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(4, battleResponse.getWinningTeam().size());
    }

    @Test
    public void test_battleCourageAndStrenghtTest() {
        Transformer descepticon = new Descepticon("D", 10, 1, 1, 1, 1, 10, 1, 1);
        Transformer autobot = new Autobot("A", 10, 10, 10, 10, 10, 6, 10, 10);
        Transformer savedDesceptican = transformerAPI.createTransformer(new CreateTransformerRequest(descepticon)).getTransformer();
        Transformer savedAutobot = transformerAPI.createTransformer(new CreateTransformerRequest(autobot)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedDesceptican.getId());
        transformersIds.add(savedAutobot.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(1, battleResponse.getBattleNumbers());
        assertEquals(0, battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(savedAutobot, battleResponse.getWinningTeam().get(0));
    }

    @Test
    public void test_battleStrengthTest() {
        Transformer descepticon = new Descepticon("D", 10, 1, 1, 1, 1, 10, 1, 1);
        Transformer autobot = new Autobot("A", 7, 10, 10, 10, 10, 6, 10, 10);
        Transformer savedDesceptican = transformerAPI.createTransformer(new CreateTransformerRequest(descepticon)).getTransformer();
        Transformer savedAutobot = transformerAPI.createTransformer(new CreateTransformerRequest(autobot)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedDesceptican.getId());
        transformersIds.add(savedAutobot.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(1, battleResponse.getBattleNumbers());
        assertEquals(0, battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(savedDesceptican, battleResponse.getWinningTeam().get(0));
    }

    @Test
    public void test_battleTieTest() {
        Transformer descepticon = new Descepticon("D", 2, 2, 2, 2, 2, 2, 2, 2);
        Transformer autobot = new Autobot("A", 2, 2, 2, 2, 2, 2, 2, 2);
        Transformer savedDesceptican = transformerAPI.createTransformer(new CreateTransformerRequest(descepticon)).getTransformer();
        Transformer savedAutobot = transformerAPI.createTransformer(new CreateTransformerRequest(autobot)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedDesceptican.getId());
        transformersIds.add(savedAutobot.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(0, battleResponse.getBattleNumbers());
        assertEquals(0, battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(0, battleResponse.getWinningTeam().size());

    }

    @Test
    public void test_battleOptimusPrime() {
        Transformer optimus = new Descepticon(TransformerWinnerNames.OPTIMUS_PRIME, 1, 1, 1, 1, 1, 1, 1, 1);
        Transformer autobot = new Autobot("A", 10, 10, 10, 10, 10, 10, 10, 10);
        Transformer savedOptimus = transformerAPI.createTransformer(new CreateTransformerRequest(optimus)).getTransformer();
        Transformer savedAutobot = transformerAPI.createTransformer(new CreateTransformerRequest(autobot)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedOptimus.getId());
        transformersIds.add(savedAutobot.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(1, battleResponse.getBattleNumbers());
        assertEquals(0, battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(1, battleResponse.getWinningTeam().size());
        assertEquals(savedOptimus, battleResponse.getWinner());
    }

    @Test
    public void test_battlePredaking() {
        Transformer predaking = new Autobot(TransformerWinnerNames.PREDAKING, 1, 1, 1, 1, 1, 1, 1, 1);
        Transformer descepticon = new Descepticon("D", 10, 10, 10, 10, 10, 10, 10, 10);
        Transformer savedPredaking = transformerAPI.createTransformer(new CreateTransformerRequest(predaking)).getTransformer();
        Transformer saveddescepticon = transformerAPI.createTransformer(new CreateTransformerRequest(descepticon)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedPredaking.getId());
        transformersIds.add(saveddescepticon.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(1, battleResponse.getBattleNumbers());
        assertEquals(0, battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(1, battleResponse.getWinningTeam().size());
        assertEquals(savedPredaking, battleResponse.getWinner());
    }

    @Test
    public void test_battlePredakingVSOptimusPrime() {
        Transformer predaking = new Autobot(TransformerWinnerNames.PREDAKING, 1, 1, 1, 1, 1, 1, 1, 1);
        Transformer optimusPrime = new Descepticon(TransformerWinnerNames.OPTIMUS_PRIME, 10, 10, 10, 10, 10, 10, 10, 10);
        Transformer savedPredaking = transformerAPI.createTransformer(new CreateTransformerRequest(predaking)).getTransformer();
        Transformer savedOptimusPrime = transformerAPI.createTransformer(new CreateTransformerRequest(optimusPrime)).getTransformer();
        List<Long> transformersIds = new ArrayList<>();
        transformersIds.add(savedPredaking.getId());
        transformersIds.add(savedOptimusPrime.getId());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(transformersIds));
        assertEquals(0, battleResponse.getBattleNumbers());
        assertEquals(0, battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(0, battleResponse.getWinningTeam().size());
        assertEquals(null, battleResponse.getWinner());
    }

    @Test
    void test_battleDescepticansVSAutobotsListTermination() {
        CreatedTransformers autoBots = createAutoBots();
        CreatedTransformers descepticons = createDescepticons();
        autoBots.getTransformersIds().addAll(descepticons.getTransformersIds());
        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(autoBots.getTransformersIds()));
        descepticons.getTransformers().addAll(autoBots.getTransformers());
        List<Transformer> transformers = transformerAPI.listTransformers().getTransformers();
        assertTrue(!transformers.containsAll(descepticons.getTransformers()));
    }

    @Test
    void test_battleDescepticansVSAutobotsListTerminationWithWinnerNames() {

        CreatedTransformers autoBots = createAutoBots();
        CreatedTransformers descepticons = createDescepticons();

        Transformer predaking = new Autobot(TransformerWinnerNames.PREDAKING, 1, 1, 1, 1, 1, 1, 1, 1);
        Transformer optimusPrime = new Descepticon(TransformerWinnerNames.OPTIMUS_PRIME, 10, 10, 10, 10, 10, 10, 10, 10);
        Transformer savedPredaking = transformerAPI.createTransformer(new CreateTransformerRequest(predaking)).getTransformer();
        Transformer savedOptimusPrime = transformerAPI.createTransformer(new CreateTransformerRequest(optimusPrime)).getTransformer();

        autoBots.getTransformersIds().addAll(descepticons.getTransformersIds());
        autoBots.getTransformersIds().add(savedPredaking.getId());
        autoBots.getTransformersIds().add(savedOptimusPrime.getId());

        BattleResponse battleResponse = transformerAPI.transformersBattle(new BattleRequest(autoBots.getTransformersIds()));
        descepticons.getTransformers().addAll(autoBots.getTransformers());
        descepticons.getTransformers().add(predaking);
        descepticons.getTransformers().add(optimusPrime);


        List<Transformer> transformers = transformerAPI.listTransformers().getTransformers();
        assertTrue(!transformers.containsAll(descepticons.getTransformers()));
        assertEquals(0, battleResponse.getBattleNumbers());
        assertEquals(0, battleResponse.getSurvivingMembersOfTheLosingTeam().size());
        assertEquals(0, battleResponse.getWinningTeam().size());
    }

    private CreatedTransformers createDescepticons() {
        CreatedTransformers createdTransformers = new CreatedTransformers();
        List<Transformer> descepticons = new ArrayList<>();
        List<Long> descepticonsIds = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            Transformer transformer = new Descepticon(String.valueOf(i), i, i, i, i, i, i, i, i);
            Transformer savedTransformer = transformerAPI.createTransformer(new CreateTransformerRequest(transformer)).getTransformer();
            descepticons.add(savedTransformer);
            descepticonsIds.add(savedTransformer.getId());
        }
        createdTransformers.setTransformers(descepticons);
        createdTransformers.setTransformersIds(descepticonsIds );
        return createdTransformers;
    }

    private CreatedTransformers createAutoBots() {
        CreatedTransformers createdTransformers = new CreatedTransformers();
        List<Transformer> autoBots = new ArrayList<>();
        List<Long> autobotIds = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Transformer transformer = new Autobot(String.valueOf(i), i, i, i, i, i, i, i, i);
            Transformer savedTransformer = transformerAPI.createTransformer(new CreateTransformerRequest(transformer)).getTransformer();
            autobotIds.add(savedTransformer.getId());
            autoBots.add(savedTransformer);
        }
        createdTransformers.setTransformers(autoBots);
        createdTransformers.setTransformersIds(autobotIds );
        return createdTransformers;
    }



    private static class CreatedTransformers{
        private List<Long> transformersIds;
        private List<Transformer> transformers;

        public CreatedTransformers() {
        }

        public CreatedTransformers(List<Long> transformersIds, List<Transformer> transformers) {
            this.transformersIds = transformersIds;
            this.transformers = transformers;
        }

        public List<Long> getTransformersIds() {
            return transformersIds;
        }

        public void setTransformersIds(List<Long> transformersIds) {
            this.transformersIds = transformersIds;
        }

        public List<Transformer> getTransformers() {
            return transformers;
        }

        public void setTransformers(List<Transformer> transformers) {
            this.transformers = transformers;
        }
    }

}
