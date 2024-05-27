package operator.unary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Reziprok-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class ReciprocalOperatorTest
{

   ReciprocalOperator rec = new ReciprocalOperator();
   
   @Test
   void testFunktionUnten()
   {
      assertEquals(1/-Double.MAX_VALUE, rec.eval(-Double.MAX_VALUE));
      assertEquals(1/(-Double.MAX_VALUE+1), rec.eval(-Double.MAX_VALUE+1));
      assertEquals(1/(-Double.MAX_VALUE+2), rec.eval(-Double.MAX_VALUE+2));
   }
   
   @Test
   void testFunktionMitteUnten()
   {
      assertEquals(1/(double)-3, rec.eval(-3));
      assertEquals(-0.5, rec.eval(-2));
      assertEquals(-1, rec.eval(-1));
   }

   @Test
   void testUebergangMitteUnten()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(-1E-13);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(-2E-13);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(-3E-13);
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
            rec.eval(-Double.MIN_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(-Double.MIN_VALUE*2);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(-Double.MIN_VALUE*3);
         }
      });
   }
   
   @Test
   void testGrenzeNullPositiv()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Double.MIN_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Double.MIN_VALUE*2);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Double.MIN_VALUE*3);
         }
      });
   }

   @Test
   void testUebergangMitteOben()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(0);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(1E-13);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(2E-13);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(3E-13);
         }
      });
   }
   
   @Test
   void testFunktionMitteOben()
   {
      assertEquals(1, rec.eval(1));
      assertEquals(0.5, rec.eval(2));
      assertEquals(1/(double)3, rec.eval(3));
   }
   
   void testFunktionOben()
   {
      assertEquals(1/(Double.MAX_VALUE-2), rec.eval(Double.MAX_VALUE-2));
      assertEquals(1/(Double.MAX_VALUE-1), rec.eval(Double.MAX_VALUE-1));
      assertEquals(1/Double.MAX_VALUE, rec.eval(Double.MAX_VALUE));
   }
   
   @Test
   void testSonderfall()
   {
      assertEquals(Double.NaN, rec.eval(Double.NaN));
   }

}
