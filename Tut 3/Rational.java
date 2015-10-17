public class Rational
{
  private int numerator, denominator;
  public Rational(int n, int d)
  {
    numerator = n;
    denominator = d;
  }
  
  public Rational plus(Rational b)
  {
    Rational result = new Rational(numerator, denominator);
    
    result.setNumerator(numerator + b.getNumerator()*denominator);
    result.setDenominator(denominator*b.getDenominator());
    
    return result;
  }
  
  public Rational minus(Rational b)
  {
    Rational result = new Rational(numerator, denominator);
    
    result.setNumerator(numerator - b.getNumerator()*denominator);
    result.setDenominator(denominator*b.getDenominator());
    
    return result;
  }
  
  public Rational times(Rational b)
  {
    Rational result = new Rational(numerator, denominator);
    
    result.setNumerator(numerator*b.getNumerator());
    result.setDenominator(denominator*b.getDenominator());
    
    return result;
  }
  
  public Rational over(Rational b)
  {
    Rational result = new Rational(numerator, denominator);
    
    result.setNumerator(numerator*b.getDenominator());
    result.setDenominator(denominator*b.getNumerator());
    
    return result;
  }
  
  private void setNumerator(int n)
  {
    numerator = n;
  }
  
  private int getNumerator()
  {
    return numerator;
  }
  
  private void setDenominator(int n)
  {
    denominator = n;
  }
  
  private int getDenominator()
  {
    return denominator;
  }
  
  public String toString()
  {
    return "numerator: " + numerator + ", denominator: " + denominator;
  }
}