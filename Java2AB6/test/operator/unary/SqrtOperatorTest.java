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
            sqrt.eval(Integer.MIN_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(Integer.MIN_VALUE + 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            sqrt.eval(Integer.MIN_VALUE + 2);
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
      assertEquals(23170, sqrt.eval(23170*23170));
      assertEquals(23171, sqrt.eval(23171*23171));
      assertEquals(23172, sqrt.eval(23172*23172));
   }
   
   @Test
   void testFunktionOben()
   {
      assertEquals(46338, sqrt.eval(46338*46338));
      assertEquals(46339, sqrt.eval(46339*46339));
      assertEquals(46340, sqrt.eval(46340*46340));
   }

}
