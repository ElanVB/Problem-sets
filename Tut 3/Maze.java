public class Maze
{
  private static final boolean DEBUG = false;
  private static boolean[][] result;
  private static boolean firstRun = true;
  
  public static void fillArray(boolean[][] array)
  {
    for(int i = 0; i < array[0].length; i++)
    {
      for(int j = 0; j < array[0].length; j++)
      {
        array[i][j] = false;
      }
      System.out.println();
    }
  }
  
  public static boolean[][] path(boolean[][] maze, int startRow, int startCol, int endRow, int endCol)
  {
    result = new boolean[maze[0].length][maze[0].length];
    fillArray(result);
    
    if(solve(maze, startRow, startCol, endRow, endCol))
      return result;
    
    return null;
  }
  
  public static boolean solve(boolean[][] maze, int startRow, int startCol, int endRow, int endCol)
  {
    if(DEBUG)
      System.out.println("Currently on col: " + startRow + ", row: " + startCol);
    
    if(startRow < 0 || startRow > maze[0].length - 1 || startCol < 0 || startCol > maze[0].length - 1)
    {
      if(DEBUG)
        System.out.println("out of gird");
      
      return false;
    }
    
    if(!maze[startRow][startCol])
    {
      if(DEBUG)
        System.out.println("Wall of maze");
      
      return false;
    }
    
    if(result[startRow][startCol])
    {
      if(DEBUG)
        System.out.println("Already been here");
      
      return false;
    }

    result[startRow][startCol] = true;
    
    if(DEBUG)
      System.out.println("Mark that I have been here");
    
    if(startRow == endRow && startCol == endCol)
    {
      return  true;
    }
    
    
    if(DEBUG)
      System.out.println("try one right");
    if(solve(maze, startRow+1, startCol, endRow, endCol))
      return true;
    
    if(DEBUG)
      System.out.println("try one up");
    if(solve(maze, startRow, startCol+1, endRow, endCol))
      return true;
    
    if(DEBUG)
      System.out.println("try one left");
    if(solve(maze, startRow-1, startCol, endRow, endCol))
      return true;
    
    if(DEBUG)
      System.out.println("try one down");
    if(solve(maze, startRow, startCol-1, endRow, endCol))
      return true;
    
    
    if(DEBUG)
      System.out.println("No Path available through this point, col: " + startRow + ", row: " + startCol);
    result[startRow][startCol] = false;
    
    return false;
  }
  
  public static boolean[][] path1(boolean[][] maze, int startRow, int startCol, int endRow, int endCol)
  {
    if(firstRun)
    {
      result = new boolean[maze[0].length][maze[0].length];
      fillArray(result);
      
      firstRun = false;
    }
    
    if(DEBUG)
      System.out.println("Currently on col: " + startRow + ", row: " + startCol);
    
    if(startRow < 0 || startRow > maze[0].length - 1 || startCol < 0 || startCol > maze[0].length - 1)
    {
      if(DEBUG)
        System.out.println("out of gird");
      
      return null;
    }
    
    if(!maze[startRow][startCol])
    {
      if(DEBUG)
        System.out.println("Wall of maze");
      
      return null;
    }
    
    if(result[startRow][startCol])
    {
      if(DEBUG)
        System.out.println("Already been here");
      
      return null;
    }
    
    result[startRow][startCol] = true;
    if(DEBUG)
      System.out.println("Mark that I have been here");
    
    if(startRow == endRow && startCol == endCol)
    {
      return result;
    }
    
    if(DEBUG)
      System.out.println("try one up");
    path(maze, startRow+1, startCol, endRow, endCol);
    
    if(DEBUG)
      System.out.println("try one right");
    solve(maze, startRow, startCol+1, endRow, endCol);
    
    if(DEBUG)
      System.out.println("try one down");
    path(maze, startRow-1, startCol, endRow, endCol);
    
    if(DEBUG)
      System.out.println("try one left");
    path(maze, startRow, startCol-1, endRow, endCol);
    
    
    if(DEBUG)
      System.out.println("No Path available through this point, col: " + startRow + ", row: " + startCol);
    result[startRow][startCol] = false;
    return null;
  }
}