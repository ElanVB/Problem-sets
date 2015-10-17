public class CoinToss
{
  public static void main(String[] args)
  {
    int N = Integer.parseInt(args[0]); 
    System.out.println("Running " + N + " simulations.");
    int N_events = 0; 
    boolean print = args.length > 1;
    String[] type = new String[]{"H","T"};
    
    for (int i = 0 ; i < N ; i++) {
      // Simulate Alice
      if (print) System.out.print("Alice:");
      int alice_last = -1;
      int alice_current = -1;
      int alice_tosses = 0;

      while (!((alice_last == 0) && (alice_current == 0))) {
        alice_last = alice_current;
        alice_current = (int)(Math.random() * 2); // 0 Head, 1 Tails
        alice_tosses++;
        if (print) System.out.print(type[alice_current]);
      }

      // Simulate Bob
      if (print) System.out.print(" Bob:");
      int bob_last = -1;
      int bob_current = -1;
      int bob_tosses = 0;

      while (!((bob_last == 0) && (bob_current == 1))) {
        bob_last = bob_current;
        bob_current = (int)(Math.random() * 2);
        bob_tosses++;
        if (print) System.out.print(type[bob_current]);
      }

      if (alice_tosses < bob_tosses) {
         N_events++;
         if (print) System.out.print(" Alice has fewer.");
      } 
      if (print) System.out.println();
    } 
    
    
    double prob = N_events / (double) N; 
    System.out.println(prob);    
  }
}
