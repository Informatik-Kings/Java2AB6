package operator.unary;

import exception.IllegalUserInputException;

/**
 * Stellt die Sinus-Funktion gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class SinOperator extends UnaryOperator
{
   /* (non-Javadoc)
    * @see operator.unary.UnaryOperator#eval(double)
    */
   @Override
   protected double eval(double x)
   {
      if(!Double.isFinite(x)) {
         throw new IllegalUserInputException("SinOperator: Ungültiger Wert!");
      }
      
      return Math.sin(x);
   }

}
