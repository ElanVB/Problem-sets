import java.util.Scanner;
import java.io.*;
public class Transition
{
  public static void main(String[] args)
  {
    int[][] fileStats = readLinksFile("eightpage.txt");
    
    double[][] transTable = new double[fileStats[0].length][fileStats[0].length];
    fillArray(transTable, 0.02);
    
    createTransision(fileStats, transTable);
    //printArray(transTable);
  }
  
  private static int[][] readLinksFile(String fileName)
  {
    try
    {  
    Scanner fileScanner = new Scanner(new File(fileName));
    int rows = Integer.parseInt(fileScanner.nextLine());
    int[][] fileStats = new int[rows][rows];
    
    while(fileScanner.hasNextLine())
    {
      Scanner lineReader = new Scanner(fileScanner.nextLine());
      int page = lineReader.nextInt();
      
      while(lineReader.hasNext())
      {
        fileStats[page][lineReader.nextInt()]++;
      }
      lineReader.close();
    }
    fileScanner.close();
    return fileStats;
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    return new int[0][0];
  }
  
  private static void fillArray(double[][] array, double value)
  {
    for(int row = 0; row < array[0].length; row++)
    {
      for(int col = 0; col < array[0].length; col++)
      {
        array[row][col] = value;
      }
    }
  }
  
  private static int sum2DArrayRow(int[][] array, int row)
  {
    int result = 0;
    for(int col = 0; col < array[0].length - 1; col++)
    {
      result += array[row][col];
    }
    return result;
  }
  
  private static void divideRowProb(int[][] input, double[][] output, int row, double divisor, double totalProb)
  {
    double singleProb = totalProb/divisor;
    
    for(int i = 0; i < input[0].length; i++)
    {
      output[row][i] = input[row][i]*singleProb;
    }
  }
  
  private static void createTransision(int[][] input, double[][] output)
  {
    for(int i = 0; i < input[0].length; i++)
    {
      divideRowProb(input, output, i, sum2DArrayRow(input, i), 0.9);
    }
  }
  
  private static void printArray(double[][] array)
  {
    for(int row = 0; row < array[0].length; row++)
    {
      for(int col = 0; col < array[0].length; col++)
      {
        System.out.print(array[row][col] + " ");
      }
      System.out.println();
    }
  }
}