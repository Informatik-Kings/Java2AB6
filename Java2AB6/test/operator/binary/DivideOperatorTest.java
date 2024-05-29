package operator.binary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Testet den Divisions-Operator.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
class DivideOperatorTest
{
   private static DivideOperator div = new DivideOperator();
   private static final double DELTA = 1e-10;
   
   @DisplayName("Teste Grenze Unten")
   @Test
   void testGrenzeUnten()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {
               
         @Override
         public void execute() throws Throwable
         {
            div.eval(-Double.MAX_VALUE, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(-Double.MAX_VALUE+1, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(-Double.MAX_VALUE+2, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(1, -Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(1, -Double.MAX_VALUE+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(1, -Double.MAX_VALUE+2);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(-Double.MAX_VALUE, -Double.MAX_VALUE);
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
            div.eval(-Math.pow(2, 53)-1, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(-Math.pow(2, 53), 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(1, -Math.pow(2, 53)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(1, -Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(-Math.pow(2, 53)-1, -1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(-1, -Math.pow(2, 53)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(0.5, -(Math.pow(2, 53)/2)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(-Math.pow(2, 53), -Math.pow(2, 53));
         }
      });
   } 
   
   @DisplayName("Teste Funktion Unten")
   @Test
   void testFunktionUnten()
   {
      assertEquals(1/(-(Math.pow(2, 53))+1), div.eval(-(Math.pow(2, 53))+1, 1), DELTA);
      assertEquals(1/(-(Math.pow(2, 53))+2), div.eval(-(Math.pow(2, 53))+2, 1), DELTA);
      
      assertEquals(-(Math.pow(2, 53))+1, div.eval(1, -(Math.pow(2, 53))+1));
      assertEquals(-(Math.pow(2, 53))+2, div.eval(1, -(Math.pow(2, 53))+2));
      
      assertEquals(0, div.eval(-(Math.pow(2, 53))+1, 0), DELTA);
      assertEquals(0, div.eval(-(Math.pow(2, 53))+2, 0), DELTA);
      
      assertEquals(-4.5E15, div.eval(2, -9E15));
      assertEquals(2/(-9E15), div.eval(-9E15, 2));
   } 
   
   @DisplayName("Teste Funktion Mitte")
   @Test
   void testFunktionMitte()
   {
      assertEquals(-0.5, div.eval(-2, 1));
      assertEquals(-1, div.eval(-1, 1));
      
      assertEquals(1, div.eval(1, 1));
      
      assertEquals(-2, div.eval(1, -2));
      assertEquals(-1, div.eval(1, -1));
      assertEquals(0, div.eval(1, 0));
   }
   
   @DisplayName("Teste ungültige Grenze in der Mitte (Nenner 0)")
   @Test
   void testGrenzeMitte() {
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, -Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, (-Double.MAX_VALUE)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, -Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, (-Math.pow(2, 53))+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, -1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, 0);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, Math.pow(2, 53)-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, Double.MAX_VALUE-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable()
      {

         @Override
         public void execute() throws Throwable
         {
            div.eval(0, Double.MAX_VALUE);
         }
      });
   }
   
   @DisplayName("Teste Funktion Oben")
   @Test
   void testFunktionOben()
   {
      assertEquals(1/(Math.pow(2, 53)-1), div.eval(Math.pow(2, 53)-1, 1));
      assertEquals(1/(Math.pow(2, 53)-2), div.eval(Math.pow(2, 53)-2, 1));
      
      assertEquals(Math.pow(2, 53)-1, div.eval(1, Math.pow(2, 53)-1));
      assertEquals(Math.pow(2, 53)-2, div.eval(1, Math.pow(2, 53)-2));   
      
      assertEquals(0, div.eval(Math.pow(2, 53)-1, 0), DELTA);
      assertEquals(0, div.eval(Math.pow(2, 53)-2, 0), DELTA);
      
      assertEquals(4.5E15, div.eval(2, 9E15));
      assertEquals(2/9E15, div.eval(9E15, 2));
   }
   
   @DisplayName("Teste Grenze Oben Übergang")
   @Test
   void testGrenzeObenUebergang()
   {
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(Math.pow(2, 53)+1, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(Math.pow(2, 53), 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(1, Math.pow(2, 53)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(1, Math.pow(2, 53));
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(Math.pow(2, 53)+1, -1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(-1, Math.pow(2, 53)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(0.5, (Math.pow(2, 53)/2)+1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(Math.pow(2, 53), Math.pow(2, 53));
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
            div.eval(Double.MAX_VALUE, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(Double.MAX_VALUE-1, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(Double.MAX_VALUE-2, 1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(1, Double.MAX_VALUE);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(1, Double.MAX_VALUE-1);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(1, Double.MAX_VALUE-2);
         }
      });
      
      assertThrows(IllegalArgumentException.class, new Executable() {
         
         @Override
         public void execute() throws Throwable
         {
            div.eval(Double.MAX_VALUE, Double.MAX_VALUE);
         }
      });
   }
}
