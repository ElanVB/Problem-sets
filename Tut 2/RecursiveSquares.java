public class RecursiveSquares
{
  public static void main(String[] args)
  {
    recSquares(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
  }
  public static void recSquares(int type, int depth)
  {
    if(depth == 1) return;
    
    if (type == 1)
    {
      //call func x 4
      //draw
    }
    else if(type == 2)
    {
      //cal func x2
      //draw
      //cal func x2
    }
    else if(type == 3)
    {
      //cal func x3
      //draw
      //cal func
    }
    else if(type == 4)
    {
//draw      
//call func x 4
    }
  }
}