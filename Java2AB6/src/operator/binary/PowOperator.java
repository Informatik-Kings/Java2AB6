package operator.binary;

import java.math.BigDecimal;

/**
 * Stellt die Exponentialrechnung gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class PowOperator extends BinaryOperator
{
   private static final double MAX_EXPONENT = 1E6;
   private static final double MIN_EXPONENT = -1E4;
   /*
    * (non-Javadoc)
    * @see operator.binary.BinaryOperator#eval(double, double)
    */
   @Override
   protected double eval(double x, double y)
   {
      if(!Double.isFinite(x) || !Double.isFinite(y)) {
         throw new IllegalArgumentException("PowOperator: Zahlen müssen endlich sein.");
      }

      // Exponenten wurden so begrenzt, dass die Laufzeit nicht unfassbar lange dauert
      // (siehe Dokumentation BigDecimal.pow())
      if(x > MAX_EXPONENT || x < MIN_EXPONENT)
         throw new IllegalArgumentException("PowOperator: Exponenten dürfen höchstens 1E6 oder -1E4 sein.");

      if(Math.abs(y) >= MANTISSA_MAX_VALUE.doubleValue()) {         
         throw new IllegalArgumentException(
               "PowOperator: Basis darf höchstens (2^53)-1 ins positive oder negative sein.");
      }

      // Ergebnis vorher überprüfen, ob es im Wertebereich liegt      
      BigDecimal b = BigDecimal.valueOf(y);
      BigDecimal result = null;
      if(x < 0) {

         if(Math.abs(y) < MINIMUM)
            throw new IllegalArgumentException("PowOperator: Division by 0 not allowed!");

         //y^-x == 1/y^x
         // In int casten, da pow nur int akzeptiert bei BigDecimal
         result = BigDecimal.ONE.divide(b.pow((int)Math.floor(Math.abs(x))));
      } else {
         result = b.pow((int)Math.floor(x));
      }
      if (result.abs().compareTo(MANTISSA_MAX_VALUE) >= 0) {         
         throw new IllegalArgumentException("PowOperator: Ergebnis darf höchstens (2^53)-1 sein.");
      }

      return Math.pow(y, x);
   }

}
