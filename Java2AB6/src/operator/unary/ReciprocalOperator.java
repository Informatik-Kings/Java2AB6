package operator.unary;

import exception.IllegalUserInputException;

/**
 * Stellt die Hyperbelfunktion gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class ReciprocalOperator extends UnaryOperator
{

   /* (non-Javadoc)
    * @see operator.unary.UnaryOperator#eval(double)
    */
   @Override
   protected double eval(double x)
   {
      if(Math.abs(x) < MINIMUM) {
         throw new IllegalUserInputException("ReciprocalOperator: Division durch 0!");
      }
      if(!Double.isFinite(x)) {
         throw new IllegalUserInputException("ReciprocalOperator: Ungültiger Wert!");
      }
      if(Math.abs(x) >= MANTISSA_MAX_VALUE.doubleValue()) {         
         throw new IllegalUserInputException(
               "ReciprocalOperator: Zahlen dürfen höchstens (2^53)-1 ins positive oder negative sein.");
      }
      return 1/x;
   }

}
