public class MakeADeal
{
  public static void main(String[] args)
  {
    // Note for this question that you could make this solution code more elegant by noting
    // that either the first or second choice of door is the
    // winning door, so you only actually need to estimate the probability P of one of these
    // strategies winning.  Then the estimate of the probability the other strategy winning
    // is simply 1-P.

    int N = Integer.parseInt(args[0]); 
    System.out.println("Running " + N + " simulations.");
    int N_stay_wins = 0;
    int N_change_wins = 0;
    boolean print = args.length > 1;
    for (int i = 0 ; i < N ; i++) {     
      int winning_door = (int)(Math.random() * 3);
      int first_choice = (int)(Math.random() * 3);
      int opened_door = -1;

      // Choose a door to open that is not the winning door, and not the first choice.
      while ((opened_door == -1) 
             || (winning_door == opened_door)
             || (first_choice == opened_door))
        opened_door = (int)(Math.random() * 3);

      int second_choice = -1; // illegal door for debugging
      // Second choice will be the unopened door that is not the first choice
      for (int j=0; j<3; j++) {
        if ((j != opened_door) && (j != first_choice)) second_choice = j;
      }
      // Note that exactly one choice of i should set second_choice

      if (print) {
        System.out.print("winning_door=" + winning_door 
                         + " first_pick=" + first_choice
                         + " opened_door=" + opened_door
                         + " other_choice=" + second_choice + " ");
      }
      
      if (winning_door == first_choice) {
        if (print) System.out.println("First pick wins!"); 
        N_stay_wins++;
      }
      if (winning_door == second_choice) {
        if (print) System.out.println("Other choice wins!");         
        N_change_wins++;
      }
    } 
    
    double prob_win_stay = N_stay_wins/ (double) N; 
    double prob_win_change = N_change_wins/ (double) N; 
    System.out.println("Probability of win if stays:" + prob_win_stay);  
    System.out.println("Probability of win if changes:" + prob_win_change);  
  }
}
