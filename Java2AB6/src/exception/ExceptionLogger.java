package exception;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import application.Main;

/**
 * Klasse zum Protokollieren von {@link Exception}.
 *
 * @author $Author: $
 * @version $Revision: $, $Date: $ UTC
 */
public class ExceptionLogger
{
   /**
    * Schreibt den Stacktrace von Exception in ein Logfile.</br>
    *
    * Das Logfile wird im Home-Verzeichnis des angemeldeten Anwenders
    * erstellt.</br>
    * Wird ein gültiges Class-Objekt übergeben, wird als Dateiname der
    * Klassenname mit .log Extension verwendet.</br>
    * Wird kein gültiges Class-Objekt übergeben, wird als Dateiname Logger.log
    * verwendet.
    *
    * @param appClass
    *           Klasse für den Namen des Logfile.
    * @param exception
    *           Exception, deren Stacktrace protokolliert werden soll.
    *
    * @see https://logging.apache.org/log4j
    */
   public static void errorLog(Class<Main> appClass, Throwable exception)
   {
      
      Class<?> logClass = appClass != null ? appClass : ExceptionLogger.class;
      String logFile = System.getProperty("user.home") + File.separatorChar + logClass.getSimpleName() + ".log";
      
      try
      {
         if (exception != null)
         {
            // PrintStream in Logfile mit Anhängen an vorhandenem Text
            exception.printStackTrace(new PrintStream(new FileOutputStream(logFile, true)));

            // Rekursiver Aufruf zur Protokollierung möglicher verknüpfter Exceptions.
            errorLog(appClass, exception.getCause());
         }
      }
      catch (Exception e1)
      {
         System.err
               .println(String.format("Logfile %s not writeable", appClass));
      }
   }
}
