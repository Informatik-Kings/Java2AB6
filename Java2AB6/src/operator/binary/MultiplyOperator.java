package operator.binary;

/**
 * Stellt die Multiplikation gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class MultiplyOperator extends BinaryOperator
{
   /*
    * (non-Javadoc)
    * @see operator.binary.BinaryOperator#eval(double, double)
    */
   @Override
   protected double eval(double x, double y)
   {
      return x * y;
   }

}
