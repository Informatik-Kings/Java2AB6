package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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
   
   @Test
   void testGrenzeNullNegativ()
   {
      assertEquals(1, cos.eval(-Double.MIN_VALUE));
      assertEquals(1, cos.eval(-Double.MIN_VALUE*2));
      assertEquals(1, cos.eval(-Double.MIN_VALUE*3));
   }
   
   @Test
   void testGrenzeNullPositiv()
   {
      assertEquals(1, cos.eval(Double.MIN_VALUE));
      assertEquals(1, cos.eval(Double.MIN_VALUE*2));
      assertEquals(1, cos.eval(Double.MIN_VALUE*3));
   }

   @Test
   void testFunktionUnten()
   {
      assertEquals(1, cos.eval(-Math.PI*1E15), gamma);
      assertEquals(-1, cos.eval(-Math.PI*1E15+Math.PI), gamma);
      assertEquals(1, cos.eval(-Math.PI*1E15+(2*Math.PI)), gamma);
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
      assertEquals(1, cos.eval((Math.PI*1E15)), gamma);
      assertEquals(-1, cos.eval(Math.PI*1E15-Math.PI), gamma);
      assertEquals(1, cos.eval(Math.PI*1E15-(2*Math.PI)), gamma);
   }
   
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
