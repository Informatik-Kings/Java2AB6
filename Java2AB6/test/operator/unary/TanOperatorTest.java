package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Tangens-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class TanOperatorTest
{

   TanOperator tan = new TanOperator();
   double delta = 0.0001; // Toleranz

   @Test
   void testFunktionUnten()
   {
      assertEquals(0, tan.eval(-Math.PI*10E6), delta);
      assertEquals(0, tan.eval(-Math.PI*10E6+Math.PI), delta);
      assertEquals(0, tan.eval(-Math.PI*10E6+(2*Math.PI)), delta);
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
      assertEquals(0, tan.eval((Math.PI*10E6)), delta);
      assertEquals(0, tan.eval(Math.PI*10E6+Math.PI), delta);
      assertEquals(0, tan.eval(Math.PI*10E6+(2*Math.PI)), delta);
   }
   
   @Test
   void testUngueltigerWert()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Math.toRadians(-270));
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Math.toRadians(-90));
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Math.toRadians(90));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Math.toRadians(270));
         }
      });
   }
}
