package operator.binary;

import java.math.BigDecimal;
import java.math.MathContext;

import exception.IllegalUserInputException;

/**
 * Stellt die Division gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class DivOperator extends BinaryOperator
{
   /*
    * (non-Javadoc)
    * @see operator.binary.BinaryOperator#eval(double, double)
    */
   @Override
   protected double eval(double x, double y)
   {
      if(Math.abs(x) < EPSILON) {
         throw new IllegalUserInputException("DivideOperator: Division durch 0!");
      }

      if(!Double.isFinite(x) || !Double.isFinite(y)) {
         throw new IllegalUserInputException("DivideOperator: Zahlen müssen endlich sein.");
      }

      // Ergebnis vorher überprüfen, ob es im Wertebereich liegt
      BigDecimal a = BigDecimal.valueOf(x);
      BigDecimal b = BigDecimal.valueOf(y);
      BigDecimal result = b.divide(a, MathContext.DECIMAL64);
      if (result.abs().compareTo(BIG_DECIMAL_DOUBLE_MAX_VALUE) > 0) {         
         throw new IllegalUserInputException("DivideOperator: Ergebnis > Double.MAX_VALUE!");
      }

      return result.doubleValue();
   }

}
