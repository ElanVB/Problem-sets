import java.awt.Color;
public class Swirl
{
  private static final boolean DEBUG = false;
  
  public static void main(String[] args)
  {
    swirlImage(args[0]);
  }
  
  private static void swirlImage(String fileName)
  {
    double theataScale = Math.PI/ (double) 256;
    
    Picture input = new Picture (fileName);
    Picture output = new Picture (input.width(), input.height());
    
    int xC = input.width()/2, yC = input.height()/2;
    
    for(int i = 0; i < input.width(); i++)
    {
      for(int j = 0; j < input.height(); j++)
      {
        int x, y;
        
        x = (int) ((i - xC) * Math.cos(theataScale*calcDist(i, j, xC, yC)) - (j - yC)*Math.sin(theataScale*calcDist(i, j, xC, yC)) + xC);
        y = (int) ((i - xC) * Math.sin(theataScale*calcDist(i, j, xC, yC)) + (j - yC)*Math.cos(theataScale*calcDist(i, j, xC, yC)) + yC);
        
        if(DEBUG)
        {
          System.out.println("Source Co-oord: x - " + i + ", y - " + j);
          System.out.println("Target Co-oord: x - " + x + ", y - " + j);
          System.out.println("Color: r - " + input.get(i, j).getRed() + ", g - " + input.get(i, j).getGreen() + ", b - " + input.get(i, j).getBlue());
        }
        
        if(x > 0 && x < input.height() && y > 0 && y < input.width())
          output.set(x, y, input.get(i, j));//check x and y for pic boundries
      }
    }
    output.show();
  }
  
  private static double calcDist(int x, int y, int cX, int cY)
  {
    return (double) Math.sqrt(Math.pow(x - cX, 2) + Math.pow(y - cY, 2));
  }
}