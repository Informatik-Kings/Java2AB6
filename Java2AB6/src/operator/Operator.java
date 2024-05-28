package operator;

import java.math.BigDecimal;

import stack.Stack;

/**
 * Interface welches die Berechnung eines Operators nach UPN zu Verfügung stellt.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public interface Operator
{
   public final static double MINIMUM = 1E-12;
   public final static BigDecimal MANTISSA_MAX_VALUE = BigDecimal.valueOf(Math.pow(2, Double.PRECISION));
   /**
    * 
    * Stellt eine Berechnungs-Methode für UPN bereit.
    *
    * @param stack UPN Stack
    */
   public void eval(Stack<Double> stack);
}
