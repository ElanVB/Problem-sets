public class DividesEvenly
{
  public static void main(String args[])
  {
    int num1 = Integer.parseInt(args[0]);
    int num2 = Integer.parseInt(args[1]);
    
    System.out.println(((num1 % num2) == 0) || ((num2 % num1) == 0));
  }
}
