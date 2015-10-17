public class ReverseArray
{
  public static void main(String[] args)
  {
    double[] a = new double[args.length];
    
    for(int i = 0; i < args.length; i++)
    {
      a[i] = Double.parseDouble(args[(args.length - 1) - i]);
      System.out.println(a[i]);
    }
  }
}