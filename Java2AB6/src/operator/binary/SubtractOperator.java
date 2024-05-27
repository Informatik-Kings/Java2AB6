package operator.binary;

import exception.IllegalUserInputException;

/**
 * Stellt die Subtraktion gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class SubtractOperator extends BinaryOperator
{
   /*
    * (non-Javadoc)
    * @see operator.binary.BinaryOperator#eval(double, double)
    */
   @Override
   protected double eval(double x, double y)
   {
      Double result = y - x;
      
      if(result.isInfinite()) {
         throw new IllegalUserInputException("SubtractOperator: Mathematischer Fehler!");
      }
      
      return result;
   }

}
