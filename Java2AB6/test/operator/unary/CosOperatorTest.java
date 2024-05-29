package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Kosinus-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class CosOperatorTest
{

   private static CosOperator cos = new CosOperator();
   private final static double GAMMA = 0.01; // Toleranz
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
            cos.eval(-Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            cos.eval(-Double.MAX_VALUE+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            cos.eval(-Double.MAX_VALUE+2);
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
            cos.eval(Math.pow(-2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            cos.eval(Math.pow(-2, 53)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            cos.eval(Math.pow(-2, 53)-2);
         }
      });
   }
   
   @DisplayName("Teste Grenze Null Negativ")
   @Test
   void testGrenzeNullNegativ()
   {
      assertEquals(1, cos.eval(-Double.MIN_VALUE));
      assertEquals(1, cos.eval(-Double.MIN_VALUE*2));
      assertEquals(1, cos.eval(-Double.MIN_VALUE*3));
   }
   
   @DisplayName("Teste Grenze Null Positiv")
   @Test
   void testGrenzeNullPositiv()
   {
      assertEquals(1, cos.eval(Double.MIN_VALUE));
      assertEquals(1, cos.eval(Double.MIN_VALUE*2));
      assertEquals(1, cos.eval(Double.MIN_VALUE*3));
   }

   @DisplayName("Teste Funktion Unten")
   @Test
   void testFunktionUnten()
   {
      assertEquals(1, cos.eval(-Math.PI*1E15), GAMMA);
      assertEquals(-1, cos.eval(-Math.PI*1E15+Math.PI), GAMMA);
      assertEquals(1, cos.eval(-(Math.PI*1E15+(2*Math.PI))), GAMMA);
   }

   @DisplayName("Teste Funktion Mitte")
   @Test
   void testFunktionMitte()
   {
      assertEquals(-1, cos.eval(Math.toRadians(-180)), DELTA);
      assertEquals(-0.5, cos.eval(Math.toRadians(-120)), DELTA);
      assertEquals(0, cos.eval(Math.toRadians(-90)), DELTA);
      assertEquals(0.5, cos.eval(Math.toRadians(-60)), DELTA);
      assertEquals(1, cos.eval(Math.toRadians(0)), DELTA);
      assertEquals(0.5, cos.eval(Math.toRadians(60)), DELTA);
      assertEquals(0, cos.eval(Math.toRadians(90)), DELTA);
      assertEquals(-0.5, cos.eval(Math.toRadians(120)), DELTA);
      assertEquals(-1, cos.eval(Math.toRadians(180)), DELTA);
   }

   @DisplayName("Teste Funktion Oben")
   @Test
   void testFunktionOben()
   {
      assertEquals(1, cos.eval((Math.PI*1E15)), GAMMA);
      assertEquals(-1, cos.eval(Math.PI*1E15-Math.PI), GAMMA);
      assertEquals(1, cos.eval(Math.PI*1E15+(2*Math.PI)), GAMMA);
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
            cos.eval(Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            cos.eval(Math.pow(2, 53)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            cos.eval(Math.pow(2, 53)+2);
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
            cos.eval(Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            cos.eval(Double.MAX_VALUE-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            cos.eval(Double.MAX_VALUE-2);
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
            cos.eval(Double.POSITIVE_INFINITY);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            cos.eval(Double.NEGATIVE_INFINITY);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            cos.eval(Double.NaN);
         }
      });
   }

}
