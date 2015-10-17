import java.util.*;
import java.io.*;
public class Peaks// NOTE!! my program does not take in command line arguments, instead it reads in the file name with stdIn and it will do the rest.
{
  public static boolean debug = false;
  
  public static void main(String[] args)
  {
    System.out.println("Enter the name of the file you would like to use from the Peaks_resources folder,\nOr Enter the dimension for a square grid and number of simulations you want ran.");
    
    String input = StdIn.readLine();
    
    if(Character.isDigit((input.charAt(0))))
    {
      simulatePeaks(input);
    }
    else
    {
      scanFileForPeaks(input);
    }
  }
  
  private static String countFile(String filename)
  {
    String result = "";
    int row = 0;
    int colCheck = 0;
    int col = 0;
    
    try
    {
    Scanner fileScanner = new Scanner(new File("Peaks_resources\\" + filename));
    
    while(fileScanner.hasNextLine())
    {
      Scanner lineScanner = new Scanner(fileScanner.nextLine());
      while(lineScanner.hasNextDouble())
      {
        col++;
        lineScanner.next();
      }
      row++;
      
      if(debug)
      {
        System.out.println(col + " cols.");
      }
      
      if(colCheck == 0)
      {
        colCheck = col;
      }
      else if(col != colCheck)
      {
        System.out.println("Number of cols in the file is inconsistent.");
      }
      
      lineScanner.close();
      col = 0;
    }
    
    fileScanner.close();
    
    result = row + " " + colCheck;
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e);
    }
    return result;
  }

  private static void populateArray(double[][] array, String filename, int rows, int cols)
  {
    try
    {
    Scanner fileScanner = new Scanner(new File("Peaks_resources\\" + filename));
    
    for(int y = 0; y < rows; y++)
    {
      Scanner lineScanner = new Scanner(fileScanner.nextLine());
      
      for(int x = 0; x < cols; x++)
      {
        array[y][x] = lineScanner.nextDouble();
      }
      
      lineScanner.close();
    }
    
    fileScanner.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.println(e);
    }
  }
  
  private static boolean isEdge(double[][] array, int row, int col, int rows, int cols)
  {
    boolean result = false;
    
    if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1)
    {
      result = true;
    }
    
    return result;
  }
  
  private static boolean isPeak(double[][] array, int row, int col)
  {
    boolean result = false;
    if(array[row][col] > array[row-1][col] && array[row][col] > array[row+1][col] && array[row][col] > array[row][col-1] && array[row][col] > array[row][col+1])
    {
      result = true;
    }
    return result;
  }
  
  private static void printPeaks(double[][] array, int rows, int cols)
  {
    for(int row = 0; row < rows; row++)
    {
      for(int col = 0; col < cols; col++)
      {
        if(!isEdge(array, row, col, rows, cols))
        {
          if(isPeak(array, row, col))
          {
            System.out.println((row + 1) + "," + (col + 1) + "->" + array[row][col]);
          }
        }
      }
    }
  }

private static int maxPeaks(int rows, int cols)//i thought i was going to use it but didnt need it in the end.....
{
  int result = 0;
  
  result = ((rows*cols) - 2*((rows - 1) + (cols - 1)))/2;
  
  return result;
}

public static void simulatePeaks(String input)
{
  Scanner sc = new Scanner(input);
  int gridSize = sc.nextInt();
  int simulations = sc.nextInt();
  sc.close();
  
  for(int i = 0; i < gridSize; i++)
  {
    double[][] terrain = new double[i][i];
    randomlyPopulateArray(terrain, i);
    
    double averageNumPeaks = 0;
    double averageMaxPeak = 0;
    int countPeaks = 0;
    
    
    for(int j = 0; j < simulations; j++)
    {
      
      double max = 0;
      for(int row = 0; row < i; row++)
      {
        for(int col = 0; col < i; col++)
        {
          if(!isEdge(terrain, row, col, i, i))
          {
            if(isPeak(terrain, row, col))
            {
              countPeaks++;
              if (max < terrain[row][col])
              {
                max = terrain[row][col];
              }
            }
          }
        }
      }
      averageMaxPeak += max;
      max = 0;
    }
    averageNumPeaks = (double) countPeaks / (double) simulations;
    averageMaxPeak /= (double) simulations;
    countPeaks = 0;
    
    System.out.println((i + 1) + "\t" + averageNumPeaks + " " + averageMaxPeak);
  }
}

public static void scanFileForPeaks(String fileName)
{
  String fileSize = countFile(fileName);
  
  Scanner sc = new Scanner(fileSize);
  int rows = sc.nextInt();
  int cols = sc.nextInt();
  sc.close();
  
  double[][] terrain = new double[rows][cols];
  
  populateArray(terrain, fileName, rows, cols);
  printPeaks(terrain, rows, cols);
}

public static void randomlyPopulateArray(double[][] array, int size)
{
  for(int row = 0; row < size; row++)
  {
    for(int col = 0; col < size; col++)
    {
      array[row][col] = Math.random();
    }
  }
}
}