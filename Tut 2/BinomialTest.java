import junit.framework.TestCase;

public class BinomialTest extends TestCase {
  public void assertAlmostEqual(double a, double b)
  {
    if (((a * 0.9999) > b) || (b > (a * 1.0001))) {
      fail(b + " is not within 0.01% of " + a);
    }
  }
  
  public void testSmallValues() {
    /* The following probabilities are for the case where we flip one coin.
     * The probability that it will be heads is 50%, 50% tails.*/
    assertAlmostEqual(0.5, Binomial.binomial(1, 0, 0.5));
    assertAlmostEqual(0.5, Binomial.binomial(1, 1, 0.5));
    
    /* The following probabilities are for the case where we flip two coins.
     * The probability that both will be heads is 25% (HH)
     * that one will be heads and the other tails is 50% (HT or TH)
     * that both will be tails is 25% (TT) */
    assertAlmostEqual(0.25, Binomial.binomial(2, 0, 0.5));
    assertAlmostEqual(0.5, Binomial.binomial(2, 1, 0.5));
    assertAlmostEqual(0.25, Binomial.binomial(2, 2, 0.5));

    assertAlmostEqual(0.25412, Binomial.binomial(8, 5, 0.7));
  }

   public void testBigValues() {
    /* If your code chokes on these, then you probably haven't been using logarithms
     * to prevent numerical overflow you naughty person */
    assertAlmostEqual(1.3026e-05, Binomial.binomial(100, 50, 0.3));
    assertAlmostEqual(0.057506, Binomial.binomial(200, 80, 0.4));
    assertAlmostEqual(0.0025752, Binomial.binomial(100000, 40000, 0.4));
   }
}
