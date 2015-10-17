public class Binomial
{
  public static double binomial(int N, int k, double p)
  {
    double result = 0;
    int counter = 0;
    while(counter != N)
    {
      result += reducedBinFormula(N, k, p);
      counter++;
    }
    return Math.exp(result);
    }
private static int factorial(int n)
{
  //if(n == 2) {return 2;}
  //return (n*factorial(n-1));
  
  int result = 2;
  
  for(int i = 3; i <= n; i++)
  {
    result *= i;
  }
  
  return result;
}

  public static void main(String[] args)
  {
    double answer = binomial(Integer.parseInt(args[0]), 0, Double.parseDouble(args[1]));
  }
  
  private static double reducedBinFormula(int N, int k, double p)
  {
    return (k*Math.log(p) + (N-k)*Math.log(1-p) + Math.log(factorial(N)) - Math.log(factorial(k)) - Math.log(factorial(N-k)));
  }
}