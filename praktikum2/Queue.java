package praktikum2;

public class Queue {
    private Knoten front;  // Vorderstes Element der Queue
    private Knoten rear;   // Letztes Element der Queue

    // Konstruktor
    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Methode zum Hinzufügen eines Elements zur Queue (enqueue)
    public void enqueue(Object value) {
        Knoten newKnoten = new Knoten(value);
        if (isEmpty()) {
            front = newKnoten;
            rear = newKnoten;
        } else {
            rear.next = newKnoten;
            rear = newKnoten;
        }
    }

    // Methode zum Entfernen des vordersten Elements aus der Queue (dequeue)
    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue ist leer, kann nicht dequeue.");
            return null;
        }
        Object value = front.data;
        front = front.next;
        if (front == null) { // Wenn die Queue leer ist, rear auf null setzen
            rear = null;
        }
        return value;
    }

    // Methode, um das vorderste Element der Queue zu betrachten, ohne es zu entfernen (front)
    public Object front() {
        if (isEmpty()) {
            System.out.println("Queue ist leer, kein Element zum Front.");
            return null;
        }
        return front.data;
    }

    // Methode, um zu überprüfen, ob die Queue leer ist
    public boolean isEmpty() {
        return front == null;
    }
}




