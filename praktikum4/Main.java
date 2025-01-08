package praktikum4;

class Baumknoten {
    int key;
    Baumknoten left, right;

    public Baumknoten(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BinaerSuchbaum {
    private Baumknoten root;

    // Methode zum Hinzufügen eines Elements
    public boolean add(int k) {
        if (root == null) {
            root = new Baumknoten(k);
            return true;
        }
        return addRecursive(root, k);
    }

    private boolean addRecursive(Baumknoten current, int k) {
        if (k == current.key) {
            return false; // Element existiert bereits
        }
        if (k < current.key) {
            if (current.left == null) {
                current.left = new Baumknoten(k);
                return true;
            }
            return addRecursive(current.left, k);
        } else {
            if (current.right == null) {
                current.right = new Baumknoten(k);
                return true;
            }
            return addRecursive(current.right, k);
        }
    }

    // Methode zur Suche nach einem Element
    public boolean find(int k) {
        return findRecursive(root, k);
    }

    private boolean findRecursive(Baumknoten current, int k) {
        if (current == null) {
            return false;
        }
        if (k == current.key) {
            return true;
        }
        return k < current.key ? findRecursive(current.left, k) : findRecursive(current.right, k);
    }

    // Methode zur Ausgabe der Baumstruktur in In-Order
    public void print() {
        System.out.println(inOrderTraversal(root));
    }

    private String inOrderTraversal(Baumknoten current) {
        if (current == null) {
            return "null";
        }
        return "{ " + inOrderTraversal(current.left) + " " + current.key + " " + inOrderTraversal(current.right) + " }";
    }

    // Methode zur Ausgabe der Elemente als sortierte Liste
    public void printSorted() {
        System.out.println(sortedElements(root).toString());
    }

    private java.util.List<Integer> sortedElements(Baumknoten current) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (current != null) {
            result.addAll(sortedElements(current.left));
            result.add(current.key);
            result.addAll(sortedElements(current.right));
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        BinaerSuchbaum tree = new BinaerSuchbaum();
        int[] values = {3, 7, 6, 10, 12, 9};

        for (int value : values) {
            tree.add(value);
        }

        // Ausgabe als Baumstruktur
        tree.print();

        // Ausgabe als sortierte Liste
        tree.printSorted();
    }
}
