package operator.binary;

import java.math.BigDecimal;
import java.math.MathContext;

import exception.IllegalUserInputException;

/**
 * Stellt die Exponentialrechnung gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class PowOperator extends BinaryOperator
{
   public final static double MAX_EXPONENT = 1E9;
   /*
    * (non-Javadoc)
    * @see operator.binary.BinaryOperator#eval(double, double)
    */
   @Override
   protected double eval(double x, double y)
   {
      if(!Double.isFinite(x) || !Double.isFinite(y)) {
         throw new IllegalUserInputException("PowOperator: Zahlen müssen endlich sein.");
      }
      
      if(Math.abs(x) >= MANTISSA_MAX_VALUE.doubleValue()) {         
         throw new IllegalUserInputException(
               "PowOperator: Basis darf höchstens (2^53)-1 ins positive oder negative sein.");
      }
      
      if(Math.abs(y) >= MAX_EXPONENT) {
         throw new IllegalUserInputException(
               "PowOperator: Exponent darf höchsten eine Millarde sein.");
      }   
      
      
      // Ergebnis vorher überprüfen, ob es im Wertebereich liegt      
      BigDecimal b = BigDecimal.valueOf(y);
      BigDecimal result = null;
      if(x < 0) {
         //y^-x == 1/y^x
         result = BigDecimal.ONE.divide(b.pow((int)Math.floor(Math.abs(x))), MathContext.DECIMAL64);
      } else {
         result = b.pow((int)Math.floor(x));
      }
      if (result.abs().compareTo(MANTISSA_MAX_VALUE) >= 0) {         
         throw new IllegalUserInputException("PowOperator: Ergebnis darf höchstens (2^53)-1 sein.");
      }
      
      return Math.pow(y, x);
   }

}
