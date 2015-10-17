import java.math.*;
public class SideLength
{
  public static void main(String[] args)
  {
    float total = 0;
    total = (float) Math.sqrt(Math.pow(Float.parseFloat(args[0]), 2) + Math.pow(Float.parseFloat(args[1]), 2));
    System.out.println(total);
  }
}