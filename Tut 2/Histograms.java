public class Histograms
{
  public static int[] histogram(int m, int[] array)
  {
    int[] result = new int[m];
    
    for(int i = 0; i < array.length; i++)
    {
      if(array[i] < m)
        result[array[i]]++;
    }
    
    return result;
  }
}