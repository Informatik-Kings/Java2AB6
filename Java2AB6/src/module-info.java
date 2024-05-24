module Java2AB6
{
   requires javafx.controls;
   
   opens application to javafx.graphics, javafx.fxml;
   
   exports exception;

   exports stack;

   exports upn;

   exports application;

   exports operator.binary;

   exports operator.unary;

   exports operator;

   requires org.junit.jupiter.api;
}