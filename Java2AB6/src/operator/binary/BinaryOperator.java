package operator.binary;

import exception.IllegalUserInputException;
import operator.Operator;
import stack.Stack;

/**
 * Implementiert die Basis für grundlegende Berechnung von zweistelligen Operationen nach UPN.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public abstract class BinaryOperator implements Operator
{
   /*
    * (non-Javadoc)
    * @see operator.Operator#eval(stack.Stack)
    */
   @Override
   public void eval(Stack<Double> stack)
   {
      if (stack == null) {
         throw new IllegalArgumentException("BinaryOperator: Stack ist ungültige NULL Referenz!");
      }
      if (stack.size() < 2) {
         throw new IllegalUserInputException("BinaryOperator: Binäre Operation benötigt mindestens zwei Argumente!");
      }
      
      stack.push(eval(stack.pop(), stack.pop()));
   }
   
   protected abstract double eval(double x, double y);
   
   
}
