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
   double gamma = 0.13; // Toleranz
   double delta = 0.0001; // Toleranz
   
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
      assertEquals(0, tan.eval(-Math.PI*1E15), gamma);
      assertEquals(0, tan.eval(-Math.PI*1E15+Math.PI), gamma);
      assertEquals(0, tan.eval(-(Math.PI*1E15+(2*Math.PI))), gamma);
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
      assertEquals(0, tan.eval((Math.PI*1E15)), gamma);
      assertEquals(0, tan.eval(Math.PI*1E15-Math.PI), gamma);
      assertEquals(0, tan.eval((Math.PI*1E15)+(2*Math.PI)), gamma);
   }
   
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
