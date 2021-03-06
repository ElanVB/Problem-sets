import java.awt.Color;
public class RecursiveSquares
{
  public static void main(String[] args)
  {
    StdDraw.setXscale(0, 200);
    StdDraw.setYscale(0, 200);
    recSquares(Integer.parseInt(args[0]), Integer.parseInt(args[1]), 100, 100, 50);
  }
  public static void recSquares(int type, int n, double x, double y, double r)
  {
    if(n == 0) return;
    
    if (type == 1)
    {
      recSquares(1, n-1, (x+r), (y+r), r/2);
      recSquares(1, n-1, (x-r), (y+r), r/2);
      recSquares(1, n-1, (x+r), (y-r), r/2);
      recSquares(1, n-1, (x-r), (y-r), r/2);
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.filledSquare(x, y, r);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.square(x, y, r);
    }
    else if(type == 2)
    {
      //cal func x2
      //draw
      //cal func x2
      
      recSquares(2, n-1, (x+r), (y+r), r/2);
      recSquares(2, n-1, (x-r), (y+r), r/2);
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.filledSquare(x, y, r);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.square(x, y, r);
      recSquares(2, n-1, (x+r), (y-r), r/2);
      recSquares(2, n-1, (x-r), (y-r), r/2);
    }
    else if(type == 3)
    {
      //cal func x3
      //draw
      //cal func
      
      recSquares(3, n-1, (x+r), (y-r), r/2);
      recSquares(3, n-1, (x-r), (y-r), r/2);
      recSquares(3, n-1, (x-r), (y+r), r/2);
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.filledSquare(x, y, r);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.square(x, y, r);
      recSquares(3, n-1, (x+r), (y+r), r/2);
    }
    else if(type == 4)
    {
//draw      
//call func x 2
      StdDraw.setPenColor(StdDraw.GRAY);
      StdDraw.filledSquare(x, y, r);
      StdDraw.setPenColor(StdDraw.BLACK);
      StdDraw.square(x, y, r);
      recSquares(4, n-1, (x+r), (y-r), r/2);
      recSquares(4, n-1, (x-r), (y-r), r/2);
      recSquares(4, n-1, (x-r), (y+r), r/2);
      recSquares(4, n-1, (x+r), (y+r), r/2);
    }
  }
}