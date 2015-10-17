import java.io.*;
public class Peaks
{
  public static void main(String[] args)
  {
    String fileName = StdIn.readString();
    String fileSize = countFile(fileName);
    
    Scanner sc = new Scanner(fileSize);
    int rows = fileSize.nextInt();
    int cols = fileSize.nextInt();
    
    double[][] terrain = new Double[rows][cols];
    
    populateArray(terrain, fileName, rows, cols);
    
    
  }
  
  private static String countFile(String filename)
  {
    String result = "";
    int row = 0;
    int rowCheck = 0;
    int col = 0;
    
    Scanner fileScanner = new Scanner(File filename));
    
    while(fileScanner.hasNextLine())
    {
      Scanner lineScanner = new Scanner(fileScanner.nextLine());
      while(lineScanner.hasNextDouble())
      {
        row++;
        lineScanner.next();
      }
      col++;
                                        
      if(row = 0)
      {
        rowCheck = row;
      }
      else if(row != rowCheck)
      {
        System.out.println("Number of rows in the file is inconsistent.");
      }
                                        
      lineScanner.close();
    }
    
    fileScanner.close();
    
    result = row + " " col;
    return result;
  }
}

private static void populateArray(int[][] 2DArray, String fileName, int rows, int cols)
{
  Scanner fileScanner = new Scanner(File fileName);
  
  for(int y = 0; x < rows; x++)
  {
    Scanner lineScanner = new Scanner(fileScanner.nextLine());
    
    for(int x = 0; y < cols; y++)
    {
      2DArray[x][y] = lineScanner.nextDouble();
    }
    
    lineScanner.close();
  }
  
  fileScanner.close();
}