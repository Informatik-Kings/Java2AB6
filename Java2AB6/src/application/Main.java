package application;

import exception.ExceptionLogger;
import exception.IllegalUserInputException;
import upn.UPNRechner;

/**
 * Klasse zum Testen des UPN Rechners mithilfe der Main-Methode und formatierten Ausgaben.
 *
 * @author Dominik Schwabe, Cheng-Fu Ye, Markus Suchalla.
 */
public class Main
{

   private final static String TABLE_FORMAT = "%-50s%-25s";

   /**
    * Main Methode zum Testen der Funktionalität des UPN Rechners.
    *
    * @param args wird nicht genutzt.
    */
   public static void main(String[] args)
   {
      String[] tests = {
            //Ungültige Nullreferenz übergeben
            null,               //Fehlerfall 1
            //Leeren String übergeben
            "   ",              //Fehlerfall 1
            //Zu viele Operanden
            "1 2 + 3",          //Fehlerfall 1
            //Unbekannter Operator
            "5 !",              //Fehlerfall 1
            //Plus
            "2 3 +",            //Erfolgsfall 1
            "1 +",              //Fehlerfall 1
            //Minus
            "3 2 -",            //Erfolgsfall 1
            "2.5 3.5 -",        //Erfolgsfall 2
            //Mal
            "2 10 *",           //Erfolgsfall 1
            "2.5 -100 *",       //Erfolgsfall 2
            //Geteilt
            "5 2 /",            //Erfolgsfall 1
            "1 0.5 /",          //Erfolgsfall 2
            "1 0 /",            //Fehlerfall 1
            //Exponential
            "2 5 pow",          //Erfolgsfall 1
            "2 -2 pow",         //Erfolgsfall 2
            //Logarithmus
            Math.exp(1)+" ln", //Erfolgsfall 1
            "1E12 ln",         //Erfolgsfall 2
            "ln",              //Fehlerfall 1
            "0 ln",            //Fehlerfall 2
            "-1E10 ln",        //Fehlerfall 3
            //Wurzel
            "25 sqrt",          //Erfolgsfall 1
            "0 sqrt",           //Erfolgsfall 2
            "-1 sqrt",          //Fehlerfall 1   
      };

      System.out.println(String.format(TABLE_FORMAT, "UPN-Ausdruck", "Ergebnis"));

      for(String test : tests) {

         try {

            System.out.printf(String.format("%-50s", test));
            System.out.printf(String.format("%-25s", UPNRechner.rechnung(test)));

         } catch(IllegalUserInputException e) {
            System.out.printf(String.format("%-50s", e.getMessage()));
         } catch(Exception e) {
            System.err.println("Es ist ein unerwarteter Fehler aufgetreten!");
            ExceptionLogger.errorLog(Main.class, e);
//            System.err.println("Log Datei erstellt unter: " + System.getProperty("user.home") + File.separatorChar + Main.class.getSimpleName() + ".log");
//            System.err.println("Bitte Log Datei an den Entwickler des Programmes senden!");
         }

         System.out.println();


      }


   }

}
