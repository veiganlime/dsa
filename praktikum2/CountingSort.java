package praktikum2;

import java.util.Arrays;

public class CountingSort {

    public static int[] countingSort(int[] input) {
        // Minimum und Maximum der Eingabewerte bestimmen
        int min = Arrays.stream(input).min().orElseThrow();
        int max = Arrays.stream(input).max().orElseThrow();
        
        // Count-Array erstellen, das den Bereich von min bis max abbildet
        int range = max - min + 1;
        int[] count = new int[range];

        // Füllen das Count-Array
        for (int num : input) {
            count[num - min]++; // Verschiebung um das Minimum
        }

        // Sortiere das Array anhand des Count-Arrays
        int index = 0;
        int[] sorted = new int[input.length];
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                sorted[index++] = i + min; // Zurückverschiebung um das Minimum
                count[i]--;
            }
        }
        
        return sorted;
    }

    public static void main(String[] args) {
        
        int[] m1 = {1, 17, 3, 1, 4, 9, 4, 4};
        int[] m2 = {1, 13, 3, -1, -9, -4, 4};

        System.out.println("Sortiertes m1: " + Arrays.toString(countingSort(m1)));
        System.out.println("Sortiertes m2: " + Arrays.toString(countingSort(m2)));
    }
}
