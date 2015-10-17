import junit.framework.TestCase;

public class MazeTest extends TestCase {
  public static String arrayAsString(boolean[][] arr) {
    String result = "";
    for (int i = 0 ; i < arr.length ; i++) {
      for (int j = 0; j < arr[0].length ; j++) {
        if (arr[i][j]) result += "1 "; else result += "0 ";
      }
      result += "\n";
    }
    return result;
  }
  
  public static void arraysAreEqual(boolean[][] input_maze, 
                                    int start_i, int start_j,
                                    int end_i, int end_j,
                                    boolean[][] arr1, boolean[][] arr2)
  {
    String arr1_str = arrayAsString(arr1);
    String arr2_str = arrayAsString(arr2);
    if (!arr1_str.equals(arr2_str)) {
      String message = "For the input maze:\n" + arrayAsString(input_maze);
      message += "Starting at row " + start_i + " column " + start_j + " ";
      message += " and ending at row " + end_i + " column " + end_j + "\n";
      message += "Expected output was:\n" + arr1_str;
      message += "But actual output was:\n" + arr2_str;
      fail(message);
    }
  }

  public void testMazeOne() {
    /* TEST MAZE
    0 0 0 0 0 0 0 
    0 1 0 1 1 1 0 
    0 1 0 1 0 1 0 
    0 1 1 1 0 1 0 
    0 1 0 0 0 1 0 
    0 1 0 1 1 1 0 
    0 0 0 0 0 0 0 
    The following is a boolean[][] version of the above.
    */    
    boolean[][] mazeOne = 
    { { false, false, false, false, false, false, false }, 
      { false, true, false, true, true, true, false }, 
      { false, true, false, true, false, true, false }, 
      { false, true, true, true, false, true, false }, 
      { false, true, false, false, false, true, false }, 
      { false, true, false, true, true, true, false }, 
      { false, false, false, false, false, false, false } };
    
    int start_i = 2, start_j = 1, end_i = 4, end_j = 5; 
    boolean[][] mazeOnePath = Maze.path(mazeOne, start_i, start_j,
                                               end_i, end_j);
    /* CORRECT PATH FROM (2,1) to (4,5)
     0 0 0 0 0 0 0 
     0 0 0 1 1 1 0 
     0 1 0 1 0 1 0 
     0 1 1 1 0 1 0 
     0 0 0 0 0 1 0 
     0 0 0 0 0 0 0 
     0 0 0 0 0 0 0
     The following is a boolean[][] version of the above.
     */
    boolean[][] correctMazeOnePath = 
    { { false, false, false, false, false, false, false }, 
      { false, false, false, true, true, true, false }, 
      { false, true, false, true, false, true, false }, 
      { false, true, true, true, false, true, false }, 
      { false, false, false, false, false, true, false }, 
      { false, false, false, false, false, false, false }, 
      { false, false, false, false, false, false, false }};
 

    arraysAreEqual(mazeOne,start_i, start_j, end_i, end_j, correctMazeOnePath,mazeOnePath);

    
    
    start_i = 1;
    start_j = 4;
    end_i = 5;
    end_j = 1; 
    boolean[][] mazeTwoPath = Maze.path(mazeOne, start_i, start_j,
                                               end_i, end_j);
    /* CORRECT PATH FROM (1,4) to (5,1)
     0 0 0 0 0 0 0 
     0 0 0 1 1 0 0 
     0 0 0 1 0 0 0 
     0 1 1 1 0 0 0 
     0 1 0 0 0 0 0 
     0 1 0 0 0 0 0 
     0 0 0 0 0 0 0
     The following is a boolean[][] version of the above.
     */

    boolean[][] correctMazeTwoPath = new boolean[][]
    { { false, false, false, false, false, false, false }, 
      { false, false, false, true, true, false, false }, 
      { false, false, false, true, false, false, false }, 
      { false, true, true, true, false, false, false }, 
      { false, true, false, false, false, false, false }, 
      { false, true, false, false, false, false, false }, 
      { false, false, false, false, false, false, false } };
    
    arraysAreEqual(mazeOne,start_i, start_j, end_i, end_j, correctMazeTwoPath,mazeTwoPath);
}
  
}
