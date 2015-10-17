import java.awt.Image;
public class StdDrawPic extends StdDraw
{
  public static void picture(Picture p)
  {
    String path = "C:\\Temp\\StdDrawPicTemp.png";
    p.save(path);
    
    Image image = getImage(path);
    double xs = scaleX(pic.getWidth()/2);
    double ys = scaleY(pic.getHeight()/2);
    
    int ws = pic.getWidth();
    int hs = pic.getHeight();
    
    offscreen.drawImage(image, (int) Math.round(xs - ws/2.0), (int) Math.round(ys - hs/2.0), null);
    draw();
  }
}

 /*************************************************************************
    *  Drawing images.
    ************************************************************************

    // get an image from the given filename
    private Image getImage(String filename) {

        // to read from file
        ImageIcon icon = new ImageIcon(filename);

        // try to read from URL
        if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
            try {
                URL url = new URL(filename);
                icon = new ImageIcon(url);
            } catch (Exception e) { /* not a url //////////////// }
        }

        // in case file is inside a .jar
        if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
            URL url = Draw.class.getResource(filename);
            if (url == null) throw new RuntimeException("image " + filename + " not found");
            icon = new ImageIcon(url);
        }

        return icon.getImage();
    }*/

/*
public static void picture(Picture p)
  {
    Image image = getImage(p);
    double xs = scaleX(pic.getWidth()/2);
    double ys = scaleY(pic.getHeight()/2);
    
    int ws = pic.getWidth();
    int hs = pic.getHeight();
    
    offscreen.drawImage(image, (int) Math.round(xs - ws/2.0), (int) Math.round(ys - hs/2.0), null);
    draw();
  }*/