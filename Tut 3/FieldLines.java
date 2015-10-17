import java.awt.Color;
public class FieldLines
{
  private static int SIZE = 800;
  public static void drawLines(Charge[] array)
  {
    drawPic(drawPotential(array, array.length));
    drawCircles(array);
//draw circle at charge co-ord    
//call drawLine on the 10 points of the charge circle
    
  }
  
  public static void drawCircles(Charge[] array)
  {
    StdDraw.setPenColor(StdDraw.WHITE);
    for(int i = 0; i < array.length; i++)
    {
      StdDraw.circle(array[i].getX()*SIZE, array[i].getY()*SIZE, 5);
    }
  }
  
  private static void drawLine()
  {
    //take current co-ord, check if valid -> calc next co-ord, draw line from current to next co-ord, call this func again (check if out of bounds will make this crash
    
    
  }
  
  public static void drawPic(Picture pic)
  {
    StdDraw.setCanvasSize(pic.width(), pic.height());
    StdDraw.setXscale(0, pic.width());
    StdDraw.setYscale(0, pic.height());
    
    String path = "C:\\Temp\\StdDrawPicTemp.png";
    pic.save(path);
    
    StdDraw.picture(pic.width()/2, pic.height()/2, path);
  }
  
  public static Picture drawPotential(Charge[] array, int N)
  {
    // compute the potential at each point and plot
    Picture pic = new Picture(SIZE, SIZE);
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        double V = 0.0;
        for (int k = 0; k < N; k++) {
          double x = 1.0 * i / SIZE;
          double y = 1.0 * j / SIZE;
          V += array[k].potentialAt(x, y);
        }
        V = 128 + V / 2.0e10;
        int t = 0;
        if      (V <   0) t = 0;
        else if (V > 255) t = 255;
        else              t = (int) V;
        // Color c = new Color(t, t, t);
        Color c = Color.getHSBColor(t / 255.0f, .9f, .9f);
        // Color c = Color.getHSBColor(.75f*t/40, .8f, .8f);
        //int gray = (t * 37) % 255;
        //Color c = new Color(gray, gray, gray);
        pic.set(i, SIZE-1-j, c);
      }
    }
    return pic;
  }
  
  public static void main(String[] args)
  {
    int N = StdIn.readInt();
    Charge[] a = new Charge[N];
    for (int k = 0; k < N; k++) {
      double x0 = StdIn.readDouble();
      double y0 = StdIn.readDouble();
      double q0 = StdIn.readDouble();
      a[k] = new Charge(x0, y0, q0);
    }
    
    drawLines(a);
  }
}