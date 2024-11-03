package praktikum1;

import javax.swing.JOptionPane;

public class BinaereSuche {
    public static void main(String[] args) {

        int[] array = {99, 90, 79, 75, 70, 60, 55, 37, 23, 17, 16, 9, 8, 6, 5, 1};

        System.out.println("Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        String eingabe = JOptionPane.showInputDialog("Geben Sie die gesuchte Zahl ein.");

        int ziel = Integer.parseInt(eingabe);
        int position = binaereSuche(array, ziel, 0, array.length - 1);

        if (position != -1) {
            JOptionPane.showMessageDialog(null,"Die Position der gescuhten Zahl ist " + position);
        } else {
            JOptionPane.showMessageDialog(null, "Zahl nicht gefunden.");
        }
    }

    public static int binaereSuche(int[] array, int ziel, int links, int rechts) {
        if (links <= rechts) {

            int mitte = links + (rechts - links) / 2;
            System.out.println("Überprüfe Mitte: " + mitte);

            if (array[mitte] == ziel) return mitte;
            if (array[mitte] > ziel) return binaereSuche(array, ziel, mitte + 1, rechts);

            return binaereSuche(array, ziel, links, mitte - 1);
        }
        return -1;
    }
}