public class Erlang
{
  //private static int count = 0;
  public static double recErlang(int n, double p) //it only needs to run 11 times
  {
    //count++;
    double result = 0;
    if(n == 0) {return 1;}
    
    double x = recErlang(n-1, p);
    result = (double)(p*x)/(double)(n + p*x);
    
    return result;
  }
  
  public static double nonrecErlang(int n, double p)
  {
    double result = 0;
    
    
    
    return result;
  }
  
  private static int factorial(int n)
{
  if(n == 2) {return 2;}
  return (n*factorial(n-1));
  
  //int result = 2;
  
  //for(int i = 3; i <= n; i++)
  //{
  //  result *= i;
  //}
  
  //return result;
}
  
  public static void main(String[] args)
  {
    //System.out.println("Recursive: " + recErlang(Integer.parseInt(args[0]), Double.parseDouble(args[1])) + ", count: " + count);
    System.out.println("Recursive: " + recErlang(Integer.parseInt(args[0]), Double.parseDouble(args[1])));
    //System.out.println("Non-Recursive: " + nonrecErlang(Integer.parseInt(args[0], args[1]), Double.parseDouble(args[1])));
  }
}