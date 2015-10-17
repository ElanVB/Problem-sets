import java.math.*;
public class CoinToss
{ 
 public static void main (String[] args)
 {
   boolean debug = false;
   
   int currentheads, prevheads;
   int alice, bob;
   int aliceWins = 0;
   int simulations = (Integer.parseInt(args[0]));
   
   if(debug)
       {
        System.out.println("Simulations: " + simulations);
       }
   
   for(int i = 0; i < simulations; i++)
   {
     currentheads = -1;
     prevheads = -1;
     
     alice = 0;
     bob = 0;
     
     if(debug)
       {
        System.out.println("Loop Number: " + i);
       }
     
     while (currentheads != 1 || prevheads != 1)
     {
       alice++;
       prevheads = currentheads;
       currentheads = (int) (Math.random() * 2);
       
       if(debug)
       {
        System.out.println("Alice:" + currentheads + "\nAlice toss count: " + alice);
       }
     }
     
     currentheads = -1;
     prevheads = -1;
     
     while (!(currentheads == 1 && prevheads == 0) && !(currentheads == 0 && prevheads == 1))
     {
       bob++;
       prevheads = currentheads;
       currentheads = (int) (Math.random() * 2);
       
       if(debug)
       {
        System.out.println("Bob:" + currentheads + "\nBob toss count: " + bob);
       }
     }
     
     if(alice < bob)
     {
       aliceWins++;
       
       if(debug)
       {
        System.out.println("Alice wins");
       }
     }
   }
   
   System.out.println((double) aliceWins/ Double.parseDouble(args[0]));
   
 }
}