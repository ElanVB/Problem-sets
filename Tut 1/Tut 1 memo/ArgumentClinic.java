public class ArgumentClinic
{
  public static void main(String[] args)
  {
    if (args.length == 0)
      System.out.println("*crickets*");
    else if (args.length == 1)
      System.out.println(args[0] + " is arguing with themself.");
    else if (args.length > 2)
      System.out.println("Much hilarity ensues.");
    else
      System.out.println(args[0] + " is having an argument with " + args[1] + ".");
  }
}