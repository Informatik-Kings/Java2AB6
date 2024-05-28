package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testet den Tangens-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class TanOperatorTest
{

   TanOperator tan = new TanOperator();
   double gamma = 0.13; // Toleranz
   double delta = 0.0001; // Toleranz
   
   @Test
   void testGrenzeNullNegativ()
   {
      assertEquals(-Double.MIN_VALUE, tan.eval(-Double.MIN_VALUE));
      assertEquals(-Double.MIN_VALUE*2, tan.eval(-Double.MIN_VALUE*2));
      assertEquals(-Double.MIN_VALUE*3, tan.eval(-Double.MIN_VALUE*3));
   }
   
   @Test
   void testGrenzeNullPositiv()
   {
      assertEquals(Double.MIN_VALUE, tan.eval(Double.MIN_VALUE));
      assertEquals(Double.MIN_VALUE*2, tan.eval(Double.MIN_VALUE*2));
      assertEquals(Double.MIN_VALUE*3, tan.eval(Double.MIN_VALUE*3));
   }

   @Test
   void testFunktionUnten()
   {
      assertEquals(0, tan.eval(-Math.PI*1E307), gamma);
      assertEquals(0, tan.eval(-Math.PI*1E307+Math.PI), gamma);
      assertEquals(0, tan.eval(-Math.PI*1E307+(2*Math.PI)), gamma);
   }

   @Test
   void testFunktionMitte()
   {
      assertEquals(-1, tan.eval(Math.toRadians(-225)), delta);
      assertEquals(-0, tan.eval(Math.toRadians(-180)), delta);
      assertEquals(-1, tan.eval(Math.toRadians(-45)), delta);
      assertEquals(0, tan.eval(Math.toRadians(0)), delta);
      assertEquals(1, tan.eval(Math.toRadians(45)), delta);
      assertEquals(0, tan.eval(Math.toRadians(180)), delta);
      assertEquals(1, tan.eval(Math.toRadians(225)), delta);
   }

   @Test
   void testFunktionOben()
   {
      System.out.println(tan.eval((Math.PI*1E307)));
      assertEquals(0, tan.eval((Math.PI*1E307)), gamma);
      assertEquals(0, tan.eval(Math.PI*1E307-Math.PI), gamma);
      assertEquals(0, tan.eval(Math.PI*1E307-(2*Math.PI)), gamma);
   }
   
   @Test
   void testSonderfall()
   {
      assertEquals(Double.NaN, tan.eval(Double.NaN));
   }
}
