package operator.binary;

import java.math.BigDecimal;

import exception.IllegalUserInputException;

/**
 * Stellt die Division gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class DivideOperator extends BinaryOperator
{
   /*
    * (non-Javadoc)
    * @see operator.binary.BinaryOperator#eval(double, double)
    */
   @Override
   protected double eval(double x, double y)
   {
      if(Math.abs(x) < MINIMUM) {
         throw new IllegalUserInputException("DivideOperator: Division durch 0!");
      }
      
      if(!Double.isFinite(x) || !Double.isFinite(y)) {
         throw new IllegalUserInputException("DivideOperator: Zahlen müssen endlich sein.");
      }
      
      if(Math.abs(x) >= MANTISSA_MAX_VALUE.doubleValue() || Math.abs(y) >= MANTISSA_MAX_VALUE.doubleValue()) {         
         throw new IllegalUserInputException(
               "DivideOperator: Zahlen dürfen höchstens (2^53)-1 ins positive oder negative sein.");
      }
      
      // Ergebnis vorher überprüfen, ob es im Wertebereich liegt
      BigDecimal a = BigDecimal.valueOf(x);
      BigDecimal b = BigDecimal.valueOf(y);
      BigDecimal result = b.divide(a);
      if (result.abs().compareTo(MANTISSA_MAX_VALUE) >= 0) {         
         throw new IllegalUserInputException("DivideOperator: Ergebnis darf höchstens (2^53)-1 sein.");
      }
      
      return y / x;
   }

}
