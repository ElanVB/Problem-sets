public class UniformRandomNumbers {

    public static void main(String[] args) {
        double minVal = 1;
        double maxVal = 0;
        double total = 0;
        int n = 5;
        for (int i=0; i<n; i++) {
            double next = Math.random();
            total += next;
            minVal = Math.min(minVal, next);
            maxVal = Math.max(maxVal, next);
        }
        System.out.println("Minimum: "+minVal);
        System.out.println("Maximum: "+maxVal);
        System.out.println("Average: "+total/n);
    }

}
