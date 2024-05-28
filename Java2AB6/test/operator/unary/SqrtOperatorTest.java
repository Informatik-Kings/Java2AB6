package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Wurzel-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class SqrtOperatorTest
{

   SqrtOperator sqrt = new SqrtOperator();

   @Test
   void testGrenzeUnten()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(-Double.MAX_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(-Double.MAX_VALUE + 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(-Double.MAX_VALUE + 2);
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
            sqrt.eval(-3);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(-2);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(-1);
         }
      });
   }
   
   @Test
   void testGrenzeNullNegativ()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(-Double.MIN_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(-Double.MIN_VALUE*2);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(-Double.MIN_VALUE*3);
         }
      });
   }
   
   @Test
   void testGrenzeNullPositiv()
   {
      assertEquals(1.0, sqrt.eval(Double.MIN_VALUE+1));
      assertEquals(2.0, sqrt.eval(Double.MIN_VALUE+4));
      assertEquals(3.0, sqrt.eval(Double.MIN_VALUE+9));
   }
   
   @Test
   void testFunktionUnten()
   {
      assertEquals(1E-6, sqrt.eval(1E-6*1E-6));
      assertEquals(1E-7, sqrt.eval(1E-7*1E-7));
      assertEquals(1E-8, sqrt.eval(1E-8*1E-8));
   }
   
   @Test
   void testFunktionMitte()
   {
      assertEquals(0, sqrt.eval(0));
      assertEquals(1, sqrt.eval(1));
      assertEquals(2, sqrt.eval(4));
   }
   
   @Test
   void testFunktionOben()
   {
      assertEquals(1E5, sqrt.eval(1E5*1E5));
      assertEquals(1E6, sqrt.eval(1E6*1E6));
      assertEquals(1E7, sqrt.eval(1E7*1E7));
   }
   
   @Test
   void testUebergangOben()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(Math.pow(2, 53)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(Math.pow(2, 53)+2);
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
            sqrt.eval(Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(Double.MAX_VALUE-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(Double.MAX_VALUE-2);
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
            sqrt.eval(Double.POSITIVE_INFINITY);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(Double.NEGATIVE_INFINITY);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(Double.NaN);
         }
      });
   }

}
