public class Circles
{
  public static void main(String[] args)
  {
    StdDraw.setXscale(0, 100);//Pg 153
    StdDraw.setYscale(0,100);
    
    int numCircles = Integer.parseInt(args[0]);
    double probOfBlackCir = Double.parseDouble(args[1]);
    double minRad = Double.parseDouble(args[2]);
    double maxRad = Double.parseDouble(args[3]);
    
    for(int i = 0; i < numCircles; i++)
    {
      double radius = minRad + (Math.random() * (maxRad - minRad));
      double x = (Math.random() * 100);
      double y = (Math.random() * 100);
      
      if((int) (Math.random() * 100) <= (int) (probOfBlackCir * 100))
      {
        StdDraw.filledCircle(x, y, radius);
      }
      else
      {
        StdDraw.circle(x, y, radius);
      }
    }
  }
}