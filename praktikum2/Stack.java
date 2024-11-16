package praktikum2;

// Klasse für den Knoten
class Knoten {
    Object data;       // Daten des Knotens
    Knoten next;       // Verweis auf den nächsten Knoten

    // Konstruktor
    public Knoten(Object data) {
        this.data = data;
        this.next = null;
    }
}

// Klasse für den Stack
public class Stack {
    private Knoten top; // oberstes Element des Stacks

    // Konstruktor
    public Stack() {
        this.top = null;
    }

    // Push() Methode - zum Hinzufügen eines Elements zum Stack
    public void push(Object value) {
        Knoten newKnoten = new Knoten(value);
        newKnoten.next = top;
        top = newKnoten;
    }

    // Methode zum Entfernen des obersten Elements vom Stack (pop)
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack ist leer, kann nicht poppen.");
            return null;
        }
        Object value = top.data;
        top = top.next;
        return value;
    }

    // Methode, um das oberste Element des Stacks zu betrachten, ohne es zu entfernen (top)
    public Object top() {
        if (isEmpty()) {
            System.out.println("Stack ist leer, kein Element zum Top.");
            return null;
        }
        return top.data;
    }

    // Methode, um zu überprüfen, ob der Stack leer ist
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(); // neue Stack-Instanz erzeugen

        stack.push(10);
        stack.push(20);
        stack.push("Test");

        System.out.println("Top Element: " + stack.top());

        System.out.println("Pop Element: " + stack.pop());
        System.out.println("Pop Element: " + stack.pop());
        
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
