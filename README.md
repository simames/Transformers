CONTENTS OF THIS FILE
---------------------

 * Introduction
 * Requirements 
 * Installation
 * Configuration
 * Running application
 * Running Integration Tests
 * Starting with transformers creations
 * Creating a transformer
 * Updating a transformer
 * Delete a transformer
 * List all transformers
 * Battle
 * Battle result
 
 INTRODUCTION
 ------------
 
 The Transformers are at war and this API gives you an opportunity to determine who wins the war!
 You must create your Autobots or Descepticans and send their ids for a battle !
 
 Please watch this video:
 https://www.youtube.com/watch?v=nLS2N9mHWaw
 
 REQUIREMENTS
 ------------
 
 This API requires the following modules:
 
  * Maven (3.2) or Upper
  * java_version: 1.8
  
  INSTALLATION
  ------------
   
   Use maven lifecycle to create and compile the project 
   
    mvn clean install -DskipTests
   
   
   CONFIGURATION
   -------------
   Configure the application with application.properties in transformer-app module
    
  RUNNING APPLICATION
  ------------    
    cd transformer-app/target/
    java -jar transformer-app-1.0.jar


  RUNNING INTEGRATION TESTS
  ------------    
  To run integration test you need to run the application on the port 8080 and then start the tests
  This is mainly because in TDD I do not need to constantly rerun the spring boot 
     
  STARTING WITH TRANSFORMERS CREATIONS
  ------------
Create an Autobot or Descepticon with following abilities (from 1 to 10):
* Strength
* Intelligence
* Speed
* Endurance
* Rank
* Courage
* Firepower
* Skill

If you want to create a transformer make sure you add Type in this format
* DES
* AUT    
     
   CREATING A TRANSFORMER
   ------------
Create a transformer by calling **transformer/createTransformer** REST service and passing an object 
with name CreateTransformerRequest with your transformer

   UPDATING A TRANSFORMER
   ------------
Update a transformer by calling **transformer/updateTransformer** REST service and passing an object 
with name UpdateTransformerRequest with your transformer

   DELETE A TRANSFORMER
   ------------
Delete a transformer by calling **transformer/deleteTransformer** REST service and passing an object 
with name DeleteTransformerRequest with your transformer

   LIST ALL TRANSFORMERS
   ---------------------
Get a list of all transformers by calling **transformer/listTransformer** REST service
 
   ‌BATTLE
   ---------------------  
For a battle you need a list of transformers ids in an object name TransformersBattleRequest
 call the REST service **transformer/transformersBattle**
  the battle follow these rules:
  
  * The transformers are split into two teams based on if they are Autobots or Decepticons
  * The teams are sorted by rank and faced off one on one against each other in
   order to determine a victor, the loser is eliminated. 
  * The one on one means the first high ranked autobots face the first high ranked descepticon
  and both transformers are removed from the fight after their battle
  * A battle between opponents uses the following rules:
    * If any fighter is down 4 or more points of courage and 3 or more points of
          strength compared to their opponent, the opponent automatically wins the
          face-off regardless of overall rating (opponent has ran away)
    * Otherwise, if one of the fighters is 3 or more points of skill above their opponent,
          they win the fight regardless of overall rating
  * The winner is the Transformer with the highest overall rating
  * In the event of a tie, both Transformers are considered destroyed and by destroyed means they will no longer exists in the database  
  * Any Transformers who don’t have a fight are skipped (i.e. if it’s a team of 2 vs. a team of
    1, there’s only going to be one battle) and it will be in surviving members
  * The team who eliminated the largest number of the opposing team is the winner
  * Any Transformer named Optimus Prime or Predaking wins his fight automatically
    regardless of any other criteria 
  * In the event either of the above face each other (or a duplicate of each other), the game
   immediately ends with all competitors destroyed and it means they will no longer exists in the database
   the result of the battle is zero and the number of the battles are zero and there will be no loser or winner

     ‌BATTLE RESULT
     ---------------------
     The results are in a TransformersBattleResponse which includes :
     * battleNumbers
     * winningTeam
     * survivingMembersOfTheLosingTeam
     * winner
     
   
    
   
    
   
    
   
   
  
 
    
    