package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Testet den Sinus-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class SinOperatorTest
{
   SinOperator sin = new SinOperator();
   double delta = 0.0001; // Toleranz

   @Test
   void testFunktionUnten()
   {
      assertEquals(0, sin.eval(-Math.PI*10E6), delta);
      assertEquals(0, sin.eval(-Math.PI*10E6+Math.PI), delta);
      assertEquals(0, sin.eval(-Math.PI*10E6+(2*Math.PI)), delta);
   }

   @Test
   void testFunktionMitte()
   {
      assertEquals(0, sin.eval(Math.toRadians(-180)), delta);
      assertEquals(-0.5, sin.eval(Math.toRadians(-150)), delta);
      assertEquals(-1, sin.eval(Math.toRadians(-90)), delta);
      assertEquals(-0.5, sin.eval(Math.toRadians(-30)), delta);
      assertEquals(0, sin.eval(Math.toRadians(0)), delta);
      assertEquals(0.5, sin.eval(Math.toRadians(30)), delta);
      assertEquals(1, sin.eval(Math.toRadians(90)), delta);
      assertEquals(0.5, sin.eval(Math.toRadians(150)), delta);
      assertEquals(0, sin.eval(Math.toRadians(180)), delta);
   }

   @Test
   void testFunktionOben()
   {
      assertEquals(0, sin.eval(Math.PI*10E6), delta);
      assertEquals(0, sin.eval(Math.PI*10E6+Math.PI), delta);
      assertEquals(0, sin.eval(Math.PI*10E6+(2*Math.PI)), delta);
   }

}
