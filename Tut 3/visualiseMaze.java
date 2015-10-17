public class visualiseMaze
{
  public static void main(String[] args)
  {
    for(int i = 0; i < Integer.parseInt(args[1]); i++)
    {
      int startR, startC, endR, endC;
      boolean[][] maze = RandomMaze.getMaze(Integer.parseInt(args[0]));
      
      do
      {
        startR =(int) (Math.random()*Integer.parseInt(args[0]));
        startC = (int) (Math.random()*Integer.parseInt(args[0]));
        endR = (int) (Math.random()*Integer.parseInt(args[0]));
        endC = (int) (Math.random()*Integer.parseInt(args[0]));
      }while(!maze[startR][startC] || !maze[endR][endC]);
      
      draw(maze, Maze.path(maze, startR, startC, endR, endC), startR, startC, endR, endC);
    }
  }
  
  private static void draw(boolean[][] maze, boolean[][] solution, int rowS, int colS, int rowE, int colE)
  {
    StdDraw.clear();
    StdDraw.setPenColor(StdDraw.BLACK);
    
    int N = maze[0].length;
    StdDraw.setXscale(-1, N);
    StdDraw.setYscale(-1, N);
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
      if (!maze[i][j])
      StdDraw.filledSquare(j, N-i-1, .5);
    
    StdDraw.setPenColor(StdDraw.RED);
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
    {
      if (solution[i][j])
      {
      StdDraw.filledSquare(j, N-i-1, .4);
      }
    }
    
    StdDraw.setPenColor(StdDraw.GREEN);
    StdDraw.filledSquare(colS, N-rowS-1, .4);
    
    StdDraw.setPenColor(StdDraw.YELLOW);
    StdDraw.filledSquare(colE, N-rowE-1, .4);
  }
}