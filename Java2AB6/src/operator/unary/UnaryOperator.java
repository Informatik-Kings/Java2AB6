package operator.unary;

import exception.IllegalUserInputException;
import operator.Operator;
import stack.Stack;

/**
 * Implementiert die Basis für komplexere Berechnung von einstelligen Operationen nach UPN.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public abstract class UnaryOperator implements Operator
{
/*
 * (non-Javadoc)
 * @see operator.Operator#eval(stack.Stack)
 */
   @Override
   public void eval(Stack<Double> stack)
   {
      if (stack == null) {
         throw new IllegalArgumentException("UnaryOperator: Stack ist ungültige NULL Referenz!");
      }
      if (stack.size() < 1) {
         throw new IllegalUserInputException("UnaryOperator: Einstellige Operation benötigt mindestens ein Argument!");
      }
         
      stack.push(eval(stack.pop()));
   }
   
   protected abstract double eval(double x);

}
