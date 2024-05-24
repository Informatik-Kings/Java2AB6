package operator.unary;

import exception.IllegalUserInputException;

/**
 * Stellt die Wurzel-Funktion gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class SqrtOperator extends UnaryOperator
{
   /* (non-Javadoc)
    * @see operator.unary.UnaryOperator#eval(double)
    */
   @Override
   protected double eval(double x)
   {
      if(x < 0) {
         throw new IllegalUserInputException("SqrtOperator: Negative Wurzel nicht möglich!");
      }
      return Math.sqrt(x);
   }

}
