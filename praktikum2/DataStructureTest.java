package praktikum2;

public class DataStructureTest {
    public static void main(String[] args) {
        System.out.println("Stack Test:");
        Stack stack = new Stack();
        
        // Elemente zum Stack hinzufügen und entfernen
        stack.push(1);
        stack.push(2);
        stack.push("drei");
        System.out.println("Top Element im Stack: " + stack.top());
        
        System.out.println("Pop Element: " + stack.pop());
        System.out.println("Pop Element: " + stack.pop());
        System.out.println("Ist der Stack leer? " + stack.isEmpty());

        System.out.println("\nQueue Test:");
        Queue queue = new Queue();
        
        // Elemente zur Queue hinzufügen und entfernen
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue("drei");
        System.out.println("Front Element in der Queue: " + queue.front());
        
        System.out.println("Dequeue Element: " + queue.dequeue());
        System.out.println("Dequeue Element: " + queue.dequeue());
        System.out.println("Ist die Queue leer? " + queue.isEmpty());
    }
}

