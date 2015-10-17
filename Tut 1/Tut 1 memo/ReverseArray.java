public class ReverseArray {

  public static void main(String[] args) {

    double d[] = new double[args.length];

    for (int i = 0; i < d.length; i++) d[i] = Double.parseDouble(args[i]);

    for (int i = 0; i < d.length / 2; i++) { // Note this loop stops (possibly just before) half-way through the array
      double tmp = d[i];
      d[i] = d[d.length-i-1];
      d[d.length-i-1] = tmp;
    }

    for(int i = 0; i < d.length; i++) System.out.println(d[i]);
  }
}
