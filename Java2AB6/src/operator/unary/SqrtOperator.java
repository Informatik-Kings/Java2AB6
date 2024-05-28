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
      if(!Double.isFinite(x)) {
         throw new IllegalUserInputException("SqrtOperator: Ungültiger Wert!");
      }
      if(Math.abs(x) >= MANTISSA_MAX_VALUE.doubleValue()) {         
         throw new IllegalUserInputException(
               "SqrtOperator: Zahlen dürfen höchstens (2^53)-1 ins positive oder negative sein.");
      }
      return Math.sqrt(x);
   }

}
