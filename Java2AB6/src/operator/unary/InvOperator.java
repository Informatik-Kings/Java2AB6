package operator.unary;

import java.math.BigDecimal;
import java.math.MathContext;

import exception.IllegalUserInputException;

/**
 * Stellt die Hyperbelfunktion gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class InvOperator extends UnaryOperator
{

   /* (non-Javadoc)
    * @see operator.unary.UnaryOperator#eval(double)
    */
   @Override
   protected double eval(double x)
   {
      if(Math.abs(x) < EPSILON) {
         throw new IllegalUserInputException("ReciprocalOperator: Division durch 0!");
      }
      if(!Double.isFinite(x)) {
         throw new IllegalUserInputException("ReciprocalOperator: Ungültiger Wert!");
      }

      // Ergebnis vorher überprüfen, ob es im Wertebereich liegt
      BigDecimal a = BigDecimal.valueOf(x);
      BigDecimal result = BigDecimal.ONE.divide(a, MathContext.DECIMAL64);
      if (result.abs().compareTo(BIG_DECIMAL_DOUBLE_MAX_VALUE) > 0) {         
         throw new IllegalUserInputException("ReciprocalOperator: Ergebnis > Double.MAX_VALUE!");
      }

      return result.doubleValue();
      
   }

}
