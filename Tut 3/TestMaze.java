public class TestMaze
{
  public static void main(String[] args)
  {
    boolean[][] mazeOne = 
    { { false, false, false, false, false, false, false }, 
      { false, true, false, true, true, true, false }, 
      { false, true, false, true, false, true, false }, 
      { false, true, true, true, false, true, false }, 
      { false, true, false, false, false, true, false }, 
      { false, true, false, true, true, true, false }, 
      { false, false, false, false, false, false, false } };
    
    System.out.println("Maze: ");
    print2DArray(mazeOne);
    
    System.out.println("Solution: ");
    print2DArray(Maze.path(mazeOne, 2, 1, 4, 5));
    
    System.out.println("Maze: ");
    print2DArray(mazeOne);
    
    System.out.println("Solution: ");
    print2DArray(Maze.path(mazeOne, 2, 1, 4, 5));
  }
  
  private static void print2DArray(boolean[][] array)
  {
    for(int i = 0; i < array[0].length; i++)
    {
      for(int j = 0; j < array[0].length; j++)
      {
        if(array[i][j])
          System.out.print("1 ");
        
        else
          System.out.print("0 ");
      }
      System.out.println();
    }
  }
}