public class DividesEvenly
{
 public static void main(String[] args)
 {
   int int1 = Integer.parseInt(args[0]);
   int int2 = Integer.parseInt(args[1]);
   
   if(int1 % int2 == 0 || int2 % int1 == 0)
  {
     System.out.println("True");
  }
   else
   {
     System.out.println("False"); 
   }
 }
}