package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testet den Kosinus-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class CosOperatorTest
{

   CosOperator cos = new CosOperator();
   double delta = 0.0001; // Toleranz

   @Test
   void testFunktionUnten()
   {
      assertEquals(1, cos.eval(-Math.PI*1E307));
      assertEquals(-1, cos.eval(-Math.PI*1E307+Math.PI));
      assertEquals(1, cos.eval(-Math.PI*1E307+(2*Math.PI)));
   }

   @Test
   void testFunktionMitte()
   {
      assertEquals(-1, cos.eval(Math.toRadians(-180)), delta);
      assertEquals(-0.5, cos.eval(Math.toRadians(-120)), delta);
      assertEquals(0, cos.eval(Math.toRadians(-90)), delta);
      assertEquals(0.5, cos.eval(Math.toRadians(-60)), delta);
      assertEquals(1, cos.eval(Math.toRadians(0)), delta);
      assertEquals(0.5, cos.eval(Math.toRadians(60)), delta);
      assertEquals(0, cos.eval(Math.toRadians(90)), delta);
      assertEquals(-0.5, cos.eval(Math.toRadians(120)), delta);
      assertEquals(-1, cos.eval(Math.toRadians(180)), delta);
   }

   @Test
   void testFunktionOben()
   {
      assertEquals(1, cos.eval((Math.PI*1E307)));
      assertEquals(-1, cos.eval(Math.PI*1E307-Math.PI));
      assertEquals(1, cos.eval(Math.PI*1E307-(2*Math.PI)));
   }

}
