package operator.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Multiplikations-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class MultiplyOperatorTest
{
   private static MultiplyOperator mul = new MultiplyOperator();
   private static final double DELTA = 1e-10;
   
   @DisplayName("Teste Grenze Unten")
   @Test
   void testGrenzeUnten()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {
               
         @Override
         public void execute() throws Throwable
         {
            mul.eval(-Double.MAX_VALUE, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(-Double.MAX_VALUE+1, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(-Double.MAX_VALUE+2, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(1, -Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(1, -Double.MAX_VALUE+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(1, -Double.MAX_VALUE+2);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(-Double.MAX_VALUE, -Double.MAX_VALUE);
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
            mul.eval(-Math.pow(2, 53)-1, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(-Math.pow(2, 53), 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(1, -Math.pow(2, 53)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(1, -Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(-Math.pow(2, 53)-1, -1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(-(Math.pow(2, 53)/2), 2);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(-1, -Math.pow(2, 53)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(2, -(Math.pow(2, 53)/2)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(-Math.pow(2, 53), -Math.pow(2, 53));
         }
      });
   } 
   
   @DisplayName("Teste Funktion Unten")
   @Test
   void testFunktionUnten()
   {
      assertEquals(-(Math.pow(2, 53))+1, mul.eval(-(Math.pow(2, 53))+1, 1));
      assertEquals(-(Math.pow(2, 53))+2, mul.eval(-(Math.pow(2, 53))+2, 1));
      
      assertEquals(-(Math.pow(2, 53))+1, mul.eval(1, -(Math.pow(2, 53))+1));
      assertEquals(-(Math.pow(2, 53))+2, mul.eval(1, -(Math.pow(2, 53))+2));
      
      assertEquals(0, mul.eval(0, -(Math.pow(2, 53))+1), DELTA);
      assertEquals(0, mul.eval(0, -(Math.pow(2, 53))+2), DELTA);
      
      assertEquals(0, mul.eval(-(Math.pow(2, 53))+1, 0), DELTA);
      assertEquals(0, mul.eval(-(Math.pow(2, 53))+2, 0), DELTA);
   } 
   
   @DisplayName("Teste Funktion Mitte")
   @Test
   void testFunktionMitte()
   {
      assertEquals(-2, mul.eval(-2, 1));
      assertEquals(-1, mul.eval(-1, 1));
      assertEquals(0, mul.eval(0, 1));
      
      assertEquals(1, mul.eval(1, 1));
      
      assertEquals(-2, mul.eval(1, -2));
      assertEquals(-1, mul.eval(1, -1));
      assertEquals(0, mul.eval(1, 0));
      
   }
   
   @DisplayName("Teste Funktion Oben")
   @Test
   void testFunktionOben()
   {
      assertEquals(Math.pow(2, 53)-1, mul.eval(Math.pow(2, 53)-1, 1));
      assertEquals(Math.pow(2, 53)-2, mul.eval(Math.pow(2, 53)-2, 1));
      
      assertEquals(Math.pow(2, 53)-1, mul.eval(1, Math.pow(2, 53)-1));
      assertEquals(Math.pow(2, 53)-2, mul.eval(1, Math.pow(2, 53)-2));   
      
      assertEquals(0, mul.eval(0, Math.pow(2, 53)-1), DELTA);
      assertEquals(0, mul.eval(0, Math.pow(2, 53)-2), DELTA);   
      
      assertEquals(0, mul.eval(Math.pow(2, 53)-1, 0), DELTA);
      assertEquals(0, mul.eval(Math.pow(2, 53)-2, 0), DELTA);
   }
   
   @DisplayName("Teste Grenze Oben Übergang")
   @Test
   void testGrenzeObenUebergang()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(Math.pow(2, 53)+1, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(Math.pow(2, 53), 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(1, Math.pow(2, 53)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(1, Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(Math.pow(2, 53)+1, -1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval((Math.pow(2, 53)/2)+1, 2);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(-1, Math.pow(2, 53)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(2, (Math.pow(2, 53)/2)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(Math.pow(2, 53), Math.pow(2, 53));
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
            mul.eval(Double.MAX_VALUE, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(Double.MAX_VALUE-1, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(Double.MAX_VALUE-2, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(1, Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(1, Double.MAX_VALUE-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(1, Double.MAX_VALUE-2);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            mul.eval(Double.MAX_VALUE, Double.MAX_VALUE);
         }
      });
   }
}
