public class TestHistograms
{
  public static void main(String[] args)
  {
    int[] data = new int[Integer.parseInt(args[1])];
    
    for(int i = 0; i < Integer.parseInt(args[1]); i++)
    {
      data[i] = Integer.parseInt(args[i + 2]);
    }
    
    int[] frequencey = Histograms.histogram(Integer.parseInt(args[0]), data);
    
    print(frequencey);
  }
  
  public static void print(int[] array)
  {
    for(int i = 0; i < array.length; i++)
    {
      System.out.print(array[i] + " ");
    }
  }
}