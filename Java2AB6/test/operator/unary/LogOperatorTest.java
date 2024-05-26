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
            log.eval(Integer.MIN_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(Integer.MIN_VALUE + 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            log.eval(Integer.MIN_VALUE + 2);
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
   }

   @Test
   void testFunktionUnten()
   {
      assertEquals(0, log.eval(Math.exp(0)));
      assertEquals(1, log.eval(Math.exp(1)));
      assertEquals(2, log.eval(Math.exp(2)));
      assertEquals(3, log.eval(Math.exp(3)));
   }

   @Test
   void testFunktionMitte()
   {
      assertEquals(19, log.eval(Math.exp(19)));
      assertEquals(20, log.eval(Math.exp(20)));
      assertEquals(21, log.eval(Math.exp(21)));
   }

   @Test
   void testFunktionOben()
   {
      assertEquals(21.3, log.eval(Math.exp(21.3)));
      assertEquals(21.35, log.eval(Math.exp(21.35)));
      assertEquals(21.4, log.eval(Math.exp(21.4)));
   }

}
