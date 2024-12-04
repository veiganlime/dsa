 package praktikum2;

// public class DataStructureTest {
//     public static void main(String[] args) {
//         System.out.println("Stack Test:");
//         Stack stack = new Stack();
        
//         // Elemente zum Stack hinzufügen und entfernen
//         stack.push(1);
//         stack.push(2);
//         stack.push("drei");
//         System.out.println("Top Element im Stack: " + stack.top());
        
//         System.out.println("Pop Element: " + stack.pop());
//         System.out.println("Pop Element: " + stack.pop());
//         System.out.println("Ist der Stack leer? " + stack.isEmpty());

//         System.out.println("\nQueue Test:");
//         Queue queue = new Queue();
        
//         // Elemente zur Queue hinzufügen und entfernen
//         queue.enqueue(1);
//         queue.enqueue(2);
//         queue.enqueue("drei");
//         System.out.println("Front Element in der Queue: " + queue.front());
        
//         System.out.println("Dequeue Element: " + queue.dequeue());
//         System.out.println("Dequeue Element: " + queue.dequeue());
//         System.out.println("Ist die Queue leer? " + queue.isEmpty());
//     }
// }





public class DataStructureTest {
    public static void main(String[] args) {
        System.out.println("Stack Test:");
        Stack stack = new Stack();
        // Test with example input array
        Object[] inputs = {1, 2, 3, 4, 5, 6, 7, 8};

        // Adding and removing in a loop
        for (int i = 0; i < inputs.length; i += 2) {
            // Add 2 elements
            stack.push(inputs[i]);
            if (i + 1 < inputs.length) {
                stack.push(inputs[i + 1]);
            }

            // Display current state
            System.out.println("Current Stack: " + stack);

            // Remove one element
            if (!stack.isEmpty()) {
                System.out.println("Popped Element: " + stack.pop());
            }

            // Display top element
            System.out.println("Top Element: " + stack.top());
        }

        // Final state
        System.out.println("\nRemaining elements in Stack:");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        System.out.println("\nQueue Test:");
        Queue queue = new Queue();

        // Adding and removing in a loop
        for (int i = 0; i < inputs.length; i += 2) {
            // Add 2 elements
            queue.enqueue(inputs[i]);
            if (i + 1 < inputs.length) {
                queue.enqueue(inputs[i + 1]);
            }

            // Display current state
            System.out.println("Current Queue: " + queue);

            // Remove one element
            if (!queue.isEmpty()) {
                System.out.println("Dequeued Element: " + queue.dequeue());
            }

            // Display front element
            System.out.println("Front Element: " + queue.front());
        }

        // Final state
        System.out.println("\nRemaining elements in Queue:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
}