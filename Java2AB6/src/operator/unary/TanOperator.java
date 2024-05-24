package operator.unary;

import exception.IllegalUserInputException;

/**
 * Stellt die Tangens-Funktion gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class TanOperator extends UnaryOperator
{

   /* (non-Javadoc)
    * @see operator.unary.UnaryOperator#eval(double)
    */
   @Override
   protected double eval(double x)
   {
      //tan(x) = sin(x) / cos(x). Wenn Ergebnis von cos(x) = 0, dann ND.
      if(Math.abs(Math.cos(x)) < MINIMUM) {
         throw new IllegalUserInputException("TanOperator: Tangens an diesem Punkt nicht definiert!");
      }
      return Math.tan(x);
   }

}
