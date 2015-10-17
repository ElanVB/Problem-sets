public class ArgumentClinic 
{
  public static void main (String[] names)
  {
    String temp = "";
    temp += names[0];
    temp += " is having an argument with ";
    temp += names[1];
    System.out.println(temp);
  }
}