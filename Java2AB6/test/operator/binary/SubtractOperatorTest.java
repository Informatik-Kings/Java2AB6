package operator.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Subtraktions-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class SubtractOperatorTest
{

   private static SubtractOperator sub = new SubtractOperator();

   @DisplayName("Teste Grenze Unten")
   @Test
   void testGrenzeUnten()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-1, -Double.MAX_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-1, -Double.MAX_VALUE+1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-1, -Double.MAX_VALUE+2);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-Double.MAX_VALUE, -1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-Double.MAX_VALUE+1, -1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-Double.MAX_VALUE+2, -1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-Double.MAX_VALUE, -Double.MAX_VALUE);
         }
      });
   }

   @DisplayName("Teste Grenze Unten Übergang")
   @Test
   void testGrenzeUntenUebergang()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(1, -Math.pow(2, 53)-1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(1, -Math.pow(2, 53));
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(1, -Math.pow(2, 53)+1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-Math.pow(2, 53)-1, 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-Math.pow(2, 53), 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-Math.pow(2, 53)+1, 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-1, -Math.pow(2, 53)-1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(Math.pow(2, 53)/2, -(Math.pow(2, 53)/2)-1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-Math.pow(2, 53)-1, -1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-(Math.pow(2, 53)/2)-1, (Math.pow(2, 53)/2));
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-Math.pow(2, 53), -Math.pow(2, 53));
         }
      });
   } 

   @DisplayName("Teste Funktion Unten")
   @Test
   void testFunktionUnten()
   {
      assertEquals(-(Math.pow(2, 53))+1, sub.eval(1, -(Math.pow(2, 53))+2));
      assertEquals(-(Math.pow(2, 53))+2, sub.eval(1, -(Math.pow(2, 53))+3));
      assertEquals(Math.pow(2, 53)-1, sub.eval(-(Math.pow(2, 53))+2, 1));
      assertEquals(Math.pow(2, 53)-2, sub.eval(-(Math.pow(2, 53))+3, 1));
   } 

   @DisplayName("Teste Funktion Mitte")
   @Test
   void testFunktionMitte()
   {
      assertEquals(-1, sub.eval(-1, -2));
      assertEquals(1, sub.eval(-1, 0));

      assertEquals(0, sub.eval(1, 1));
      assertEquals(0, sub.eval(-1, -1));

      assertEquals(1, sub.eval(-2, -1));
      assertEquals(-1, sub.eval(0, -1));

   }

   @DisplayName("Teste Funktion Oben")
   @Test
   void testFunktionOben()
   {
      assertEquals(-(Math.pow(2, 53))+3, sub.eval(Math.pow(2, 53)-2, 1));
      assertEquals(-(Math.pow(2, 53))+4, sub.eval(Math.pow(2, 53)-3, 1));
      assertEquals(Math.pow(2, 53)-3, sub.eval(1, Math.pow(2, 53)-2));
      assertEquals(Math.pow(2, 53)-4, sub.eval(1, Math.pow(2, 53)-3));   
   }

   @DisplayName("Teste Grenze Oben Übergang")
   @Test
   void testGrenzeObenUebergang()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-1, Math.pow(2, 53)+1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-1, Math.pow(2, 53));
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-1, Math.pow(2, 53)-1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(Math.pow(2, 53)+1, -1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(Math.pow(2, 53), -1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(Math.pow(2, 53)-1, -1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(1, Math.pow(2, 53)+1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-(Math.pow(2, 53)/2), (Math.pow(2, 53)/2)+1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(Math.pow(2, 53)+1, 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(-((Math.pow(2, 53)/2)+1), Math.pow(2, 53)/2);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(Math.pow(2, 53), Math.pow(2, 53));
         }
      });
   }

   @DisplayName("Teste Grenze Oben")
   @Test
   void testGrenzeOben()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(1, Double.MAX_VALUE);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(1, Double.MAX_VALUE-1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(1, Double.MAX_VALUE-2);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(Double.MAX_VALUE, 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(Double.MAX_VALUE-1, 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(Double.MAX_VALUE-2, 1);
         }
      });

      assertThrows(IllegalArgumentException.class, new Executable() {

         @Override
         public void execute() throws Throwable
         {
            sub.eval(Double.MAX_VALUE, Double.MAX_VALUE);
         }
      });
   } 
}
