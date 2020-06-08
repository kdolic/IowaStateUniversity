package hw2;

import static hw2.CS227Baseball.*; 

/**
 * Simplified model of American baseball.
 * 
 * @author Kenan Dolic
 */

public class CS227Baseball
{
  /**
   * Constant indicating that a pitch results in a ball.
   */
  public static final int BALL = 0;
  
  /**
   * Constant indicating that a pitch results in a strike.
   */
  public static final int STRIKE = 1;
  
  /**
   * Constant indicating that a pitch results in an out from a fly ball.
   */
  public static final int POP_FLY = 2;
  
  /**
   * Number of strikes causing a player to be out.
   */
  public static final int MAX_STRIKES = 3;
  
  /**
   * Number of balls causing a player to walk.
   */
  public static final int MAX_BALLS = 4;
  
  /**
   * Number of outs before the teams switch.
   */
  public static final int MAX_OUTS = 3;
  
// Instance Variables
  private boolean isGameOver = false; // game is over or not
  private int numBalls = 0; // number of balls thrown outside of strike zone
  private int numStrikes = 0; // number of strikes thrown at one batter
  private int numOuts = 0; // number of outs for the team
  private int team0Score = 0; // team 0 score
  private int team1Score = 0; // team 1 score
  private boolean isTopInning = true; // when first half of the inning
  private int numInning = 1; // current inning played
  private int maxInnings; // total number of innings
  private boolean[] Bases = new boolean[4]; // implements bases on field for player position

  /**
   * Constructs a game that has the given number of innings and starts at the top of inning 1.
   * @param givenNumInnings
   */
  public CS227Baseball(int givenNumInnings) 
  {
    
      for (int i = 0; i < 4; i++)
          Bases[i] = false; // sets all bases empty
      isTopInning = true;
      maxInnings = givenNumInnings;
  }
  /**
   * Returns true if the game is over, false otherwise
   * @return isGameOver
   */
  public boolean isOver()
  {
	  return isGameOver;
  }
  /**
   * Returns whether there is a player on first base.
   * @return Bases[0]
   */
  public boolean playerOnFirst()
  {
	  return Bases[0];
  }
  /**
   * Returns whether there is a player on second base.
   * @return Bases[1]
   */
  public boolean playerOnSecond()
  {
	  return Bases[1];
  }
  /**
   * Returns whether there is a player on third base.
   * @return Bases[1]
   */
  public boolean playerOnThird() 
  {
	  return Bases[2];
  }
  /**
   * Returns the current inning.
   * @return numInning
   */
  public int getInning()
  {
	  return numInning;
  }
  /**
   * Returns true if it's the first half of the inning (team 0 is at bat).
   * @return isTopInning
   */
  public boolean isTop()
  {
	  return isTopInning;
  }
  /**
   * Returns the number of outs for the current batter.
   * @return numOuts
   */
  public int getOuts()
  {
	  return numOuts;
  }
  /**
   * Returns the number of strikes for the current batter
   * @return numStrikes
   */
  public int getStrikes()
  {
	  return numStrikes;
  }
  /**
   * Returns the number of balls for the current batter.
   * @return numBalls
   */
  public int getBalls()
  {
	  return numBalls;
  }
  /**
   * Returns the score of the indicated team, where an argument of true indicates team 0 
   * (batting in the top of the inning) and an argument of false indicates team 1 
   * (batting in the bottom of the inning).
   * @param team0
   * @return team0Score, team1Score
   */
  public int getScore(boolean team0)
  {
	  if(team0) 
		 return team0Score;
	  else 
		  return team1Score;
	  
  }
  /**
   * Pitch not resulting in a hit.
   * @param outcome
   */
  public void pitch(int outcome)
  {
	  if (!isGameOver) {
          if (outcome == 0)
              numBalls++; // adds 1 to balls
          if (outcome == 1)
              numStrikes++;
          if (outcome == 2) {
              numOuts++; // instant out from pop fly
              numStrikes = 0;
              numBalls = 0;
          }
          
          if (numStrikes == 3) {
              numOuts++; // 3 strikes means out
              numStrikes = 0;
              numBalls = 0;
          }
          
          if (numBalls == 4) {
              advanceRunners(true); // 4 balls thrown means runner advances base
              numBalls = 0;
          }
          
          if (numOuts == 3) {
              numBalls = 0;
              numStrikes = 0;
              numOuts = 0;
              if (!isTopInning) // after 3 outs, teams switch sides
                  numInning++;
              isTopInning = !isTopInning;
              for (int i = 0; i < 4; i++)
                  Bases[i] = false;
          }
     
          if (numInning > maxInnings)
          {
              numInning--; // innings cannot exceed limit, therefore game ends
              isGameOver = true;
          }
      }
  }
	  

  /**
   * Pitch resulting in a hit where no player is out.
   * @param numBases
   */
  public void pitchWithHit(int numBases)
  {
	  if(!isGameOver) 
	  {
		  numStrikes = 0;
		  advanceRunners(true);
		  
		  for(int i = 0; i < numBases - 1; i++) 
		  {
			  advanceRunners(false);
		  }
	  }
  }
  
  /**
   * Pitch resulting in a hit and a possible out.
   * @param numBases
   * @param whichBaseFielded
   */
  public void pitchWithHitAndOut(int numBases, int whichBaseFielded)
  {
	  if (!isGameOver) {
          numStrikes = 0;
          advanceRunners(true); // a runner on advances
         
          for(int i = 0; i < numBases - 1; i++) // cycles through other hits, but no runner makes to first base
          {
              advanceRunners(false);
          }
        
          if (whichBaseFielded == 4 && Bases[3] == true) { //keeps track of outs when runner has ball at base
              numOuts++;
              Bases[3] = false;
              if (isTopInning)
                  team0Score--;
              else
                  team1Score--;
          } else if (Bases[whichBaseFielded - 1]) {
              numOuts++;
              Bases[whichBaseFielded - 1] = false;
          }

          if (numOuts == 3) { // teams switch sides after 3 outs
              numBalls = 0;
              numStrikes = 0;
              numOuts = 0;
              if (!isTopInning) 
                  numInning++;
              isTopInning = !isTopInning;
              for (int i = 0; i < 4; i++)
                  Bases[i] = false;
          }
      
          if (numInning > maxInnings)
          {
              numInning--; // innings cannot exceed limit, therefore game ends
              isGameOver = true;
          }
      }
	  }
  
  
  /**
   * Advances all players on base by one base, updating the score if there is currently a player on third.
   * @param newPlayerOnFirst
   */
  public void advanceRunners(boolean newPlayerOnFirst)
  {
	  if (!isGameOver) {
          if (Bases[3])
              Bases[3] = false;
          for (int i = 2; i >= 0; i--) {
              if (Bases[i] == true) {
                  Bases[i] = false;
                  Bases[i + 1] = true;
              }

          }
          if (newPlayerOnFirst)
              Bases[0] = true;
          if (Bases[3]) {
              if (isTopInning) 
                  team0Score++;
              else
                  team1Score++;
          }
      }
  }
  
  /**
   * Returns a three-character string representing the players on base, 
   * in the order first, second, and third, where 'X' indicates a player 
   * is present and 'o' indicates no player.  For example, the string "XXo" 
   * means that there are players on first and second but not on third.
   * @return
   *   three-character string showing players on base
   */
  
  public String getBases()
  {
    return (playerOnFirst() ? "X" : "o") +
        (playerOnSecond() ? "X" : "o") +
        (playerOnThird() ? "X" : "o");
  }

  /**
   * Returns a one-line string representation of the current game state.
   * The format is:
   * <pre>
   *    ooo Inning:1 (T) Score:0-0 Balls:0 Strikes:0 Outs:0
   * </pre>
   * The first three characters represent the players on base as returned by 
   * the <code>getBases()</code> method. The 'T' after the inning number indicates 
   * it's the top of the inning, and a 'B' would indicate the bottom.
   * 
   * @return
   *   one-line string representation of the game state
   */
  
  public String toString()
  {
    String bases = getBases();
    String topOrBottom = (isTop() ? "T" : "B");
    String fmt = "%s Inning:%d (%s) Score:%d-%d Balls:%d Strikes:%d Outs:%d";
    return String.format(fmt, bases, getInning(), topOrBottom, getScore(true), getScore(false), getBalls(), getStrikes(), getOuts());
  }

  /**
   * Returns a multi-line string representation of the current game state.
   * The format is:  
   * <pre>
   *     o - o    Inning:1 (T)
   *     |   |    Score:0-0
   *     o - H    Balls:0 Strikes:0 Outs:0
   * </pre>
   * The 'T' after the inning number indicates it's the top of the inning, 
   * and a 'B' would indicate the bottom.
   * @return
   *   multi-line string representation of current game state
   */
  
  public String toDisplayString()
  {
    String firstChar = (playerOnFirst() ? "X" : "o");
    String secondChar = (playerOnSecond() ? "X" : "o");
    String thirdChar = (playerOnThird() ? "X" : "o");
    String topOrBottom = (isTop() ? "T" : "B");
    String firstLine = String.format("%s - %s    Inning:%d (%s)\n", secondChar, firstChar, getInning(), topOrBottom);
    String secondLine = String.format("|   |    Score:%d-%d\n", getScore(true), getScore(false));
    String thirdLine = String.format("%s - H    Balls:%d Strikes:%d Outs:%d\n", thirdChar, getBalls(), getStrikes(), getOuts());
    return firstLine + secondLine + thirdLine;   
  }
}
