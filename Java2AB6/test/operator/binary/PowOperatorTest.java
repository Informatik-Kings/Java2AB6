package operator.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Exponential-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class PowOperatorTest
{

   private static PowOperator pow = new PowOperator();
   
   @DisplayName("Teste Grenze Unten")
   @Test
   void testGrenzeUnten()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {
               
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-Double.MAX_VALUE, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-Double.MAX_VALUE+1, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-Double.MAX_VALUE+2, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(1, -Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(1, -Double.MAX_VALUE+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(1, -Double.MAX_VALUE+2);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-Double.MAX_VALUE, -Double.MAX_VALUE);
         }
      });
   }
   
   @DisplayName("Teste Grenze Unten Übergang Basis")
   @Test
   void testGrenzeUntenUebergangBasis()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(1, -Math.pow(2, 53)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(1, -Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1, -Math.pow(2, 53)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1, -Math.pow(2, 53));
         }
      });
   }
   
   @DisplayName("Teste Grenze Unten Übergang Exponent")
   @Test
   void testGrenzeUntenUebergangExp()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1E4-2, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1E4-1, 1);
         }
      });
   }
   
   @DisplayName("Teste Funktion Unten Basis")
   @Test
   void testFunktionUntenBasis()
   {
      assertEquals(-(Math.pow(2, 53))+1, pow.eval(1, -(Math.pow(2, 53))+1));
      assertEquals(-(Math.pow(2, 53))+2, pow.eval(1, -(Math.pow(2, 53))+2));
      assertEquals(1, pow.eval(0, -(Math.pow(2, 53))+1));
      assertEquals(1, pow.eval(0, -(Math.pow(2, 53))+2));
   } 
   
   @DisplayName("Teste Funktion Unten Exponenten")
   @Test
   void testFunktionUntenExp()
   {
      assertEquals(1, pow.eval(-1E4, 1));
      assertEquals(1, pow.eval(-1E4+1, 1));
      assertEquals(1, pow.eval(-1E4+2, 1));
   } 
   
   @DisplayName("Teste Funktion Mitte")
   @Test
   void testFunktionMitte()
   {
      assertEquals(1, pow.eval(-2, 1));
      assertEquals(1, pow.eval(-1, 1));
      assertEquals(1, pow.eval(0, 1));
      
      assertEquals(1, pow.eval(1, 1));
      
      assertEquals(-2, pow.eval(1, -2));
      assertEquals(-1, pow.eval(1, -1));
      assertEquals(0, pow.eval(1, 0));
      
   }
   
   @DisplayName("Teste Funktion Grenze Mitte (Basis 0 && Exponent negativ)")
   @Test
   void testGrenzeMitte()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1E4, 0);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1E4+1, 0);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1, 0);
         }
      });
   }
   
   @DisplayName("Teste Funktion Oben Exponenten")
   @Test
   void testFunktionObenExp()
   {
      assertEquals(1, pow.eval(1E6, 1));
      assertEquals(1, pow.eval(1E6-1, 1));
      assertEquals(1, pow.eval(1E6-2, 1));
      
      assertEquals(0, pow.eval(1E6, 0));
      assertEquals(0, pow.eval(1E6-1, 0));
      assertEquals(0, pow.eval(1E6-2, 0));
   }
   
   @DisplayName("Teste Funktion Oben Basis")
   @Test
   void testFunktionObenBasis()
   {
      assertEquals(Math.pow(2, 53)-1, pow.eval(1, Math.pow(2, 53)-1));
      assertEquals(Math.pow(2, 53)-2, pow.eval(1, Math.pow(2, 53)-2));
      assertEquals(1, pow.eval(0, Math.pow(2, 53)-1));
      assertEquals(1, pow.eval(0, Math.pow(2, 53)-2)); 
   }
   
   @DisplayName("Teste Grenze Oben Übergang Exponent")
   @Test
   void testGrenzeObenUebergangExp()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(1E6+2, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(1E6+1, 1);
         }
      });
   }
   
   @DisplayName("Teste Grenze Unten Übergang Basis")
   @Test
   void testGrenzeObenUebergangBasis()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(1, Math.pow(2, 53)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(1, Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1, Math.pow(2, 53)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1, Math.pow(2, 53));
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
            pow.eval(Double.MAX_VALUE, -1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(Double.MAX_VALUE-1, -1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(Double.MAX_VALUE-2, -1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1, Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1, Double.MAX_VALUE-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(-1, Double.MAX_VALUE-2);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            pow.eval(Double.MAX_VALUE, Double.MAX_VALUE);
         }
      });
   }

}
