public class BridgeHands
{
  public static void main (String[] args)
  {
    boolean debug = false;
    
    int[] deck = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,4,4,4,4};
    
    int[] player1 = new int[13];
    int[] player2 = new int[13];
    int[] player3 = new int[13];
    int[] player4 = new int[13];
    
    int fiveThreeThreeTwo = 0;
    int fourFourThreeTwo = 0;
    int fourThreeThreeThree = 0;
    
    int games = Integer.parseInt(args[0]);
    
    for(int i = 0; i < games; i++)
    {
      shuffle(deck, 52);
      deal(deck, player1, player2, player3, player4, 52);
      
      if(debug)
      {
        System.out.println("deck");
        printArray(deck, 52);
        
        System.out.println("hands");
        printArray(player1, 13);
        printArray(player2, 13);
        printArray(player3, 13);
        printArray(player4, 13);
      }
      
      int[] countPlayer1 = {count(player1, 1), count(player1, 2), count(player1, 3), count(player1, 4)};
      int[] countPlayer2 = {count(player2, 1), count(player2, 2), count(player2, 3), count(player2, 4)};
      int[] countPlayer3 = {count(player3, 1), count(player3, 2), count(player3, 3), count(player3, 4)};
      int[] countPlayer4 = {count(player4, 1), count(player4, 2), count(player4, 3), count(player4, 4)};
      
      sort(countPlayer1, 4);
      sort(countPlayer2, 4);
      sort(countPlayer3, 4);
      sort(countPlayer4, 4);
      
      if(debug)
      {
        System.out.println("num suits");
        printArray(countPlayer1, 4);
        printArray(countPlayer2, 4);
        printArray(countPlayer3, 4);
        printArray(countPlayer4, 4);
      }
      
      //check for 5-3-3-2 in all hands
      if(countPlayer1[0] == 5 && countPlayer1[1] == 3 && countPlayer1[2] == 3 && countPlayer1[3] == 2)
      {
        fiveThreeThreeTwo++;
      }
      
      if(countPlayer2[0] == 5 && countPlayer2[1] == 3 && countPlayer2[2] == 3 && countPlayer2[3] == 2)
      {
        fiveThreeThreeTwo++;
      }
      
      if(countPlayer3[0] == 5 && countPlayer3[1] == 3 && countPlayer3[2] == 3 && countPlayer3[3] == 2)
      {
        fiveThreeThreeTwo++;
      }
      
      if(countPlayer4[0] == 5 && countPlayer4[1] == 3 && countPlayer4[2] == 3 && countPlayer4[3] == 2)
      {
        fiveThreeThreeTwo++;
      }
      
      //check for 4-4-3-2 in all hands
      if(countPlayer1[0] == 4 && countPlayer1[1] == 4 && countPlayer1[2] == 3 && countPlayer1[3] == 2)
      {
        fourFourThreeTwo++;
      }
      
      if(countPlayer2[0] == 4 && countPlayer2[1] == 4 && countPlayer2[2] == 3 && countPlayer2[3] == 2)
      {
        fourFourThreeTwo++;
      }
      
      if(countPlayer3[0] == 4 && countPlayer3[1] == 4 && countPlayer3[2] == 3 && countPlayer3[3] == 2)
      {
        fourFourThreeTwo++;
      }
      
      if(countPlayer4[0] == 4 && countPlayer4[1] == 4 && countPlayer4[2] == 3 && countPlayer4[3] == 2)
      {
        fourFourThreeTwo++;
      }
      
      //check for 4-3-3-3 in all hands
      if(countPlayer1[0] == 4 && countPlayer1[1] == 3 && countPlayer1[2] == 3 && countPlayer1[3] == 3)
      {
        fourThreeThreeThree++;
      }
      
      if(countPlayer2[0] == 4 && countPlayer2[1] == 3 && countPlayer2[2] == 3 && countPlayer2[3] == 3)
      {
        fourThreeThreeThree++;
      }
      
      if(countPlayer3[0] == 4 && countPlayer3[1] == 3 && countPlayer3[2] == 3 && countPlayer3[3] == 3)
      {
        fourThreeThreeThree++;
      }
      
      if(countPlayer4[0] == 4 && countPlayer4[1] == 3 && countPlayer4[2] == 3 && countPlayer4[3] == 3)
      {
        fourThreeThreeThree++;
      }
    }
    
    if(debug)
    {
      System.out.println("5-3-3-2 " + fiveThreeThreeTwo);
      System.out.println("4-4-3-2 " + fourFourThreeTwo);
      System.out.println("4-3-3-3 " + fourThreeThreeThree);
    }
   
    double probFiveThreeThreeTwo = (double) (fiveThreeThreeTwo/(double)(games * 4));
    double probFourFourThreeTwo = (double) (fourFourThreeTwo/(double)(games * 4));
    double probFourThreeThreeThree = (double) (fourThreeThreeThree/(double)(games * 4));
    
   System.out.println("The Probiblity of 5-3-3-2: " + probFiveThreeThreeTwo);
   System.out.println("The Probiblity of 4-4-3-2: " + probFourFourThreeTwo);
   System.out.println("The Probiblity of 4-3-3-3: " + probFourThreeThreeThree);
   
   if(probFiveThreeThreeTwo > probFourFourThreeTwo && probFiveThreeThreeTwo > probFourThreeThreeThree)
   {
     System.out.println("5-3-3-2 is the most likeley.");
   }
   else
   {
     if(probFourFourThreeTwo > probFiveThreeThreeTwo && probFourFourThreeTwo > probFourThreeThreeThree)
     {
       System.out.println("4-4-3-2 is the most likeley.");
     }
     else
     {
       System.out.println("4-3-3-3 is the most likeley.");
     }
   }
  }
  
  private static void shuffle(int[] array, int length)
  {
    for(int i = 0; i < length - 1; i++)
    {
      int rand = (int) (Math.random() *length);
      int temp = array[i];
      array[i] = array[rand];
      array[rand] = temp;
    }
  }
  
  private static void deal(int[] deck, int[] hand1, int[] hand2, int[] hand3, int[] hand4, int length)
  {
    for(int i = 0; i < length; i += 4)
    {
      hand1[i/4] = deck[i];
      hand2[i/4] = deck[i + 1];
      hand3[i/4] = deck[i + 2];
      hand4[i/4] = deck[i + 3];
    }
  }
  private static int count(int[] hand, int suit)
  {
    int result = 0;
    
    for(int i = 0; i < 13; i++)
    {
      if(hand[i] == suit)
      {
        result++;
      }
    }
    
    return result;
  }
  
  private static void sort(int[] array, int length)
  {
    for(int x = 0; x < length - 1; x++)
    {
      for(int y = x + 1; y < length; y++)
      {
        if(array[x] < array[y])
        {
          int temp = array[x];
          array[x] = array[y];
          array[y] = temp;
        }
      }
    }
  }
  
  private static void printArray(int[] array, int length)
  {
    for(int i = 0; i < length; i++)
    {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }
}