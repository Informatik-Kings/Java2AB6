package upn;

import exception.IllegalUserInputException;
import operator.Operator;
import operator.OperatorMap;
import stack.Stack;

/**
 * Utility-Klasse welche einen Rechner nach dem Prinzip der Umgekehrten Polnischen Notation zu Verfügungstellt.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public final class UPNRechner
{

   private final static String REGEX_WHITESPACE = "[\\p{Space}]+";

   /**
    * Privater Konstruktor, damit kein Objekt dieser Klasse angelegt werden kann.
    *
    */
   private UPNRechner()
   {

   }

   /**
    * 
    * Methode zur Berechnung eines Ausdrucks im UPN Format.
    *
    * @param input Ausdruck im UPN Format.
    * @return Berechneter Wert.
    */
   public static double rechnung(String input) {
      if(input == null) {
         throw new IllegalUserInputException("Methode rechnung: String ist ungültige NULL Referenz!");
      }
      if(input.trim().isEmpty()) {
         throw new IllegalUserInputException("Methode rechnung: Der eingegebene String ist leer!");
      }

      Stack<Double> upnStack = new Stack<Double>();
      OperatorMap operatorMap = new OperatorMap();
      Operator operator = null;
      
      for(String token : input.trim().split(REGEX_WHITESPACE)) {

         try {

            upnStack.push(Double.parseDouble(token));

         } catch (NumberFormatException E) {
            operator = operatorMap.get(token);
            
            if(operator == null) {
               throw new IllegalUserInputException("Methode rechnung: Unbekannter Operator");
            }

               operator.eval(upnStack);

         }

      }

      if(upnStack.size() > 1) {
         throw new IllegalUserInputException("Methode rechnung: Zu viele Operanden!");
      }

      return upnStack.pop();

   }

}
