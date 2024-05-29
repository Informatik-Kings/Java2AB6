package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Tangens-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class TanOperatorTest
{

   private static TanOperator tan = new TanOperator();
   private final static double GAMMA = 0.13; // Toleranz
   private final static double DELTA = 0.0001; // Toleranz

   @DisplayName("Teste Grenze Unten")
   @Test
   void testGrenzeUnten()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(-Double.MAX_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(-Double.MAX_VALUE+1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(-Double.MAX_VALUE+2);
         }
      });
   }

   @DisplayName("Teste Grenze Unten Übergang")
   @Test
   void testUebergangUnten()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Math.pow(-2, 53));
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Math.pow(-2, 53)-1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Math.pow(-2, 53)-2);
         }
      });
   }

   @DisplayName("Teste Grenze Null Negativ")
   @Test
   void testGrenzeNullNegativ()
   {
      assertEquals(-Double.MIN_VALUE, tan.eval(-Double.MIN_VALUE));
      assertEquals(-Double.MIN_VALUE*2, tan.eval(-Double.MIN_VALUE*2));
      assertEquals(-Double.MIN_VALUE*3, tan.eval(-Double.MIN_VALUE*3));
   }

   @DisplayName("Teste Grenze Null Positiv")
   @Test
   void testGrenzeNullPositiv()
   {
      assertEquals(Double.MIN_VALUE, tan.eval(Double.MIN_VALUE));
      assertEquals(Double.MIN_VALUE*2, tan.eval(Double.MIN_VALUE*2));
      assertEquals(Double.MIN_VALUE*3, tan.eval(Double.MIN_VALUE*3));
   }

   @DisplayName("Teste Funktion Unten")
   @Test
   void testFunktionUnten()
   {
      assertEquals(0, tan.eval(-Math.PI*1E15), GAMMA);
      assertEquals(0, tan.eval(-Math.PI*1E15+Math.PI), GAMMA);
      assertEquals(0, tan.eval(-(Math.PI*1E15+(2*Math.PI))), GAMMA);
   }

   @DisplayName("Teste Funktion Mitte")
   @Test
   void testFunktionMitte()
   {
      assertEquals(-1, tan.eval(Math.toRadians(-225)), DELTA);
      assertEquals(-0, tan.eval(Math.toRadians(-180)), DELTA);
      assertEquals(-1, tan.eval(Math.toRadians(-45)), DELTA);
      assertEquals(0, tan.eval(Math.toRadians(0)), DELTA);
      assertEquals(1, tan.eval(Math.toRadians(45)), DELTA);
      assertEquals(0, tan.eval(Math.toRadians(180)), DELTA);
      assertEquals(1, tan.eval(Math.toRadians(225)), DELTA);
   }

   @DisplayName("Teste Funktion Oben")
   @Test
   void testFunktionOben()
   {
      assertEquals(0, tan.eval((Math.PI*1E15)), GAMMA);
      assertEquals(0, tan.eval(Math.PI*1E15-Math.PI), GAMMA);
      assertEquals(0, tan.eval((Math.PI*1E15)+(2*Math.PI)), GAMMA);
   }

   @DisplayName("Teste Grenze Oben Übergang")
   @Test
   void testUebergangOben()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Math.pow(2, 53));
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Math.pow(2, 53)+1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Math.pow(2, 53)+2);
         }
      });
   }

   @DisplayName("Teste Grenze Oben")
   @Test
   void testGrenzeOben()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Double.MAX_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Double.MAX_VALUE-1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Double.MAX_VALUE-2);
         }
      });
   }

   @DisplayName("Teste Sonderfall")
   @Test
   void testSonderfall()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Double.POSITIVE_INFINITY);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Double.NEGATIVE_INFINITY);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            tan.eval(Double.NaN);
         }
      });
   }
}
