public class Quaternion
{
  private final double a0, a1, a2, a3;
  public Quaternion(double a, double b, double c, double d)
  {
    a0 = a;
    a1 = b;
    a2 = c;
    a3 = d;
  }
  
  public Quaternion multiply(double c)
  {
    return new Quaternion(c*a0, c*a1, c*a2, c*a3);
  }
  
  public Quaternion plus(Quaternion b)
  {
    return new Quaternion(a0 + b.a0, a1 + b.a1, a2 + b.a2, a3 + b.a3);
  }
  
  public double norm()
  {
    return Math.sqrt(Math.pow(a0, 2) + Math.pow(a1, 2) + Math.pow(a2, 2) + Math.pow(a3, 2));
  }
  
  public Quaternion conjugate()
  {
    return new Quaternion(a0, -a1, -a2, -a3);
  }
  
  public Quaternion product(Quaternion b)
  {
    return new Quaternion(a0 * b.a0 - a1 * b.a1 - a2 * b.a2 - a3 * b.a3, a0 * b.a1 - a1 * b.a0 + a2 * b.a3 - a3 * b.a2, a0 * b.a2 - a1 * b.a3 + a2 * b.a0 + a3 * b.a1, a0 * b.a3 + a1 * b.a2 - a2 * b.a1 + a3 * b.a0);
  }
  
  public Quaternion inverse()
  {
    return this.conjugate().multiply(1/(double)norm());
  }
  
  public Quaternion divide(Quaternion b)
  {
    return this.product(b.inverse());
  }
  
  public String toString()
  {
    return "(" + a0 + ", " + a1 + ", " + a2 + ", " + a3 + ")";
  }
  
  public static void main(String[] args)
  {
    Quaternion a = new Quaternion(1, 2, 3, 4);
    System.out.println("a" + a);
    
    a = a.multiply(3);
    System.out.println("a x 3 = a" + a);
    
    a = a.multiply((1/(double)3));
    System.out.println("a / 3 = a" + a);
    
    Quaternion b = new Quaternion(5, 2, 4, 87);
    System.out.println("b" + b);
    
    Quaternion c = a.plus(b);
    System.out.println("a + b = c" + c);
    
    double d = a.norm();
    System.out.println("norm a = " + d);
    d = b.norm();
    System.out.println("norm b = " + d);
    
    c = a.conjugate();
    System.out.println("conjugate a" + c);
    c = b.conjugate();
    System.out.println("conjugate b" + c);
    
    c = a.product(b);
    System.out.println("a * b = c" + c);
    
    c = a.inverse();
    System.out.println("inverse a" + c);
    c = b.inverse();
    System.out.println("inverse b" + c);
    
    c = a.divide(b);
    System.out.println("a / b = c" + c);
  }
}