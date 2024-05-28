package operator.unary;

import exception.IllegalUserInputException;

/**
 * Stellt den natürlichen Logarithmus gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class LogOperator extends UnaryOperator
{

   /* (non-Javadoc)
    * @see operator.unary.UnaryOperator#eval(double)
    */
   @Override
   protected double eval(double x)
   {
      if(x <= 0) {
         throw new IllegalUserInputException("LogOperator: x <= 0");
      }
      if(!Double.isFinite(x)) {
         throw new IllegalUserInputException("LogOperator: Ungültiger Wert!");
      }
      if(Math.abs(x) >= MANTISSA_MAX_VALUE.doubleValue()) {         
         throw new IllegalUserInputException(
               "LogOperator: Zahlen dürfen höchstens (2^53)-1 ins positive oder negative sein.");
      }
      return Math.log(x);
   }

}
