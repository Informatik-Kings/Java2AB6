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
   double gamma = 0.01; // Toleranz
   double delta = 0.0001; // Toleranz
   
   @Test
   void testGrenzeNullNegativ()
   {
      assertEquals(1.0, cos.eval(-Double.MIN_VALUE));
      assertEquals(1.0, cos.eval(-Double.MIN_VALUE*2));
      assertEquals(1.0, cos.eval(-Double.MIN_VALUE*3));
   }
   
   @Test
   void testGrenzeNullPositiv()
   {
      assertEquals(1.0, cos.eval(Double.MIN_VALUE));
      assertEquals(1.0, cos.eval(Double.MIN_VALUE*2));
      assertEquals(1.0, cos.eval(Double.MIN_VALUE*3));
   }

   @Test
   void testFunktionUnten()
   {
      assertEquals(1, cos.eval(-Math.PI*1E307), gamma);
      assertEquals(-1, cos.eval(-Math.PI*1E307+Math.PI), gamma);
      assertEquals(1, cos.eval(-Math.PI*1E307+(2*Math.PI)), gamma);
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
      assertEquals(1, cos.eval((Math.PI*1E30)), gamma);
      assertEquals(-1, cos.eval(Math.PI*1E30-Math.PI), gamma);
      assertEquals(1, cos.eval(Math.PI*1E30-(2*Math.PI)), gamma);
   }
   
   @Test
   void testSonderfall()
   {
      assertEquals(Double.NaN, cos.eval(Double.NaN));
   }

}
