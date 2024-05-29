package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Sinus-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class SinOperatorTest
{
   SinOperator sin = new SinOperator();
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
            sin.eval(-Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(-Double.MAX_VALUE+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(-Double.MAX_VALUE+2);
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
            sin.eval(Math.pow(-2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(Math.pow(-2, 53)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(Math.pow(-2, 53)-2);
         }
      });
   }
 
   @Test
   void testGrenzeNullNegativ()
   {
      assertEquals(-Double.MIN_VALUE, sin.eval(-Double.MIN_VALUE));
      assertEquals(-Double.MIN_VALUE*2, sin.eval(-Double.MIN_VALUE*2));
      assertEquals(-Double.MIN_VALUE*3, sin.eval(-Double.MIN_VALUE*3));
   }
   
   @Test
   void testGrenzeNullPositiv()
   {
      assertEquals(Double.MIN_VALUE, sin.eval(Double.MIN_VALUE));
      assertEquals(Double.MIN_VALUE*2, sin.eval(Double.MIN_VALUE*2));
      assertEquals(Double.MIN_VALUE*3, sin.eval(Double.MIN_VALUE*3));
   }

   @Test
   void testFunktionUnten()
   {
      assertEquals(0, sin.eval(-Math.PI*1E15), gamma);
      assertEquals(0, sin.eval(-Math.PI*1E15+Math.PI), gamma);
      assertEquals(0, sin.eval(-(Math.PI*1E15+(2*Math.PI))), gamma);
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
      assertEquals(0, sin.eval(Math.PI*1E15), gamma);
      assertEquals(0, sin.eval(Math.PI*1E15-Math.PI), gamma);
      assertEquals(0, sin.eval(Math.PI*1E15+(2*Math.PI)), gamma);
   }
   
   @Test
   void testUebergangOben()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(Math.pow(2, 53)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(Math.pow(2, 53)+2);
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
            sin.eval(Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(Double.MAX_VALUE-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(Double.MAX_VALUE-2);
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
            sin.eval(Double.POSITIVE_INFINITY);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(Double.NEGATIVE_INFINITY);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sin.eval(Double.NaN);
         }
      });
   }

}
