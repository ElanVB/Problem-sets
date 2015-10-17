public class SideLength
{
  public static void main(String args[])
  {
    double num1 = Double.parseDouble(args[0]);
    double num2 = Double.parseDouble(args[1]);
    
    System.out.println(Math.sqrt(num1*num1 + num2*num2));
  }
}