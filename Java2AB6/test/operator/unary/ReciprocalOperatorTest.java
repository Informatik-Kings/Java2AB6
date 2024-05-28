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
   void testGrenzeUnten()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(-Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(-Double.MAX_VALUE+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(-Double.MAX_VALUE+2);
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
            rec.eval(Math.pow(-2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Math.pow(-2, 53)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Math.pow(-2, 53)-2);
         }
      });
   }
   
   @Test
   void testFunktionUnten()
   {
      assertEquals(1/(Math.pow(-2, 53)+1), rec.eval(Math.pow(-2, 53)+1));
      assertEquals(1/(Math.pow(-2, 53)+2), rec.eval(Math.pow(-2, 53)+2));
      assertEquals(1/(Math.pow(-2, 53)+3), rec.eval(Math.pow(-2, 53)+3));
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
   
   @Test
   void testFunktionOben()
   {
      assertEquals(1/(Math.pow(2, 53)-1), rec.eval(Math.pow(2, 53)-1));
      assertEquals(1/(Math.pow(2, 53)-2), rec.eval(Math.pow(2, 53)-2));
      assertEquals(1/(Math.pow(2, 53)-3), rec.eval(Math.pow(2, 53)-3));
   }
   
   @Test
   void testUebergangOben()
   {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Math.pow(2, 53)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Math.pow(2, 53)+2);
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
            rec.eval(Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Double.MAX_VALUE-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Double.MAX_VALUE-2);
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
            rec.eval(Double.POSITIVE_INFINITY);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Double.NEGATIVE_INFINITY);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            rec.eval(Double.NaN);
         }
      });
   }

}
