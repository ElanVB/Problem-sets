import java.math.*;
public class MakeADeal
{
  public static void main(String[] args)
  {
    int simulations = Integer.parseInt(args[0]);
    int stayWins = 0, changeWins = 0;
    
    
    for(int i = 0; i < simulations; i++)
    {
      int correctDoor = (int) (Math.random() * 3);
      int previousGuess = -1;
      
      //stay stratagy
      int guessDoor = (int) (Math.random() * 3);
      if(correctDoor == guessDoor)
      {
        stayWins++;
      }
      else
      {
        //change stratagy
        previousGuess = guessDoor;
        int cancelledDoor = (int) (Math.random() * 3);
        
        while(cancelledDoor == correctDoor || cancelledDoor == guessDoor)
        {
          cancelledDoor = (int) (Math.random() * 3);
        }
        
        while(previousGuess == guessDoor || guessDoor == cancelledDoor)
        {
          guessDoor = (int) (Math.random() * 3);
        }
        
        if(correctDoor == guessDoor)
        {
          changeWins++;
        }
      }
    }
    
    System.out.println("Prob of win if stay: " + (double) stayWins/ ((double) simulations) + "\nProb of win if change: " + (double) changeWins /((double) simulations));
    
  }
}