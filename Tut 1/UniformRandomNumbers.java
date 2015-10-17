import java.math.*;
public class UniformRandomNumbers
{
 public static void main(String[] args)
 {
   double randNums[] = {0,0,0,0,0};
   double max = 0;
   double min = 2;
   float avg = 0;
  
  for(int i = 0; i < 5; i++)
  {
   randNums[i] = (Math.random());
   System.out.println(randNums[i]);
   
   avg += randNums[i];
   
   max = Math.max(max, randNums[i]);
   min = Math.min(min, randNums[i]);
  }
  
  avg /= 5;
  
  System.out.println("The Max is: " + max);
  System.out.println("The Min is: " + min);
  System.out.println("The Average is: " + avg);
 }
}