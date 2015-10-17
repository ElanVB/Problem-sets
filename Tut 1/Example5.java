public class Example5
{
  public static void main(String[] args)
  {
    int N = 10000;
    int N_events = 0;
    int total = 0;
    
    for (int i = 0 ; i < N ; i++) {
      int numrolls = 0;
      int die;
      do {
        die = 1 + (int)(Math.random() * 6);
        numrolls++;
      } while ((die != 2) && (die != 4));
      total += numrolls;
    }
    double avg = total / (double) N;
    System.out.println("Average: " + avg);
    
    for (int i = 0 ; i < N ; i++) 
    {
      int die = 1 + (int)(Math.random() * 6);
      if ((die == 2) || (die == 4)) N_events++;
    }
    
    double prob = N_events / (double) N;
    System.out.println("Probibility: " + prob);
  }
}