package operator.binary;

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
      
      return y / x;
      
   }

}
