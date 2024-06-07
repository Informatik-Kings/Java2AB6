package operator.unary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Reziprok-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class ReciprocalOperatorTest
{

   private static InvOperator rec = new InvOperator();

   @DisplayName("Teste Grenze Unten")
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

   @DisplayName("Teste Grenze Unten Übergang")
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

   @DisplayName("Teste Funktion Unten")
   @Test
   void testFunktionUnten()
   {
      assertEquals(1/(Math.pow(-2, 53)+1), rec.eval(Math.pow(-2, 53)+1));
      assertEquals(1/(Math.pow(-2, 53)+2), rec.eval(Math.pow(-2, 53)+2));
      assertEquals(1/(Math.pow(-2, 53)+3), rec.eval(Math.pow(-2, 53)+3));
   }

   @DisplayName("Teste Funktion Mitte")
   @Test
   void testFunktionMitteUnten()
   {
      assertEquals(1/(double)-3, rec.eval(-3));
      assertEquals(-0.5, rec.eval(-2));
      assertEquals(-1, rec.eval(-1));
   }

   @DisplayName("Teste Mitte Unten Übergang")
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

   @DisplayName("Teste Grenze Null Negativ")
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

   @DisplayName("Teste Grenze Null Positiv")
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

   @DisplayName("Teste Mitte Oben Übergang")
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

   @DisplayName("Teste Funktion Mitte Oben")
   @Test
   void testFunktionMitteOben()
   {
      assertEquals(1, rec.eval(1));
      assertEquals(0.5, rec.eval(2));
      assertEquals(1/(double)3, rec.eval(3));
   }

   @DisplayName("Teste Funktion Oben")
   @Test
   void testFunktionOben()
   {
      assertEquals(1/(Math.pow(2, 53)-1), rec.eval(Math.pow(2, 53)-1));
      assertEquals(1/(Math.pow(2, 53)-2), rec.eval(Math.pow(2, 53)-2));
      assertEquals(1/(Math.pow(2, 53)-3), rec.eval(Math.pow(2, 53)-3));
   }

   @DisplayName("Teste Grenze Oben Übergang")
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

   @DisplayName("Teste Grenze Oben")
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

   @DisplayName("Teste Sonderfall")
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
