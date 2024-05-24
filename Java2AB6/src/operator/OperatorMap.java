package operator;

import java.util.HashMap;

import operator.binary.AddOperator;
import operator.binary.DivideOperator;
import operator.binary.MultiplyOperator;
import operator.binary.PowOperator;
import operator.binary.SubtractOperator;
import operator.unary.CosOperator;
import operator.unary.LogOperator;
import operator.unary.ReciprocalOperator;
import operator.unary.SinOperator;
import operator.unary.SqrtOperator;
import operator.unary.TanOperator;

/**
 * Spezialisierung der HashMap, welche mathematische Operationen zur Verfügung
 * stellt.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class OperatorMap
{
   HashMap<String, Operator> map = new HashMap<String, Operator>(); 
   /**
    * 
    * Füllt die HashMap welche die grundlegenden mathematische Operationen und
    * diverse Operationen aus Math Klasse zu Verfügung stellt.
    *
    */
   public OperatorMap()
   {
      map.put("+", new AddOperator());
      map.put("-", new SubtractOperator());
      map.put("*", new MultiplyOperator());
      map.put("/", new DivideOperator());
      map.put("ln", new LogOperator());
      map.put("sin", new SinOperator());
      map.put("cos", new CosOperator());
      map.put("tan", new TanOperator());
      map.put("rec", new ReciprocalOperator());
      map.put("pow", new PowOperator());
      map.put("sqrt", new SqrtOperator());
   }
   
   /**
    * @see {@link HashMap#get(Object)}
    */
   public Operator get(String operator) {
      if(operator == null) {
         throw new IllegalArgumentException("Ungültige null-Referenz!");
      }
      if(operator.isBlank()) {
         throw new IllegalArgumentException("Leerer String!");
      }
      return map.get(operator);
   }

}
