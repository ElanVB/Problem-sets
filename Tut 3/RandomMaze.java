public class RandomMaze
{
  private static void relabel(int[][] labels, int old_label, int new_label)
  {
    for (int i = 0; i < labels.length ; i++) {
      for (int j = 0; j < labels[i].length ; j++) {
        if (labels[i][j] == old_label) labels[i][j] = new_label;
      }
    }
  }
  
  public static boolean[][] getMaze(int N) {
    // Returns an NxN maze where no points are connected more than once,
    // and all empty spaces are reachable from any other empty space.
    // NOTE: Requires N > 2 to ensure an empty cell in the maze
    
    boolean open[][] = new boolean[N][N];
    int labels[][] = new int[N][N];
    int num_spaces = 0;
    
    if ((N % 2) == 0) N--;   // N should be odd for the algorithm to work, we just ignore the last row/col if not
    
    for (int i = 0 ; i < (N / 2) ; i++) {
      for (int j = 0 ; j < (N / 2) ; j++) {
        open[i * 2 + 1][j * 2 + 1] = true;        // Start with a regular spaced grid of holes
        labels[i * 2 + 1][j * 2 + 1] = i + N * j + 1; // Each hole is given a unique label
        num_spaces++;
      }
    }
    
    int must_join = num_spaces - 1;
    while (must_join > 0) {
      int i, j;
      boolean vertical = StdRandom.bernoulli(0.5);
      if (vertical) { // Bash in a vertical wall
        i = StdRandom.uniform(N/2 - 1)*2+2; // An i that is between two rows of spaces
        j = StdRandom.uniform(N/2)*2+1; // A j corresponding with some column containing spaces
      } else { // Bash in a horizontal wall
        j = StdRandom.uniform(N/2 - 1)*2+2; // A j that is between two columns of spaces
        i = StdRandom.uniform(N/2)*2+1; // An i corresponding with some row containing spaces
      }
      
      if (open[i][j]) continue; // Can't open this up, it is already open

      int label1, label2;
      if (vertical) {
        label1 = labels[i-1][j];
        label2 = labels[i+1][j];
      } else {
        label1 = labels[i][j-1];
        label2 = labels[i][j+1];
      }
      
      if (label1 == label2) continue; // Shouldn't open this, the two neighbouring regions are already joined
      labels[i][j] = label1;
      open[i][j] = true;
      relabel(labels, label1, label2);
      must_join--;
    }
    return open; 
  }
}
