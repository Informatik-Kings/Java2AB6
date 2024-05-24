package stack;

/**
 * Stack-Implementierung mit auf Stack-Methoden begrenztes API.
 * 
 * java.util.Stack erbt von java.util.Vector und damit das gesamte öffentliche
 * API von Vector. Ein für den Zugriff auf Stack-Elemente sind jedoch per
 * Definition nur die Methoden push, pop und peek zulässig.
 * 
 * Diese Implementierung implementiert einen Stack mit begrenztem API. Die
 * Methoden sind durch Delegation an eine {@link java.util.Stack} - Instanz
 * implementiert.
 *
 * @author $Author: M. Faulstich
 */
public class Stack<E>
{
   private java.util.Stack<E> stack = new java.util.Stack<E>();

   /**
    * @see java.util.Stack#push(Object)
    */
   public E push(E item)
   {
      return stack.push(item);
   }

   /**
    * @see {@link java.util.Stack#pop()}.
    */
   public E pop()
   {
      return stack.pop();
   }

   /**
    * @see {@link java.util.Stack#peek()}.
    */
   public E peek()
   {
      return stack.peek();
   }

   /**
    * @see {@link java.util.Stack#empty()}.
    */
   public boolean empty()
   {
      return stack.empty();
   }

   /**
    * @see {@link java.util.Stack#size()}.
    */
   public int size()
   {
      return stack.size();
   }

   /**
    * @see {@link java.util.Stack#isEmpty()}.
    */
   public boolean isEmpty()
   {
      return stack.isEmpty();
   }

   /**
    * @see {@link java.util.Stack#clear()}.
    */
   public void clear()
   {
      stack.clear();
   }

   /**
    * @see {@link java.util.Stack#equals(Object)}.
    */
   public boolean equals(Object o)
   {
      return stack.equals(o);
   }

   /**
    * @see {@link java.util.Stack#hashCode()}.
    */
   public int hashCode()
   {
      return stack.hashCode();
   }

   /**
    * @see {@link java.util.Stack#toString()}.
    */
   public String toString()
   {
      return stack.toString();
   }

}