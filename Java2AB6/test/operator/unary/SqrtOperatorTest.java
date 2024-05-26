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
   void testFunktionMitteOben()
   {
      assertEquals(0, sqrt.eval(0));
      assertEquals(1, sqrt.eval(1));
      assertEquals(2, sqrt.eval(4));
      assertEquals(3, sqrt.eval(9));
   }
   
   @Test
   void testFunktionMitte()
   {
      assertEquals(1E149, sqrt.eval(1E149*1E149));
      assertEquals(1E150, sqrt.eval(1E150*1E150));
      assertEquals(1E151, sqrt.eval(1E151*1E151));
   }
   
   @Test
   void testFunktionOben()
   {
      assertEquals(1E152, sqrt.eval(1E152*1E152));
      assertEquals(1E153, sqrt.eval(1E153*1E153));
      assertEquals(1E154, sqrt.eval(1E154*1E154));
   }

}
