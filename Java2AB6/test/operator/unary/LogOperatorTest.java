package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den natürlichen Logarithmus-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class LogOperatorTest
{
   LogOperator log = new LogOperator();

   @Test
   void testGrenzeUnten()
   {
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(-Double.MAX_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(-Double.MAX_VALUE + 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(-Double.MAX_VALUE + 2);
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
            log.eval(-3);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(-2);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(0);
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
            log.eval(-Double.MIN_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(-Double.MIN_VALUE*2);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(-Double.MIN_VALUE*3);
         }
      });
   }
   
   @Test
   void testGrenzeNullPositiv()
   {
      assertEquals(-744.4400719213812, log.eval(Double.MIN_VALUE));
      assertEquals(-743.7469247408213, log.eval(Double.MIN_VALUE*2));
      assertEquals(-743.3414596327132, log.eval(Double.MIN_VALUE*3));
   }

   @Test
   void testFunktionUnten()
   {
      assertEquals(-708.8, log.eval(Math.exp(-708.8)));
      assertEquals(-708.9, log.eval(Math.exp(-708.9)));
      assertEquals(-709, log.eval(Math.exp(-709)));
   }

   @Test
   void testFunktionMitte()
   {
      assertEquals(0, log.eval(1));
      assertEquals(1, log.eval(Math.exp(1)));
      assertEquals(2, log.eval(Math.exp(2)));
   }

   @Test
   void testFunktionOben()
   {
      assertEquals(36.5, log.eval(Math.exp(36.5)));
      assertEquals(36.6, log.eval(Math.exp(36.6)));
      assertEquals(36.7, log.eval(Math.exp(36.7)));
   }
   
   @Test
   void testUbergangOben()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(Math.exp(37));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(Math.exp(38));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(Math.exp(39));
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
            log.eval(Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(Double.MAX_VALUE - 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(Double.MAX_VALUE - 2);
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
            log.eval(Double.POSITIVE_INFINITY);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(Double.NEGATIVE_INFINITY);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(Double.NaN);
         }
      });
   }

}
