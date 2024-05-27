package operator.binary;

import exception.IllegalUserInputException;

/**
 * Stellt die Addition gekapselt in einer Klasse zu Verfügung.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class AddOperator extends BinaryOperator
{
   /*
    * (non-Javadoc)
    * @see operator.binary.BinaryOperator#eval(double, double)
    */
   @Override
   protected double eval(double x, double y)
   {
      Double result = x + y;
      
      if(result.isInfinite()) {
         throw new IllegalUserInputException("AddOperator: Mathematischer Fehler!");
      }
      
      return result;
   }

}
